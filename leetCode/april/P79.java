package leetCode.april;

import java.util.HashSet;

public class P79 {
    public static void main(String[] args) {
        char[][] board= new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        char[][] board2= new char[][]{{'a','z'}};
        P79 p79= new P79();
        System.out.println(p79.exist(board2,"az"));
    }

    public boolean exist(char[][] board, String word) {
        int[] a = new int[58];
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                char c = chars[j];
                a[c - 'A']++;
            }
        }
        for (int i = 0; i < word.length(); i++) {
            char s= word.charAt(i);
            if(a[s-'A']==0){
                return false;
            }else{
                a[s-'A']--;
            }
        }
        return true;
    }

}
