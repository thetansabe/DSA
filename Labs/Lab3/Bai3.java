import java.util.*;
class Bai3
{
    public static int checkPrime(int n, int d){
        if(n > d){
            if(n % d != 0){
                return checkPrime(n, ++d);
            } else {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int n = in.nextInt();
        in.close();
        int x = checkPrime(n, 2);
        if(x == 1)    System.out.println(n + " is a prime number");
        else    System.out.println(n + " is not a prime number");
    }
}