package hld.loadBalancer;
import hld.loadBalancer.server.WeightedServer;

import java.util.*;

// --------------- WEIGHTED ROUND ROBIN -----------------
class WeightedRoundRobin {
    List<WeightedServer> servers;
    int totalWeight;

    public WeightedRoundRobin(List<WeightedServer> servers) {
        this.servers = servers;
        this.totalWeight = servers.stream().mapToInt(s -> s.weight).sum();
    }

    public WeightedServer getNextServer() {
        WeightedServer best = null;
        for (WeightedServer s : servers) {
            s.currentWeight += s.weight;
            if (best == null || s.currentWeight > best.currentWeight) {
                best = s;
            }
        }
        best.currentWeight -= totalWeight;
        return best;
    }
}



