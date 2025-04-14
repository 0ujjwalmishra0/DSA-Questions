package hld;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConsistentHashingRingSimulator {

    static class ConsistentHashRing {
        private final TreeMap<Integer, String> ring = new TreeMap<>();
        private final int virtualNodes;
        private final Set<String> servers = new HashSet<>();

        public ConsistentHashRing(int virtualNodes) {
            this.virtualNodes = virtualNodes;
        }

        public void addServer(String serverId) {
            servers.add(serverId);
            for (int i = 0; i < virtualNodes; i++) {
                String virtualNodeKey = serverId + "-VN" + i;
                int hash = hash(virtualNodeKey);
                ring.put(hash, serverId);
            }
        }

        public void removeServer(String serverId) {
            servers.remove(serverId);
            for (int i = 0; i < virtualNodes; i++) {
                String virtualNodeKey = serverId + "-VN" + i;
                int hash = hash(virtualNodeKey);
                ring.remove(hash);
            }
        }

        public String getServer(String key) {
            if (ring.isEmpty()) return null;
            int hash = hash(key);
            SortedMap<Integer, String> tailMap = ring.tailMap(hash);
            int serverHash = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();
            return ring.get(serverHash);
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

    public static void main(String[] args) {
        int numKeys = 1000;
        int virtualNodes = 500;
        int initialServers = 3;
        int finalServers = 6;

        ConsistentHashRing ringBefore = new ConsistentHashRing(virtualNodes);
        ConsistentHashRing ringAfter = new ConsistentHashRing(virtualNodes);

        for (int i = 0; i < initialServers; i++) {
            ringBefore.addServer("S" + i);
            ringAfter.addServer("S" + i);
        }

        // Add one new server to ringAfter
        ringAfter.addServer("S" + initialServers);

        int movedKeys = 0;

        Map<String, String> beforeMap = new HashMap<>();
        Map<String, String> afterMap = new HashMap<>();
        Map<String, Integer> distributionBefore = new HashMap<>();
        Map<String, Integer> distributionAfter = new HashMap<>();

        for (int i = 0; i < numKeys; i++) {
            String key = "KEY" + i;
            String serverBefore = ringBefore.getServer(key);
            String serverAfter = ringAfter.getServer(key);

            beforeMap.put(key, serverBefore);
            afterMap.put(key, serverAfter);

            distributionBefore.put(serverBefore, distributionBefore.getOrDefault(serverBefore, 0) + 1);
            distributionAfter.put(serverAfter, distributionAfter.getOrDefault(serverAfter, 0) + 1);

            if (!serverBefore.equals(serverAfter)) {
                movedKeys++;
            }
        }

        double movedPercentage = (movedKeys * 100.0) / numKeys;

        System.out.printf("Reassigned Keys: %.2f%%\n\n", movedPercentage);

        System.out.println("Key Distribution Before Adding Server:");
        distributionBefore.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\nKey Distribution After Adding Server:");
        distributionAfter.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}

