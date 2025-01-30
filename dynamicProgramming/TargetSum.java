package dynamicProgramming;

import java.util.ArrayList;

public class TargetSum {
    public static void main(String[] args) {
        int [] a= new int[]{1,2,3,1};
        ArrayList<Integer> ans= solveRec(a,new ArrayList<>(),a.length-1,3);
        System.out.println(ans.toString());
    }

    private static ArrayList<Integer> solveRec(int[] a, ArrayList<Integer> ans, int index, int target){
        if(index==0 && target==a[0]){
            ans.add(a[0]);
            return ans;
        }

        if(index==0) return null;
        ArrayList<Integer> add= solveRec(a,ans,index-1,target-a[0]);
        ArrayList<Integer> sub= solveRec(a,ans,index-1,target+a[0]);
        ans.addAll(add);
        ans.addAll(sub);
        return ans;
    }
}
