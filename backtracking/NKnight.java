package backtracking;

public class NKnight {
    public static void main(String[] args) {
        int n= 4;
        boolean [][] board = new boolean[n][n];
//        int count= nKnight(board,0,0,n);
//        System.out.println("count : "+ count);

        int count= placeKnights(board,0,0,0);
        System.out.println("count : "+ count);
    }


    private static int nKnight(boolean [][] visited,int row,int col,int knights){
        if(knights==0){
            displayBoard(visited);
            System.out.println();
            return 1;
        }
        if(row==visited.length-1 && col==visited[0].length){
            return 0;
        }
        int count=0;

        if(col==visited.length){
            return count+= nKnight(visited,row+1,0,knights);
        }

        if(isSafe(visited,row,col)){
            visited[row][col]=true;
            count+= nKnight(visited,row,col+1,knights-1);
            visited[row][col]=false;
        }
        //if not safe just move ahead
        count+= nKnight(visited,row,col+1,knights);
        return count;
    }



    private static int placeKnights(boolean[][] board, int row, int col, int knightsPlaced) {
        if (knightsPlaced == board.length) {
            displayBoard(board);
            System.out.println();
            return 1; // Base case: all knights placed
        }
        int count = 0;
        for (int i = row; i < board.length; i++, col = 0) { // Reset col for new rows
            for (int j = col; j < board[0].length; j++) {
                if (isSafe(board, i, j)) {
                    board[i][j] = true;
                    count += placeKnights(board, i, j + 1, knightsPlaced + 1);
                    board[i][j] = false; // Backtrack
                }
            }
        }
        return count;
    }


//
//    private static void nKnight(boolean [][] visited,int row,int col,int knights){
//        if(knights==0){
//            displayBoard(visited);
//            System.out.println();
//            return;
//        }
//        if(row==visited.length-1 && col==visited[0].length){
//            return;
//        }
//
//        if(col==visited.length){
//            nKnight(visited,row+1,0,knights);
//            return;
//        }
//
//        if(isSafe(visited,row,col)){
//            visited[row][col]=true;
//            nKnight(visited,row,col+1,knights-1);
//            visited[row][col]=false;
//        }
//        //if not safe just move ahead
//        nKnight(visited,row,col+1,knights);
//    }
    private static boolean isSafe(boolean [][] visited,int row,int col){
        int[] rowOffsets = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] colOffsets = {-1, 1, -2, 2, -2, 2, -1, 1};
        for (int i = 0; i < 8; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];
            if (newRow >= 0 && newRow < visited.length && newCol >= 0 && newCol < visited.length && visited[newRow][newCol]) {
                return false; // Another knight is attacking this position
            }
        }
        return true;
    }

    private static boolean isValid(boolean [][] visited,int row,int col){
        return row >= 0 && row <= visited.length - 1 && col >= 0 && col <= visited[0].length - 1;
    }
    private static void displayBoard(boolean[][] board) {
        for (boolean[] row: board){
            for (boolean element: row){
                if(element){
                    System.out.print("K ");
                } else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
