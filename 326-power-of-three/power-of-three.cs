public class Solution {

    public int MyPow(int a, int b) {
        if(a == 0) return 0;
        if(a == 1 || b == 0) return 1;

        int res = 1;

        while(b != 0){
            if(b % 2 == 1){
                res = res * a;
            }
            a = a * a;
            b = (int) b / 2;
        }
        return res;
    }

    public bool IsPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        // Binary search for the exponent
        int left = 0;
        int right = 20; // 3^20 is the largest power of 3 that fits in a 32-bit int

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int powerOfThree = MyPow(3, mid);

            if (powerOfThree == n) {
                return true;
            } else if (powerOfThree < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}