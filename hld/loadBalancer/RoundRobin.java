package hld.loadBalancer;
import hld.loadBalancer.server.Server;

import java.util.List;

// ------------------ ROUND ROBIN ------------------
class RoundRobin {
    private List<Server> servers;
    private int currentIndex = 0;

    public RoundRobin(List<Server> servers) {
        this.servers = servers;
    }

    public Server getNextServer() {
        Server server = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % servers.size();
        server.handleRequest();
        return server;
    }
}
