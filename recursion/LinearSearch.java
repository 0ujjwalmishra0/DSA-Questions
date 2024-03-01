package recursion;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,6,4,1,3,4};
        System.out.println(isSorted(a,0));
        System.out.println(findAllIndex(a,4,0,new ArrayList<>()));
        System.out.println(findFirstIndex(a,4,0));
        System.out.println(findLastIndex(a,4,0));
        System.out.println(findAllIndex(a,4,0));
    }
    private static boolean isSorted(int [] a,int start){
        while(start<a.length-1){
            if(a[start]>a[start+1]){
                return false;
            }
            return isSorted(a,++start);
        }
        return true;
    }

    private static ArrayList<Integer> findAllIndex(int a[],int target,int start,ArrayList<Integer> list){
        if(start==a.length) return list;
        if(a[start]==target){
            list.add(start);
        }
        return findAllIndex(a,target,start+1,list);
    }
    private static ArrayList<Integer> findAllIndex(int a[],int target,int start){
        ArrayList<Integer> list= new ArrayList<>();
        if(start==a.length) return list;
        if(a[start]==target){
            list.add(start);
        }
        ArrayList<Integer> ansFromBelowCalls =  findAllIndex(a,target,start+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }

    private static int findFirstIndex(int a[],int target,int start){
        if(start==a.length) return -1;
        if(a[start]==target) return start;
        return findFirstIndex(a,target,start+1);
    }
    private static int findLastIndex(int a[],int target,int start){
        if(start==a.length) return -1;
        if(a[start]==target) {
            return Math.max(start,findLastIndex(a,target,start+1));
        }
        return findLastIndex(a,target,start+1);
    }
}
