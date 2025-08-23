# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- [Link solution](https://www.youtube.com/watch?v=1RlZk_PSPd8)

- (1) Why numbers of bit in maxElement == 1 + log2(maxElement):

For example, maxElement = 5, to find how many bits in binary of 5:

    - 5 (dec) = 1* 2^2 + 1 * 2^1 + 0* 2^0 -> 110 (bin) 
    - With out do the math like above, we just remember the nearest power of 2 is 4
    log2(4) = 2 (2^2 = 4), since 5 > 4 we know for sure 5 has 2 or 3 bits.
 
We just need to choose biggest possibility: `1 + log2(maxElement)`
    - The idea is to find the k which makes 2^k nearest to 5.
    
`2^k ~ 5 => k ~ log2(5)`

- (2) how to check the j-bit of any integer is 1 or not
  
For example, nums[i] = 5 (decimal == 101 in bin) and j = 2.

Is the **2nd bit (from right to left)** of 5 is 1 or 0 ?

`nums[i]&(1 << j)`

    - `(1 << j) = (1 << 2) = 100` from 001 shift all bits from right to left 2 steps. 
    Overall, this is to create a bit mask that have bit-1 at j-bit and the rest are bit-0, this will help for later `AND`. 
    Because `AND` only return bit-1 if both are bit-1, so nums[i]'s j-bit is bit-1 only if `nums[i] & mask` returns non 0(bin)
    - `5(decimal) & 100(binary) = 101(bin) & 100(bin) = 4(dec)` so 2nd index is 1 (because 4 != 0)
    - Remember in C#, nums[i] is int so the `&` operator will return int value not bin value so we cannot use == 1, we must use != 0
    

- (3) why need update `nearest` when `nearestSetBit[j] != n`
    - `nearestSetBit` stores rightmost index encountered so far (when iterating from right to left) where the j-bit was set to 1.
    - `nearest` tracks the maximum index (furthest right) seen so far, "nearest" from when you start not nearest to the i-th element.
    - `nearestSetBit[j] != n`, it means that some number to the right of or at i contributed this bit tells us to update the `nearest`
    - `nearest = Math.Max(nearest, nearestSetBit[j]);` ensures that nearest always holds the furthest right index


# Complexity
- Time complexity:

From the nested loop: O(n * (1 + log(maxElement)))

Approximate: **O(NlogN)** since n_max = 10^5, maxElement_max = 10^9, we can have N = 10^9

- Space complexity:
  
$$nearestSetBit$$ takes the significant memory of 1 + log(maxElement) elements, so we have O(1+ log(maxElement)), which is **O(logN)** in space

# Code
```csharp []
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
```
