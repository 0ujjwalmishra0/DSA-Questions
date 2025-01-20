package arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] a= new int[]{10,5,10};
        System.out.println(getSecondLargest(a));
    }

    private static int getSecondLargest(int[] arr) {
        // Code Here
        int max=arr[0],secondMax=-1;
        for(int i: arr){
            if(i>max){
                secondMax=max;
                max=i;
            }else if(i<max && i>secondMax){
                secondMax=i;
            }
        }
        return secondMax;
    }
}
