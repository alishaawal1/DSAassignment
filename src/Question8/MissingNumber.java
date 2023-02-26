package Question8;

//Given an array of even numbers sorted in ascending order and an integer k,
//        Find the k^th missing even number from provided array
//        Input a[] ={0, 2, 6, 18, 22} k=6
//        Output: 16.

public class MissingNumber {
    MissingNumber(int[] a,int k,int n){
        int count=a[n-1]/2+1;
        System.out.println(count);
        System.out.println("value of n is "+n);
        int start = a[0];
        int even=0;
        int[] arr = new int[count];
        int missing=0;

        for(int i=start;i<count;i++){
            arr[i]=even;
            even=even+2;
            System.out.println(arr[i]);
        }
        int i=1;
        int j=1;
        while(i<=n){
            if(a[i]==arr[j]){
                i++;
                j++;
            }else{
                missing+=1;
                if(missing==k){
                    System.out.println(" The missing value is "+arr[j]);
                    break;
                }
                j++;
            }
        }


    }
    public static void main(String[] args) {
        int[] a={0,2,6,18,22};
        int k=6;
        int n=a.length;
        new MissingNumber(a,k,n);
//        System.out.println("The missed value is"+missingValue);
    }
}