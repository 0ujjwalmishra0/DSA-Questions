package leetCode.april;

import java.util.Stack;

public class P1614 {
    public static void main(String[] args) {
        String s1= "(1+(2*3)+((8)/4))+1";
        String s2= "(1)+((2))+(((3)))";
        String s3= "1+(2*3)/(2-1)";
        System.out.println(maxDepth(s1));
    }
    public static int maxDepth(String s) {
        s= s+" ";
        int max=0;
        Stack<Character> stack= new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            if(c=='('){
                stack.add(c);
            }
            max= Math.max(max,stack.size());
            if(c==')'){
                stack.pop();
            }

        }
        return max;
    }
}
