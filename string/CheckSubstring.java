package string;

public class CheckSubstring {
    // Function to locate the occurrence of the string x in the string s.
    static int firstOccurence(String txt, String pat) {
        for (int i = 0; i <= txt.length() - pat.length(); i++) {
            int j = 0;
            while (j < pat.length() && txt.charAt(i + j) == pat.charAt(j)) {
                j++;
            }
            if (j == pat.length()) {
                return i; // Return the starting index of the first occurrence
            }
        }
        return -1; // Pattern not found
    }

    public static void main(String[] args) {
        int res= firstOccurence("GeeksForGeeks","for");
        System.out.println(res);
    }

}
