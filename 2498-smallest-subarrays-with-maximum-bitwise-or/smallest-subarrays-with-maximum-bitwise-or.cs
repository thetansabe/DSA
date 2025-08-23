public class Solution {
    public int[] SmallestSubarrays(int[] nums) {
        int n = nums.Length;
        int maxElement = nums.Max();

        //(1) count numbers of bit in maxElement == 1 + log2(maxElement)
        int bits = maxElement == 0 ? 0 : 1 + (int) Math.Log(maxElement, 2);

        // store the index that have the set bit (bit == 1)
        int[] nearestSetBit = new int[bits];

        // set defaults values is n (index that out of scope for initialization)
        Array.Fill(nearestSetBit, n);

        int[] res = new int[n];

        for(int i = n - 1; i >= 0; --i){
            int nearest = i;

            for(int j = 0; j < bits; ++j){
                // (2) check if the bit at j of current integer (a[i]) is 1 or not
                if((nums[i]&(1 << j)) != 0){
                    nearestSetBit[j] = i;
                }

                // (3) update when nearestSetBit[j] is not init value anymore
                if(nearestSetBit[j] != n){
                    nearest = Math.Max(nearest, nearestSetBit[j]);
                }
            }

            res[i] = nearest - i + 1;
        }

        return res;
    }
}