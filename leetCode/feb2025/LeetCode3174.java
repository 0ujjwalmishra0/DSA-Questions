package leetCode.feb2025;

import java.util.ArrayList;

public class LeetCode3174{
    public static void main(String[] args) {
        System.out.println(clearDigits("4b34"));
    }
    private static String clearDigits(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0;i<chars.length;i++) {
            if (isDigit(chars[i])) {
                list.add(i);
            }
        }
        int offset=0;
        for (int i: list) {
            i=i-offset;
            if(isDigit(sb.charAt(i)) && i > 0 && !isDigit(sb.charAt(i-1))){
                sb.delete(i-1,i+1);
                offset+=2;
            }
        }
        return sb.toString();
    }

    private static boolean isDigit(char c) {
        int digit = c - '0';
        if (digit >= 0 && digit <= 9) {
            return true;
        }
        return false;
    }
}
