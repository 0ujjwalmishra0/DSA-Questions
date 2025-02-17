package leetCode.feb2025;

public class LeetCode1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int first=-1,second=-1;
        if(s1.length()!=s2.length()) return false;

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(first==-1){
                    first=i;
                } else if(second==-1){
                    second=i;
                } else{
                    return false;
                }
            }
        }
        return true;
    }
}
