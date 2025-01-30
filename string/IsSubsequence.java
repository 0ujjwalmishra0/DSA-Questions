package string;

//https://leetcode.com/problems/is-subsequence/
public class IsSubsequence {
    public static void main(String[] args) {
        String s="b";
        String t="abc";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        int j=0;
        for(int i=0;i<t.length();i++){
            if(j<s.length() && t.charAt(i)==s.charAt(j)){
                j++;
            }
        }
        if(j==s.length()){
            return true;
        }
        return false;
    }
}
