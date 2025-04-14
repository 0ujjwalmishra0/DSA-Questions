package hld.loadBalancer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
// ---------------- Consistent Hashing Balancer ----------------
class ConsistentHash {
    private final TreeMap<Integer, String> ring = new TreeMap<>();
    private final int virtualNodes;
    private final List<String> serverIds;

    public ConsistentHash(List<String> servers, int virtualNodes) {
        this.virtualNodes = virtualNodes;
        this.serverIds = servers;
        for (String server : servers) {
            for (int i = 0; i < virtualNodes; i++) {
                String virtualNode = server + "-VN" + i;
                int hash = hash(virtualNode);
                ring.put(hash, server);
            }
        }
    }

    public String getServer(String key) {
        int hash = hash(key);
        Map.Entry<Integer, String> entry = ring.ceilingEntry(hash);
        if (entry == null) {
            return ring.firstEntry().getValue();
        }
        return entry.getValue();
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
