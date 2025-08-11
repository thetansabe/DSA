public class Solution {
    // How power is built:
    // Take binary form of n; each 1 bit means include that power of 2.
    // n = 15 → 1111₂ → bits set: 2^3 + 2^2 + 2^1 + 2^0 → 8 + 4 + 2 + 1 -> power = [1, 2, 4, 8]
    // n = 2 → 10₂ → bits set: 2^1 + 0 * 2^0 -> 2 → power = [2]
    public int[] ProductQueries(int n, int[][] queries) {
        // construct powers[] -> powers only have log2(N) elements
        List<int> powers = new();

        int pow = 0;
        while (n > 0)
        {
            int powerOf2 = 1 << pow; // 2^pow
            int powerElement = n % 2 * powerOf2;

            if (powerElement > 0)
                powers.Add(powerElement);
            n /= 2;
            pow++;
        }

        // we can brute force powers[] ~ log2(10^9) ~ 30 elements
        int len = queries.Length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++)
        {
            var duplex = queries[i];

            int temp = 1;

            // int can hold max value is 2*10^9
            // prevent overflow with modulo 10^9 + 7 (first prime number after 10^9)
            // powers[j] % 1000000007 will make sure result never exceed (10^9 + 7) - 1 => 9 digits
            // (long)temp * powers[j] will perform multiplication allow exceed maxInt
            for (int j = duplex[0]; j <= duplex[1]; j++)
            {
                temp = (int)((long)temp * powers[j] % 1_000_000_007);
            }

            res[i] = temp;
        }

        return res;
    }
}