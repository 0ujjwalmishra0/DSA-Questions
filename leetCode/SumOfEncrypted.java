package leetCode;

public class SumOfEncrypted {
    public static void main(String[] args) {
        int a[] = new int[]{38};
        System.out.println(sumOfEncryptedInt(a));
    }

    public static int sumOfEncryptedInt(int[] nums) {
        int sum=0;
        for (int num:nums){
            int maxDigit= findMax(num);

            sum=sum+ maxDigit;
        }
        return sum;
    }

    public static int findMax(int x){
        int r=0,max=0,count=0;
        while(x>0){
            r=x%10;
            max= Math.max(max,r);
            x=x/10;
            count++;
        }
        int n=0;
        for(int i=0;i<count;i++){
            n= (int) (n+ Math.pow(10,i)*max);
        }
        return n;
    }
}
