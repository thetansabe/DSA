public class Solution {
    public int[] QueryResults(int limit, int[][] queries) {
        int[] res = new int[queries.Length];

        // store current color for each ball
        Dictionary<int, int> ball_color = new();

        // store color freq - how many balls have the same color
        Dictionary<int, int> color_freq = new();

        // setup dicts
        for(int i = 0; i < queries.Length; i++){
            int ball = queries[i][0];
            int color = queries[i][1];

            // If the ball already has a color and changed to new one, 
            // decrease the count of old color. 
            if(ball_color.ContainsKey(ball)){
                int oldColor = ball_color[ball];
                
                if(color_freq.ContainsKey(oldColor)){
                    color_freq[oldColor] -= 1;

                    //instead filter to chose colors that freq > 0 in the end -> O(N)
                    //we can delete it right now
                    if(color_freq[oldColor] < 1){
                        color_freq.Remove(oldColor);
                    }
                }
                
            }

            // else, when the ball NOT have any color yet
            ball_color[ball] = color;
            if(color_freq.ContainsKey(color)){
                color_freq[color] += 1;
            }else{
                color_freq[color] = 1;
            }

            // .Count only takes O(1)
            res[i] = color_freq.Count;
        }

        return res;
    }
}