package leetCode.april;

public class P58 {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        String[] list = s.split(" ");
        for (int i = list.length-1; i >=0 ; i--) {
            String str= list[i];
            if(!str.isBlank()){
                return str.length();
            }
        }
        return 0;
    }
}
