public class Solution {

    // Idea: create result = 00...00 (32-bit)
    // Check from right to left of n, where is bit-1 
    // then put bit-1 at (31 - i)-th index in result
    public int ReverseBits(int n) {
        int res = 0;

        // int has 31..0 bits
        for(int i = 0; i < 32; i++){
            // check if bits at i-th index of n is 1 or not
            // remember we are reading from right to left
            int checker = 1 << i;
            int t = (int) checker & n;

            if(t != 0){
                // this i-th bit is 1
                // we are reversing so put bit-1 in res from left to right
                int seedOne = 1 << (31 - i);
                res = res | seedOne;
            }
        }

        return res;
    }
}