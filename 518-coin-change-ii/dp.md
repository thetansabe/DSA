# 1) Backtrack:

## Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
![image.png](https://assets.leetcode.com/users/images/ef6ed98c-d7c6-42a6-8fdd-c696d1366abd_1726930514.003772.png)

- I call `n` is the number of coins, `n = coins.Length`
- Yellow number: `total >= amount`, stop and increase `count`
- Look at the red subtree (root node = 1). At the first thought, we think that we have `n` possibilities (+1, +2, +5). But actually, we only have 2 possibilities: add itself to total or move to another subtree
- Why?
![image.png](https://assets.leetcode.com/users/images/63503a87-8330-4fb5-9b31-011977e1d84d_1726931019.7305653.png)

    + Decision 1: add itself to current total (the green circle)
    + Decision 2: we are left with blue and yellow circle, but if we take a look, the blue and yellow circle is calculated on the other subtrees. So our next decision is to move on to another coin.

## Complexity
- Time complexity:
![image.png](https://assets.leetcode.com/users/images/b5d241f4-bb7b-4a70-a1a5-96f67ca93eff_1726931468.125252.png)

`O(n^amount)`, because the tree have `height = amount`, and for each level it's has `n` decisions.

## Code
```csharp []
public class Solution {
    public int Change(int amount, int[] coins) {
        int count = 0;
        int n = coins.Length;

        Action<int, int> dfs = null;
        dfs = (int i, int total) => {
            if(i >= n){
                return;
            }
            
            if(total > amount){
                return;
            }

            if(total == amount){
                count += 1;
                return;
            }

            // decision 1: choose to add current coins
            dfs(i, total + coins[i]);

            // decision 2: move to next coin
            dfs(i + 1, total);
        };
        
        dfs(0, 0);
        return count;
    }
}
```

# 2) Backtrack with cache:

## Intuition
- If you looked into the decision tree, there will be many repeated computation:
![image.png](https://assets.leetcode.com/users/images/ab2c409f-07e0-4d04-aa6a-96a7369d429d_1726931799.0496182.png)

- So we just need to add a cache, note this, instead of using 2D dp, you can use `dictionary = { ( coin's index, current total ) : count }`

## Time Complexity
`O(n*amount)`

## Code
```csharp []
public int Change(int amount, int[] coins) {
        int n = coins.Length;

        int[,] cache = new int [n , amount];

        Func<int, int, int> dfs = null;
        dfs = (int i, int total) => {
            if(i >= n){
                return 0;
            }

            if(total > amount){
                return 0;
            }

            if(total == amount){
                return 1;
            }

            if(cache[i, total] > 0){
                return cache[i, total];
            }

            cache[i, total] = dfs(i, total + coins[i]) + dfs(i + 1, total);
            return cache[i, total];
        };
        
        return dfs(0, 0);
    }
```

# 3) Tabular cache:

## Intuition
- First, don't think about the logic yet, just blindly update the backtrack cached code (2) into tabular code (3):

Step 1: In the (2) code, it's top-down, which means keeps guessing until the end of the decision branch `( total >= amount )`. So when move to tabular for caching, you need to fill the table bottom-up:

```
for(int i = n - 1; i >= 0; i--){
    for(int j = amount - 1; j >= 0; j--){ 
    //CODE
    }
}
```

Step 2: Copy the `cache[i, total] = dfs(i, total + coins[i]) + dfs(i + 1, total);` and modify into this

```
dp[i, j] = dp[i + 1, j];

if(j + coins[i] <= amount){
    dp[i, j] += dp[i, j + coins[i]];
}
```

Step 3: Add space for base case by increase the size of the dp `int[,] dp = new int [n + 1, amount + 1];`

- Second, think about the logic:
https://youtu.be/Mjy4hd2xgrs?t=494


## Time Complexity
`O(n*amount)`
## Space Complexity
`O(n*amount)`
## Code
```csharp []
public int Change(int amount, int[] coins) {
        int n = coins.Length;

        int[,] dp = new int [n + 1, amount + 1];
        for(int row = 0; row < n; row++){
            // fill all the last cols to 1
            dp[row, amount] = 1;
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = amount - 1; j >= 0; j--){
                dp[i, j] = dp[i + 1, j];

                if(j + coins[i] <= amount){
                    dp[i, j] += dp[i, j + coins[i]];
                }
            }
        }
        
        return dp[0, 0];
    }
```

# 4) 1D cache, space optimised:

## Intuition
- From the logic in the (3) approach, we realize that when we calculate the current row, we just need the below row, not all the cells in the tabular.
- So, we just need a dp to store the below row, and nextDp to store the current row.
## Time Complexity
`O(n*amount)`
## Space Complexity
`O(n)`
## Code
```csharp []
public int Change(int amount, int[] coins) {
        int n = coins.Length;

        int[] dp = new int [amount + 1];
        dp[amount] = 1;

        for(int i = n - 1; i >= 0; i--){
            int[] nextDp = new int [amount + 1];
            nextDp[amount] = 1;

            for(int j = amount - 1; j >= 0; j--){
                nextDp[j] = dp[j];

                if(j + coins[i] <= amount){
                    nextDp[j] += nextDp[j + coins[i]];
                }
            }

            dp = nextDp;
        }
        
        return dp[0];
}
```
