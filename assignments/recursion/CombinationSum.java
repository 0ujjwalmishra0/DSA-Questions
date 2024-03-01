package assignments.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int [] candidates = {2,3,6,7};
        int target= 7;
//        System.out.println(combinationSum(candidates,target));
        solve(candidates,new ArrayList<>(),target,0);
    }

//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        solve(candidates,new ArrayList<Integer>(),target,0,0);
//    }

    private static void solve(int [] unprocessed,List<Integer>processed, int target,int index){
        if(index==unprocessed.length) return;
        List<List<Integer>> list=new ArrayList<>();
        processed.add(unprocessed[index]);
        int sum= sum(processed);
            if(sum<=target) {
                if (sum == target) {
                    list.add(processed);
                    System.out.println(list);
                    processed=new ArrayList<>();
                }
                solve(unprocessed, processed, target, index + 1);
                processed.removeLast();
                solve(unprocessed, processed, target, index);

        }
    }

    private static int sum(List<Integer> a){
        int sum=0;
        for(int n:a){
            sum=sum+n;
        }
        return sum;
    }
}
