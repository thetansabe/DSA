# Intuition
- We need to find sum of subarrays -> we could use prefix sum
- Here is a catch:

odd - even = odd

even - odd = odd

# Approach
arr = [1,3,5]

prefixSum = [1, 4, 9]

we have: `countOdd` = 1; `countEven` = 2;

the fully sum array should be: [1,4,9,3,8,5]

- from prefix sum, how to find fully sum array:
  
3 = 4 - 1
  
8 = 9 - 1

5 = 9 - 4
  
We know that the missing odd sums will be formed by prefix odd sum and even sum
- Number of missing odd sums = `countOdd` * `countEven`
- Result = Number of missing odd sums + `countOdd`
- We need to mod by 10^9 + 7 to keep value in range

# Code
```csharp []
public class Solution {
    public int NumOfSubarrays(int[] arr) {
        int n = arr.Length;
        int[] prefixArr = new int[n];

        prefixArr[0] = arr[0];

        for(int i = 1; i < n; i++){
            prefixArr[i] = prefixArr[i - 1] + arr[i];
        }

        int countEven = 0;
        int countOdd = 0;
        int modBy = 1_000_000_000 + 7;

        foreach(int el in prefixArr){
            if(el % 2 != 0){
                countOdd += 1;
                countOdd %= modBy;
            }else{
                countEven += 1;
                countEven %= modBy;
            }
        }

        return (int) (((1L * countOdd * countEven) % modBy + countOdd) % modBy);
    }
}
```
