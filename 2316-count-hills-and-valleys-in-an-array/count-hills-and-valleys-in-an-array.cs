// Idea:
// - 2 elements at the ends will always be invalid -> loop from 1 to n - 1 - 1
// - Find 2 non-equal neigbors using left and right pointer
// - Jump to right pointer after each iteration

// Time complexity: O(N) 
// - At a first glance, it seems like O(N^2) with inner loops.
// - But let's think, in the worst case that left and right need to iterate whole array again -> right pointer will be in the array's end -> the next iteration of primary loop will stop because we hit the end. (i = right; at the end of each iteration)
// - Or this case [1, 2, 2, 2, 2, 3, 4, 4, 4, 5], with i = right; i can jump: 1, 2, 3, 4, 5 -> no re-visit
public class Solution {
    public int CountHillValley(int[] nums) {
        int count = 0;
        int i = 1;

        while(i < nums.Length - 1){
            int left = i - 1;
            int right = i + 1;

            while(right < nums.Length - 1 && nums[right] == nums[i]){
                right++;
            }

            if((nums[i] > nums[left] && nums[i] > nums[right])
                || (nums[i] < nums[left] && nums[i] < nums[right])
            ){
                count++;
            }

            i = right;

        }

        return count;
    }
}