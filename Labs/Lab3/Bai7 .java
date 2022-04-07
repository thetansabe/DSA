import java.util.*;
class Bai7{
    public static void main(String[] args){
        // Scanner in = new Scanner(System.in);
        // System.out.print("Input the size of array: ");
        // int n = in.nextInt();
        // int[] a = new int[n];

        // for(int i = 0; i < a.length; ++i){
        //     a[i] = in.nextInt();
        // }
        int[] a = {13,2,31,48,5,8,12,18,20,24};
        int n = a.length;
        int count = 0;
        System.out.println("Min in the array: " + findMin(a, n));
        System.out.println("Sum of the array: " + calSum(a, n));
        System.out.println("Even numbers of the array: " + countEven(a, n, count));
    }

    public static int findMin(int[] a, int n){
        int temp = 0;
        if(n == 1){
            return a[0];
        } else {
            temp = findMin(a, n-1);
            if(temp <= a[n-1])   return temp;
            else    return a[n-1];
        }
    }

    public static int calSum(int[] a, int n){
        if(n <= 0){
           return 0;
        }
        return (calSum(a, n-1) + a[n-1]);
    }

    public static int countEven(int[] a, int n, int count){
        if(n <= 0){
            return count+=0;
        } 
        if(a[n-1] % 2 == 0){
            count += 1;
        }
        
        return countEven(a, n-1, count);
    }
}