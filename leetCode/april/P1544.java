package leetCode.april;

import java.util.Stack;

public class P1544 {
    public static void main(String[] args) {
//        System.out.println(makeGood("abBAcC"));
//        System.out.println(makeGood("leEeetcode"));
//        System.out.println(makeGood("djrDdRJD"));
//        System.out.println(makeGood("qFxXfQo"));
        System.out.println(makeGood("SAYTTveEVttyaswmMwnNCMmcnNWmMWhIgZyWnFirRIfNwYzGiHhH"));
    }
    public static String makeGood2(String s) {
        StringBuilder sb= new StringBuilder();
        int n =s.length();
        for(int t=0;t<n && !s.isBlank();t++) {
            s= calc(s,sb);
        }
        return String.valueOf(s);
    }

    public static String makeGood(String s) {
        Stack<Character> stack= new Stack<>();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(c- stack.peek())==32){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static String calc(String s,StringBuilder sb){
        sb = new StringBuilder();
        int diff= 97-65;
        if(s.length()<2) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == diff) {
                i++;
                continue;
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (Math.abs(s.charAt(s.length() - 1) - s.charAt(s.length() - 2)) != diff) {
            sb.append(s.charAt(s.length() - 1));
        }
        s= sb.toString();
        return s;
    }
}
