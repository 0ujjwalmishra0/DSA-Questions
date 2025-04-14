package hld.loadBalancer;
import hld.loadBalancer.*;
import hld.loadBalancer.server.Server;
import hld.loadBalancer.server.WeightedServer;

import java.util.*;

// ------------------ SIMULATION ------------------
public class LoadBalancer {
    public static void main(String[] args) {
        List<Server> servers = Arrays.asList(
                new Server("S1"),
                new Server("S2"),
                new Server("S3")
        );

        System.out.println("---- ROUND ROBIN ----");
        RoundRobin rr = new RoundRobin(servers);
        for (int i = 0; i < 9; i++) {
            Server s = rr.getNextServer();
            System.out.println("Request " + i + " → " + s);
        }

//        // Reset connections for Least Connections
//        for (Server s : servers) s.activeConnections = 0;
//
//        System.out.println("\n---- LEAST CONNECTIONS ----");
//        LeastConnection lc = new LeastConnection(servers);
//        for (int i = 0; i < 9; i++) {
//            Server s = lc.getNextServer();
//            System.out.println("Request " + i + " → " + s);
//        }


        System.out.println("==== Weighted Round Robin ====");
        List<WeightedServer> wServers = Arrays.asList(
                new WeightedServer("S1", 1),
                new WeightedServer("S2", 2),
                new WeightedServer("S3", 3)
        );
        WeightedRoundRobin wrb = new WeightedRoundRobin(wServers);
        for (int i = 0; i < 12; i++) {
            System.out.println("Request " + i + " → " + wrb.getNextServer());
        }

        System.out.println("\n==== Sticky Session (IP Hash) ====");
        List<Server> sServers = Arrays.asList(new Server("S1"), new Server("S2"), new Server("S3"));
        StickySession ssb = new StickySession(sServers);
        String[] ips = {"192.168.0.1", "192.168.0.2", "10.0.0.1", "192.168.0.1"};
        for (String ip : ips) {
            System.out.println("IP " + ip + " → " + ssb.getServerForIP(ip));
        }

        System.out.println("\n==== Consistent Hashing ====");
        List<String> chServers = Arrays.asList("S1", "S2", "S3");
        ConsistentHash chb = new ConsistentHash(chServers, 500);
        String[] keys = {"user1", "user2", "user3", "user1", "fileX", "sessionY"};
        for (String key : keys) {
            System.out.println("Key " + key + " → " + chb.getServer(key));
        }
    }
}
