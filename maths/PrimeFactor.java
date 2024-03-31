package maths;

import java.util.ArrayList;

public class PrimeFactor {
    public static void main(String[] args) {
        System.out.println(findPrimeFactor(37));
    }

    private static ArrayList<Integer> findPrimeFactor(int n){
        ArrayList<Integer> primeFactors= new ArrayList<>();
        for (int i = 2; i*i <=n ; i++) {
            if(n%i==0) {
                //if want distinct add here only not in while loop
                //primeFactors.add(i);
                while (n % i == 0) {
                    n = n / i;
                    primeFactors.add(i);
                }
            }
        }
        if(n!=1) primeFactors.add(n);
        return primeFactors;
    }
}
