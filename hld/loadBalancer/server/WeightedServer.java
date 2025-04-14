package hld.loadBalancer.server;

public class WeightedServer {
    String name;
    public int weight;
    public int currentWeight;

    public WeightedServer(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.currentWeight = 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
