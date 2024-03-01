package recursion;

public class SkipChar {
    public static void main(String[] args) {
        String s= "Ujjwal Kumar";
        System.out.println(skip(s,'j'));
    }

    private static String skip(String s,Character charToSkip){
        if(s.isEmpty()) return "";
        if(s.charAt(0)!=charToSkip){
            return s.charAt(0)+ skip(s.substring(1),charToSkip);
        }
        return skip(s.substring(1),charToSkip);
    }

}
