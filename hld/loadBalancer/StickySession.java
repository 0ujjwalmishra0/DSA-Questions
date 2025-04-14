package hld.loadBalancer;
import hld.loadBalancer.server.Server;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

// ---------------- STICKY SESSION (IP HASH) ------------------
class StickySession {
    List<Server> servers;

    public StickySession(List<Server> servers) {
        this.servers = servers;
    }

    public Server getServerForIP(String ip) {
        int index = Math.abs(hash(ip)) % servers.size();
        Server server=  servers.get(index);
        server.handleRequest();
        return server;
    }

    private int hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(key.getBytes());
            int hash = ((bytes[0] & 0xFF) << 24) | ((bytes[1] & 0xFF) << 16)
                    | ((bytes[2] & 0xFF) << 8) | (bytes[3] & 0xFF);
            return hash & 0x7FFFFFFF; // positive int
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}