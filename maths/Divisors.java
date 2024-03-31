package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Divisors {
    public static void main(String[] args) {
        printDivisors(36);
        System.out.println();
        printDivisors2(36);
    }

    private static void printDivisors(int n){
        for (int i = 1; i <= n; i++) {
            if(n%i==0){
                System.out.print(n/i+" ");
            }
        }
    }
    private static void printDivisors2(int n){
        ArrayList<Integer> ans=new ArrayList<>();
        for (int i = 1; i*i <= n; i++) {
            if(n%i==0){
                ans.add(i);
            }
            if(n/i!=i){
                ans.add(n/i);
            }
        }
        Collections.sort(ans);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}
