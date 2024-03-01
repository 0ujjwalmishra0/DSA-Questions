package recursion.Maze;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPathAllDirection {
    public static void main(String[] args) {
        boolean isPathOpen [][]= {
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        int[][] ans= new int[isPathOpen.length][isPathOpen[0].length];
//        System.out.println(findPath3("",isPathOpen,0,0));
//        findPath2("",isPathOpen,0,0);
        findPathPrint("",isPathOpen,ans,0,0,1);
    }

    private static void findPathPrint(String path, boolean [][] isPathOpen,int[][] ans, int r, int c,int step){
        if (r== isPathOpen.length-1 && c == isPathOpen[0].length-1){
            System.out.println(path);
            for (int a[]:ans){
                System.out.println(Arrays.toString(a));
                System.out.println();
            }
            return;
        }

        if (!isPathOpen[r][c]) return;
            //mark current block as visited
            isPathOpen[r][c]=false;
            ans[r][c]=step;

            if (r < isPathOpen.length - 1) {
                findPathPrint(path + 'D', isPathOpen,ans, r + 1, c,step+1);
            }
            if (c < isPathOpen[0].length - 1) {
                findPathPrint(path + 'R', isPathOpen,ans, r, c + 1,step+1);
            }
            if(r>0){
                findPathPrint(path + 'U', isPathOpen,ans, r - 1, c,step+1);
            }
            if(c>0){
                findPathPrint(path + 'L', isPathOpen,ans, r , c-1,step+1);
            }
        //this line is where function will be over
        //so before the function gets removed also remove changes made by that function
        isPathOpen[r][c]= true;
        ans[r][c]=0;

    }

    private static ArrayList<String> findPath3(String path, boolean[][] isPathOpen, int r, int c) {
        ArrayList<String> paths = new ArrayList<>();
        if (r == isPathOpen.length - 1 && c == isPathOpen[0].length - 1) {
            paths.add(path);
            return paths;
        }

        if (!isPathOpen[r][c]) return paths; // Return empty list if path is blocked

        // Mark the current block as visited
        isPathOpen[r][c] = false;

        if (r < isPathOpen.length - 1) {
            paths.addAll(findPath3(path + 'D', isPathOpen, r + 1, c));
        }
        if (c < isPathOpen[0].length - 1) {
            paths.addAll(findPath3(path + 'R', isPathOpen, r, c + 1));
        }
        if (r > 0) {
            paths.addAll(findPath3(path + 'U', isPathOpen, r - 1, c));
        }
        if (c > 0) {
            paths.addAll(findPath3(path + 'L', isPathOpen, r, c - 1));
        }

        // Unmark the current block before returning
        isPathOpen[r][c] = true;

        return paths; // Return the list of paths
    }
}
