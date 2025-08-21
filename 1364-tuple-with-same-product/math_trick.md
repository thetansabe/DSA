# Approach
<!-- Describe your approach to solving the problem. -->
1) We can use DFS to create list of combination tuples, and for each tuples we will check the condition (a*b = c * d, ...). This will be tedius because DFS will take 2^k. We will not do this.

2) Actually, we only need to find product that have more than 2 pairs which create it. And for each pair we need to account for their permutations like this:

nums = [1,2,4,5,10,20]

we found that we have 3 pairs' product == 20: (1, 20) (4, 5) (2, 10)

we will have k = 3, k*(k-1)*4 = 24 (4-digit tuples)

How to come up with k*(k-1)*4?

We have: (a, b, c, d)

- We know (a, b) and (c, d) is a pair so we have k choices to pick 
(a, b); which means we only have k - 1 choices to pick (c, d)

=> k*(k-1)

- We also know (a, b) can swap internally, so do (c, d)

=> k*2 * (k-1)*2

# Complexity
O(n^2)

# Code
```csharp []
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
```
