package recursion.string;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static void main(String[] args) {
//        subsequence("","abc");
        System.out.println(subsequence("","abc",new ArrayList<>()));
    }

    private static void subsequence(String processed,String unProcessed){
        if(unProcessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        //take first char make 2 recursion calls- take it or ignore it
        Character c = unProcessed.charAt(0);
        subsequence(processed+c,unProcessed.substring(1));
        subsequence(processed,unProcessed.substring(1));
    }

    private static ArrayList<String> subsequence(String processed, String unProcessed,ArrayList<String> list){
        if(unProcessed.isEmpty()){
            list.add(processed);
            return list;
        }
        //take first char make 2 recursion calls- take it or ignore it
        Character c = unProcessed.charAt(0);
        subsequence(processed+c,unProcessed.substring(1),list);
        subsequence(processed,unProcessed.substring(1),list);
        return list;
    }
    private static ArrayList<String> subsequence2(String processed, String unProcessed){
        if(unProcessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        //take first char make 2 recursion calls- take it or ignore it
        Character c = unProcessed.charAt(0);
        ArrayList<String> left = subsequence2(processed+c,unProcessed.substring(1));
        ArrayList<String> right = subsequence2(processed,unProcessed.substring(1));
        //get ans from below call, combine and return
        left.addAll(right);
        return left;
    }

    private List<List<Integer>> iterativeSubset(int [] arr){
        List<List<Integer>> outer= new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num: arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);

            }
        }
        return outer;
    }



}
