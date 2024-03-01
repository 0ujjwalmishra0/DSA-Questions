package recursion.Maze;

import java.util.ArrayList;

public class countPath {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        System.out.println(findPath("",3,3));
        System.out.println(findPathDiagonal("",3,3));
//        printPath("",3,3);
    }


    private static int count(int r,int c){
        if(r==1 || c==1){
            return 1;
        }
        int down= count(r-1,c);
        int right= count(r,c-1);
        return down+right;
    }

    private static void printPath(String path,int r, int c){
        if(r<=1&&c<=1){
            System.out.println(path);
            return;
        }
        if(r>1) {
            printPath(path + "D", r - 1, c);
        }
        if(c>1) {
            printPath(path + "R", r, c - 1);
        }

    }
    private static ArrayList<String> findPath(String path,int r, int c){
        if(r<=1&&c<=1){
            ArrayList<String> list=new ArrayList<>();
            list.add(path);
            return list;
        }
        ArrayList<String> listOfPath = new ArrayList<>();
        if(r>1) {
            listOfPath.addAll(findPath(path + "D", r - 1, c));
        }
        if(c>1) {
            listOfPath.addAll(findPath(path + "R", r, c - 1));
        }
        return listOfPath;

    }

    private static ArrayList<String> findPathDiagonal(String path,int r, int c){
        if(r<=1&&c<=1){
            ArrayList<String> list=new ArrayList<>();
            list.add(path);
            return list;
        }
        ArrayList<String> listOfPath = new ArrayList<>();
        if(r>1) {
            listOfPath.addAll(findPath(path + "D", r - 1, c));
        }
        if(c>1) {
            listOfPath.addAll(findPath(path + "R", r, c - 1));
        }
        if(r>1 && c>1){
            listOfPath.addAll(findPath(path+"X",r-1,c-1));
        }
        return listOfPath;

    }



}
