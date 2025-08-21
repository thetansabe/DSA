public class Solution {
    public int TupleSameProduct(int[] nums) {
        int n = nums.Length;
        Dictionary<int, int> freq = new();

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int prod = nums[i] * nums[j];
                if(freq.ContainsKey(prod)){
                    freq[prod] += 1;
                }else{
                    freq[prod] = 1;
                }
            }
        }

        int res = 0;
        foreach(var pair in freq){
            if(pair.Value < 2){
                continue;
            }

            // magic formula
            res += pair.Value * (pair.Value - 1) * 4;
        }

        return res;
    }
}