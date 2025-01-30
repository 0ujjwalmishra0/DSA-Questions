package slidingWindow;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        char[] c = new char[]{'c','c','c','a','c','a','b','b','c'};
        int res = findLongestSubstr(c);
        System.out.println(res);
    }

    private static int findLongestSubstr(char [] charArray){
        int n= charArray.length;
        int l=0,r=0,maxLen=0;
        int[] hash = new int[26];
        while (r<n){
            int index= hash[charArray[r]-'a'];
            int length=0;
            if(index>0 && index>=l){
                l=index+1;
            }
            length= r-l+1;
            maxLen= Math.max(maxLen,length);
            hash[charArray[r]-'a']=r;
            r++;
        }
        return maxLen;
    }
}
