package leetCode.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class P1249 {
    public static void main(String[] args) {
//        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
//        System.out.println(minRemoveToMakeValid("))(("));
    }
    public static String minRemoveToMakeValid(String s) {
        boolean[] safe= new boolean[s.length()];
        int[] openingCounter= new int[s.length()];

        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(c!=')' && c!='('){
                safe[i]=true;
            }
            else if(c=='('){
                openingCounter[i]=1;
            }
            //for ) search for (
            else {
                for(int j=i;j>=0;j--){
                    if(openingCounter[j]==1){
                        openingCounter[j]=2;
                        safe[i]=true;
                        safe[j]=true;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            if(safe[i]){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
