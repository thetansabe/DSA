public class Solution {

    // if you meet a 0, just count contiguos
    // [0, 0, 0] -> subarray size = count 
    // number of subarray filled with 0 = count + (count - 1) + ... + 1 = count * (count + 1) / 2
    public long ZeroFilledSubarray(int[] nums) {
        long res = 0;
        int i = 0;

        while(i < nums.Length){
            long count = 0;

            if(nums[i] != 0){
                i++;
                continue;
            }

            int r = i;

            while(r < nums.Length){
                if(nums[r] != 0){
                    break;
                }
                
                count++;
                r++;
            }

            i = r;
            res += count * (count + 1) / 2;
        }

        return res;
    }
}