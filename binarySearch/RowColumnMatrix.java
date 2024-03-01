package binarySearch;

import java.util.Arrays;
// This is row wise and column wise sorted matrix
public class RowColumnMatrix {
    public static void main(String[] args) {
        int matrix[][]= {{10,20,30,40},
                    {15,25,35,45},
                    {28,29,37,49},
                    {33,34,38,50}};

        System.out.println(Arrays.toString(searchInMatrix(matrix,37)));
        System.out.println(Arrays.toString(searchInMatrix(matrix,39)));
    }
    private static int[] searchInMatrix(int a[][],int target){
        int row=0,column=a[0].length-1;
        while(row<a.length && column>=0){
            if(a[row][column]==target){
                return new int[]{row,column};
            }
            if(a[row][column]<target){
                row++;
            }
            else{
                column--;
            }
        }
        return new int[]{-1,-1};
    }
}
