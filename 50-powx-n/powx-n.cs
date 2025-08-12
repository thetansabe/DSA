public class Solution {

    // With x^n we have this algo to reduce O(N) to O(logN)
    // 1. Create res = 1;
    // 2. While pow > 0 (pow is a temp var from n)
    //      if pow is odd: res = res * x; (save base value)
    //      a = a * a (why1?)
    //      b = b / 2 (why2?)

    public double MyPow(double x, int n) {
        if(x == 0.0)
            return 0;
        
        if(x == 1.0 || n == 0)
            return 1;
        
        // Use negation instead of Math.Abs()
        // when n = -2147483648 (out of int.MinValue)
        // Math.Abs(n) will  throw: Negating the minimum value of a twos complement number is invalid.
        int pow = n > 0 ? n : -n;
        double res = 1.0;

        while(pow != 0){
            // if x^5 => res = x^2 * x^2 * x
            if(pow % 2 != 0){
                res = res * x;
            }

            // if x^4 => res = x^2 * x^2
            x = x * x;
            pow = (int) pow / 2;
        }

        // if pow is negative
        if(n < 0){
            return 1 / res;
        }
        return res;
    }
}