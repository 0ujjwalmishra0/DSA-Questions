package hld.loadBalancer;

import hld.loadBalancer.server.Server;

import java.util.List;

// ------------------ LEAST CONNECTIONS ------------------
class LeastConnection {
    private List<Server> servers;

    public LeastConnection(List<Server> servers) {
        this.servers = servers;
    }

    public Server getNextServer() {
        Server best = servers.get(0);
        for (Server s : servers) {
            if (s.activeConnections < best.activeConnections) {
                best = s;
            }
        }
        best.handleRequest();
        return best;
    }
}
