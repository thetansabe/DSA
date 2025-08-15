public class Solution {
    public bool IsPowerOfFour(int n) {
        double t = (double) n;

        while(t > 1){
            t /= 4;
        }

        return t == 1.0;
    }
}