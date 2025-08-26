public class Solution {
    public int AreaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0;
        int maxArea = 0;

        foreach(var rec in dimensions){
            int t = rec[0] * rec[0] + rec[1] * rec[1];

            if(maxDiagonal == t){
                maxArea = Math.Max(rec[0] * rec[1], maxArea);
            }

            if(maxDiagonal < t){
                maxDiagonal = t;
                maxArea = rec[0] * rec[1];
            }
        }

        return maxArea;
    }
}