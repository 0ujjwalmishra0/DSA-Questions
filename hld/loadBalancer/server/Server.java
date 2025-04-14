package hld.loadBalancer.server;
public class Server {
    String name;
    public int activeConnections;

    public Server(String name) {
        this.name = name;
        this.activeConnections = 0;
    }

    public void handleRequest() {
        activeConnections++;
    }

    public void completeRequest() {
        if (activeConnections > 0) activeConnections--;
    }

    @Override
    public String toString() {
        return name + " (active=" + activeConnections + ")";
    }
}
