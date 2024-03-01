package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueen {
    public static void main(String[] args) {
        int n=4;
        boolean [][] board = new boolean[n][n];
//        System.out.println(queen(board,0));
        ArrayList<ArrayList<QueenPosition>> ans = queenList(board,0);
        System.out.println("Total possible ways: "+ans.size());
        System.out.println(ans.toString());
    }

    private static int queen(boolean [][] board, int row){
        if (row==board.length){
            displayBoard(board);
            System.out.println();
            return 1;
        }
        int count=0;
        //placing queen and checking for every row and col
        for (int col = 0; col < board[0].length; col++) {
            //check if safe to place queen
            if(isSafe(board,row,col)){
                board[row][col]=true;
                count+= queen(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }

    private static ArrayList<ArrayList<QueenPosition>> queenList(boolean [][] board, int row){
        ArrayList<ArrayList<QueenPosition>> ans=new ArrayList<ArrayList<QueenPosition>>();
        if (row==board.length){
            ans.add(returnBoard(board));
            return ans;
        }
        int count=0;
        //placing queen and checking for every row and col
        for (int col = 0; col < board[0].length; col++) {
            //check if safe to place queen
            if(isSafe(board,row,col)){
                board[row][col]=true;
                ans.addAll(queenList(board,row+1));
                board[row][col]=false;
            }
        }
        return ans;
    }

    private static boolean isSafe(boolean[][] board,int row,int col){
        //check vertical row
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                //queen is already placed,hence not safe
                return false;
            }
        }
        //check left diagonal
        int maxLeft= Math.min(row,col); //max left steps diagonally
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]){
                //if queen is found not safe
                return false;
            }
        }
        //check right diagonal
        int maxRight= Math.min(board.length-1-col,row); //max right steps diagonally
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]){
                //if queen is found not safe
                return false;
            }
        }
        return true;
    }

    private static void displayBoard(boolean[][] board) {
        for (boolean[] row: board){
            for (boolean element: row){
                if(element){
                    System.out.print("Q ");
                } else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    private static ArrayList<QueenPosition> returnBoard(boolean[][] board) {
        ArrayList<QueenPosition> index= new ArrayList<>();
        for (int i = 0, boardLength = board.length; i < boardLength; i++) {
            for (int j = 0, rowLength = board[i].length; j < rowLength; j++) {
                if (board[i][j]) {
                    index.add(new QueenPosition(i,j));
                }
            }
        }
        return index;
    }
}

class QueenPosition{
    int row;
    int col;
    public QueenPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "("+ row +
                "," + col +
                ')';
    }
}
