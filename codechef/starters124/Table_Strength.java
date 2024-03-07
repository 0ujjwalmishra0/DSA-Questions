package codechef.starters124;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Table_Strength {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();

        int t = scanner.nextInt();
        while (t-->0) {
            int n= scanner.nextInt();
            int a[]= new int[n];
            for (int i = 0; i < n; i++) {
                a[i]= scanner.nextInt();
            }

            System.out.println(findMaximumWeight(a));
        }
    }
    private static int findMaximumWeight(int[] legStrengths) {
        Arrays.sort(legStrengths); // Sort the leg strengths in ascending order
        
        long maxWeight = 0; // Use long to avoid overflow in extreme cases
        for (int i = 0; i < legStrengths.length; i++) {
            // The current leg strength times the number of legs including and stronger than this one
            long currentWeight = (long) legStrengths[i] * (legStrengths.length - i);
            maxWeight = Math.max(maxWeight, currentWeight);
        }

        return (int) maxWeight; // Cast back to int as per problem statement guarantees
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}