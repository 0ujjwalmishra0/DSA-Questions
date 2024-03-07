package codechef.starters124;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Swap_and_Unite {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();

        int t = scanner.nextInt();
        while (t-->0) {
            String s= scanner.nextLine();
            System.out.println(minSwapsToMakeCharContiguous(s));
        }

    }

    private static int minSwapsToMakeCharContiguous(String s) {
        int globalMinSwaps = Integer.MAX_VALUE;
        // Iterate through all characters from 'a' to 'z'
        for (char c = 'a'; c <= 'z'; c++) {
            if(s.contains()) {
                int minSwapsForChar = calculateMinSwapsForChar(s, c);
                globalMinSwaps = Math.min(globalMinSwaps, minSwapsForChar);
            }
        }

        return globalMinSwaps;
    }

    private static int calculateMinSwapsForChar(String s,Character c) {
        int n= s.length();
        int countChar=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==c){
                countChar++;
            }
        }
        if(countChar==0) return 0; // if count of char is 0, swaps needed is 0
        // Array to keep track of character occurrences in a sliding window
        int[] windowOccurrences = new int[n];
        for (int i = 0; i < countChar; i++) {
            if (s.charAt(i) == c) windowOccurrences[0]++;
        }
        //Fill the rest of the occurrences using sliding window
        for (int i = 1; i <= n - countChar; i++) {
            windowOccurrences[i] = windowOccurrences[i - 1];
            if (s.charAt(i - 1) == c) windowOccurrences[i]--;
            if (s.charAt(i + countChar - 1) == c) windowOccurrences[i]++;
        }

        // Find the minimum swaps needed
        int minSwaps = countChar; // Maximum swaps equal to all occurrences not being contiguous
        for (int i = 0; i <= n - countChar; i++) {
            // Minimum swaps for this window is the number of missing occurrences
            // which is total occurrences minus occurrences already in the window
            minSwaps = Math.min(minSwaps, countChar - windowOccurrences[i]);
        }

        return minSwaps;

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