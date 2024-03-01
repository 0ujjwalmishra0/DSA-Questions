package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class SearchSortedMatrix {
    public static void main(String[] args) {
        int matrix[][]= {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };
        Scanner sc= new Scanner(System.in);
        int target= sc.nextInt();
        System.out.println(Arrays.toString(search(matrix,target)));
    }


    private static int [] search(int matrix[][],int target){
        int row= floor(matrix,target);
        int column= binarySearch(matrix[row],target);
        if(column==-1) return new int[] {-1,-1};
        return new int[] {row,column};
    }

    private static int floor(int a[][],int target){
        int start=0,end=a.length-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(a[mid][0]==target) return mid;
            if(a[mid][0]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return end;
    }

    private static int binarySearch(int a[],int target){
        int start=0,end=a.length-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(a[mid]==target) return mid;
            if(a[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}
