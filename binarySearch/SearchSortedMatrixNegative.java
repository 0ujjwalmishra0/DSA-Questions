package binarySearch;
import java.util.Arrays;
import java.util.Scanner;

public class SearchSortedMatrixNegative {
    public static void main(String[] args) {
        int matrix[][] = {
            {-9, -8, -7, -4, -1},
            {0,  2,  5,  8, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}};

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(Arrays.toString(search(matrix, target)));
    }

    private static int[] search(int matrix[][], int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //flatten out the matrix into arrays
        int start = 0, end = rows * cols - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return new int[] {mid / cols, mid % cols}; // Found target
            }
            if (midValue < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return new int[] {-1, -1}; // Target not found
    }
}
