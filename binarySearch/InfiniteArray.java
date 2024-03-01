package binarySearch;

public class InfiniteArray {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,11,13,15,18};
        //infinite array-> we don't know the length of array
        System.out.println(findRange(a,15));

    }

    private static int findRange(int a[],int target){
        // till you find the target is greater than end keep doubling the window
        int start=0,end=1,diff=(end-start)+1;
        try {
            while(target>a[end]){
                start=end+1;
                diff=diff*2;
                end=diff+end;
            }
        }catch (IndexOutOfBoundsException e){
            return binarySearch(a,target,start,end);
        }
        return binarySearch(a,target,start,end);
    }

    private static int binarySearch(int a[],int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(a[mid]==target) return mid;
            else if(a[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}
