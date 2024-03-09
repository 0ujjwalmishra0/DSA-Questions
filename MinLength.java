public class MinLength {
    public static void main(String[] args) {
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
        System.out.println(minimumLength("ac"));
    }
    public static int minimumLength(String s) {
        int start=0,end=s.length()-1;
        boolean isOneFound=false;
        while(start<end){

            if(s.charAt(start)==s.charAt(end)) {
                start++;
                end--;
                isOneFound=true;
                //check on left to right side for continuos char
                while (start < end && (s.charAt(start) == s.charAt(start - 1))) {
                    start++;

                }

                //check on right to left side for continuos char
                while (start < end && (s.charAt(end) == s.charAt(start + 1))) {
                    end--;
                }
            }
            else{
                break;
            }

        }
        return isOneFound? end-start: end-start+1;
    }
}
