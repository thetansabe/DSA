public class Solution {
    public int LongestSubarray(int[] nums) {
        int n = nums.Length;
        int zerosCount = 0;
        int maxWinLen = 0;

        int l = 0;

        for(int r = 0; r < n; r++){
            zerosCount += (nums[r] == 0 ? 1 : 0);

            // shrink the window until zerosCount <= 1
            while(zerosCount > 1){
                zerosCount -= (nums[l] == 0 ? 1 : 0);
                l++;
            }

            maxWinLen = Math.Max(maxWinLen, r - l);
        }

        return maxWinLen;
    }
}