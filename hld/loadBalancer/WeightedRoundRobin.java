package hld.loadBalancer;
import java.util.*;

// --------------- WEIGHTED ROUND ROBIN -----------------
class WeightedRoundRobin {
    List<hld.loadBalancer.server.WeightedServer> servers;
    int totalWeight;

    public WeightedRoundRobin(List<hld.loadBalancer.server.WeightedServer> servers) {
        this.servers = servers;
        this.totalWeight = servers.stream().mapToInt(s -> s.weight).sum();
    }

    public hld.loadBalancer.server.WeightedServer getNextServer() {
        hld.loadBalancer.server.WeightedServer best = null;
        for (hld.loadBalancer.server.WeightedServer s : servers) {
            s.currentWeight += s.weight;
            if (best == null || s.currentWeight > best.currentWeight) {
                best = s;
            }
        }
        best.currentWeight -= totalWeight;
        return best;
    }
}



