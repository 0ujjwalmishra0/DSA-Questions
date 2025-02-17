package leetCode.feb2025;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1079 {
    public static void main(String[] args) {
        LeetCode1079 lc = new LeetCode1079();
        int res= lc.numTilePossibilities("AAABBC");
        System.out.println(res);
    }
    public int numTilePossibilities(String tiles) {
        // Count the frequency of each character
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Calculate the total number of unique strings
        return backtrack(map);
    }

    private int backtrack(Map<Character, Integer> map) {
        int sum = 0;
        for (char c : map.keySet()) {
            if (map.get(c) > 0) {
                // Use the current character
                sum++; // Count this as a new string
                map.put(c, map.get(c) - 1); // Decrement frequency
                sum += backtrack(map); // Recurse
                map.put(c, map.get(c) + 1); // Backtrack (restore frequency)
            }
        }
        return sum;
    }
}
