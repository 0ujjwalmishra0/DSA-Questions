package recursion.Maze;

import java.util.ArrayList;

public class findPathWithObstacle {
    public static void main(String[] args) {
        boolean isPathOpen [][]= {
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };
        System.out.println(findPath("",isPathOpen,0,0));
    }

    private static ArrayList<String> findPath(String path, boolean [][] isPathOpen, int r, int c){
        if (r== isPathOpen.length-1 && c == isPathOpen[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        ArrayList<String> listOfPath = new ArrayList<>();
        if (isPathOpen[r][c]) {
            if (r < isPathOpen.length - 1) {
                listOfPath.addAll(findPath(path + 'D', isPathOpen, r + 1, c));
            }
            if (c < isPathOpen[0].length - 1) {
                listOfPath.addAll(findPath(path + 'R', isPathOpen, r, c + 1));
            }
        }
        return listOfPath;
    }
}
