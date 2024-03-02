package assignments.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodeNQueen {
    public static void main(String[] args) {
        List<List<String>> ans= solveNQueens(4);
        for(List<String> row:ans){
            for (String s: row){
                System.out.print(s);
            }
            System.out.println();
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        boolean[][] visited= new boolean[n][n];
        return solve(visited,0,0);
    }

    private static List<List<String>> solve(boolean[][] visited,int row,int queenPlaced){
        int n= visited.length;
        List<List<String>> ans= new ArrayList<>();
        if(queenPlaced==n || row==n){
            ans.add(fillList(visited));
            return ans;
        }

        for (int col = 0; col < n; col++) {
            if(isSafe2(visited,row,col)){
                visited[row][col]= true;
                ans.addAll(solve(visited,row+1,queenPlaced+1));
                visited[row][col]=false;
            }
        }
        return ans;
    }

    private static List<String> fillList(boolean[][] visited) {
        List<String> result = new ArrayList<>();
        for (boolean[] row : visited) {
            StringBuilder sb = new StringBuilder();
            for (boolean cell : row) {
                sb.append(cell ? "Q" : ".");
            }
            result.add(sb.toString());
        }
        return result;
    }

    private static boolean isValid(boolean[][] visited,int row,int col){
        //check boundaries
        if(row<0 || row> visited.length-1 || col<0 || col>visited.length-1){
            return false;
        }
        return true;
    }

    private static boolean isSafe2(boolean[][] visited, int row,int col){
        if(!isValid(visited,row,col)){
            return false;
        }
        //check horizontal

        for (int i = 0; i < row; i++) {
            if(isValid(visited,i,col)){
                if(visited[i][col]){
                    return false;
                }
            }
        }
        //check for vertical
        for (int i = row; i >= 0; i--) {
            if(isValid(visited,i,col)) {
                if (visited[i][col]) {
                    return false;
                }
            }
        }

        //for checking left diagonal

        int maxLeft = Math.min(row, col);
        //check for diagonal
        int maxLeftStep = Math.min(row,col);
        int maxRightStep = Math.min(row,visited.length-1-col);

        for (int i = 1; i <= maxLeftStep; i++) {
            if(isValid(visited,row-i,col-i)) {
                if (visited[row - i][col-i]) {
                    return false;
                }
            }
        }

        for (int i = 1; i <= maxRightStep; i++) {
            if(isValid(visited,row-i,col+i)) {
                if (visited[row - i][col+i]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isSafe(boolean[][] visited, int row, int col) {
        // Check for queen in the same column
        for (int i = 0; i < row; i++) {
            if (visited[i][col]) {
                return false;
            }
        }

        // Check for queen on the left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (visited[i][j]) {
                return false;
            }
        }

        // Check for queen on the right diagonal
        for (int i = row, j = col; i >= 0 && j < visited.length; i--, j++) {
            if (visited[i][j]) {
                return false;
            }
        }

        return true;
    }

}
