package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class CustomSortString {
    public static void main(String[] args) {
        String order= "kqep";
        String s="pekeq";
        System.out.println(customSortString(order,s));
    }
    public static String customSortString(String order, String s) {
        HashMap<Character,Integer> appear = new HashMap<>();
        StringBuilder result= new StringBuilder();

        for(char c: s.toCharArray()){
            appear.put(c,appear.getOrDefault(c,0)+1);
        }

        for(char c: order.toCharArray()){
            if(appear.containsKey(c)){
                result.append(String.valueOf(c).repeat(Math.max(0,appear.get(c))));
                appear.remove(c);
            }
        }

        for(char c: appear.keySet()){
            result.append(String.valueOf(c).repeat(Math.max(0,appear.get(c))));
        }
        return result.toString();
    }
}
