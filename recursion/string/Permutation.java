package recursion.string;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
//        permutation("","abc");
        System.out.println(permutationList("","abc"));

        System.out.println(permutationCount("","abc"));
    }

    private static void permutation(String processed,String unprocessed){
        if(unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String first= processed.substring(0,i);
            String second= processed.substring(i,processed.length());
            permutation(first + ch + second,unprocessed.substring(1));
        }

    }

    private static ArrayList<String> permutationList(String processed,String unprocessed){

        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= processed.length(); i++) {
            String f= processed.substring(0,i);
            String s= processed.substring(i,processed.length());
            ans.addAll(permutationList(f+ch+s,unprocessed.substring(1)));
        }
        return ans;

    }


    private static int permutationCount(String processed,String unprocessed){

        if(unprocessed.isEmpty()){
            return 1;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        int count=0;
        for (int i = 0; i <= processed.length(); i++) {
            String f= processed.substring(0,i);
            String s= processed.substring(i,processed.length());
            count = count+ permutationCount(f+ch+s,unprocessed.substring(1));
        }
        return count;

    }
}
