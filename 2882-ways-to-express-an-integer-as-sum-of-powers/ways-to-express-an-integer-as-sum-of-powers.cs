public class Solution {

    //read leetcode 50: a^b in O(logN)
    public int MyPow(int a, int b) {
        if(a == 0) return 0;
        if(a == 1 || b == 0) return 1;

        int res = 1;

        while(b != 0){
            if(b % 2 == 1){
                res = res * a;
            }
            a = a * a;
            b = (int) b / 2;
        }
        return res;
    }

    List<int> powers = new();
    int[,] cache = new int[300 + 2, 300 + 2]; //(why1: 300 + 2?)
    int MOD = 1_000_000_007;

    public int NumberOfWays(int n, int x) {
        // 1. find [n1^x, n2^x, ..., nk^x]
        for(int i = 1; i<=n; ++i){
            int pow = MyPow(i, x);
            if(pow > n)
                break;
            powers.Add(pow);
        }

        // 2. Backtrack with memoize - target sum
        return findWays(0, n);
    }

    int findWays(int i, int target){
        if(target == 0) return 1; //valid combination
        if(i == powers.Count || target < 0) return 0; //invalid

        if(cache[i, target] > 0){
            return cache[i, target];
        }

        // tries add or not to add
        int exclude = findWays(i + 1, target);
        int include = findWays(i + 1, target - powers[i]);

        // in C# when you know a + b can exceed long
        // you must cast a, b to long and their result will be long
        long temp = ((long)exclude + (long)include) % MOD;

        cache[i, target] = (int) temp;
        return cache[i, target];
    }
}