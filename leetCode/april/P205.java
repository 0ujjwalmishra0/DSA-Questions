package leetCode.april;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class P205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba","aaabbbba"));
    }
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> mapS2T= new HashMap<>();
        HashMap<Character,Character> mapT2S= new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if there's a mapping for charS in mapS2T and if it maps to the same character in t
            if (mapS2T.containsKey(charS)) {
                if (mapS2T.get(charS) != charT) {
                    return false;
                }
            } else { // If no mapping exists, check if charT is already mapped to some other character in mapT2S
                if (mapT2S.containsKey(charT)) {
                    return false;
                }

                // Create new mapping since it's valid
                mapS2T.put(charS, charT);
                mapT2S.put(charT, charS);
            }
        }
        return true;
    }
    public static boolean isIsomorphic2(String s, String t) {
        HashMap<Character,Character> mapS2T= new HashMap<>();
        HashSet<Character> setCharT= new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if there's a mapping for charS in mapS2T and if it maps to the same character in t
            if (mapS2T.containsKey(charS)) {
                if (mapS2T.get(charS) != charT) {
                    return false;
                }
            } else { // If no mapping exists, check if charT is already mapped to some other character in setCharT
                if (setCharT.contains(charT)) {
                    return false;
                }

                // Create new mapping since it's valid
                mapS2T.put(charS, charT);
                setCharT.add(charT);
            }
        }
        return true;
    }
}
