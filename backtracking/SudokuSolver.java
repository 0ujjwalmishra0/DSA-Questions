package backtracking;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board= new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);

    }

    public static void solveSudoku(char[][] board) {
        int[][] newBoard = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='.'){
                    newBoard[i][j]= 0;
                } else {
                    newBoard[i][j] = board[i][j] - '0';
                }
            }
        }
        boolean isSudokuSolved= solve(newBoard);
        if(isSudokuSolved){
//            displayBoard(newBoard,board);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j]= (char)(newBoard[i][j]+'0');
                }
            }
        }
    }

    private static boolean solve(int [][] board){
        int row=-1,col=-1;
        boolean emptyLeft=true;
        //finding empty spaces-> 0
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    emptyLeft=false;
                    break;
                }
            }
            //if you found empty element return
            if(emptyLeft==false){
                break;
            }
        }
        if(emptyLeft){
            return true;
        }

        for (int number = 1; number < 10; number++) {
           if(isSafe(board,row,col,number)){
               board[row][col]= number;
               if(solve(board)){
                   //found the ans
                   return true;
               }else{
                   //backtrack
                   board[row][col]=0;
               }
           }
        }
        return false;
    }

    private static boolean isSafe(int[][] board,int row,int col,int number){
        //check all column of that row
        for (int i = 0; i < board[0].length; i++) {
            if(number==board[row][i]){
                return false;
            }
        }
        //check all row of that col
        for (int i = 0; i < board.length; i++) {
            if(number==board[i][col]){
                return false;
            }
        }

        int startRow= row/3*3,startCol= col/3*3;
        //check sub matrix of that cell
        for (int i = startRow; i < startRow+3; i++) {
            for (int j = startCol; j < startCol+3; j++) {
                if(number==board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    private static void displayBoard(int[][] board) {
        System.out.print("[");
        for (int[] row: board){
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                if(i==row.length-1){
                    System.out.print("\""+row[i]+ "\"");
                }else {
                    System.out.print("\"" + row[i] + "\",");
                }
            }
            System.out.print("]");
        }
        System.out.print("]");
    }
}
