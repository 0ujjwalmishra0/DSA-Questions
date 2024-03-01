import java.util.*;

class arrays{
    public static void main(String args[]){
        
        //arrays of objects
        String [] s = new String[4];
        ArrayList<Integer> a = new ArrayList<>();
        // Scanner sc = new Scanner(System.in);

        // for(int i=0;i<5;i++){
        //     a.add(Integer.parseInt(sc.nextLine()));
        // }

        int [] arr={1,2,3,4,5};
        // shuffle(arr,3);
        System.out.println(isEvenString(19329));
        System.out.println(Math.log10(19392));
        
        // s[1]= "ujjwal";
        // System.out.println("max value of array: "+ max(a));
        // System.out.println("max value of array in range 2:4 : "+ maxRange(a,2,4));
    }

    private static int max(ArrayList<Integer> a){
        int res=Integer.MIN_VALUE;
        for(int i=0;i<a.size();i++){
            if(a.get(i)>res){
                res=a.get(i);
            }
        }
        return res;
    }
    private static int maxRange(ArrayList<Integer> a,int start,int end){
        int res=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            if(a.get(i)>res){
                res=a.get(i);
            }
        }
        return res;
    }

    private static void reverse(int[] a){
        int start=0,end=a.length-1;
        while (start<end) {
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }
    }
    public static int[] shuffle(int[] nums, int n) {
        int a[]=new int[nums.length];
        for(int j=0;j<2*n;j+=2){
            for(int i=0;i<n;i++){
                a[j]=nums[i];
                a[j+1]=nums[n+i];
            }
        }
        return a;
    }
    public static boolean isEvenDigit(int n){
        int count=0;
        while (n>0) {
            n=n/10;
            count++;
        }
        if(count%2==0)
        return true;
        else return false;
    }

    private static boolean isEvenString(int n){
        String convertedNo = n+"";
        int count = convertedNo.length();
        if(count%2==0)
        return true;
        else return false;
    }
}