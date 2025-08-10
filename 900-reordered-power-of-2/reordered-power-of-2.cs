public class Solution {
    // { index = digit, value = count }
    // each iteration will reduce num / 10 => log10(N) ~ O(logN)
    public int[] CountDigits(int num) {
        int[] freq = new int[10];
        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }
        return freq;
    }

    // DO NOT need to iterate through permutation set from n.
    // n with 10^9 digits: is like 9876543210 repeat 9 times
    // we will have to check (9*9*8*...*1)*9 = 9*9!*9 ~ 3.10^7
    // => this still works but don't do this..

    // We should iterate through all powers of 2.
    // The maximum possible value for n is 10^9, so the largest power of 2
    // we need to check is 2^29 (which is less than 10^9).
    // WHY 29? just find largest x that log10(2^x) < log10(10^9)

    // Overall TC: O(logN) ~ O(log10(10^9)) = 9 ~ O(1)
    public bool ReorderedPowerOf2(int n) {
        // 1. Get the digit frequencies of the input number n.
        int[] nFreq = CountDigits(n);
        
        // 2. Iterate through 29 power of i
        // The length of the number n and the power of 2 must be the same.
        for (int i = 0; i < 30; i++) {
            int powerOf2 = 1 << i; // This is equivalent to 2^i.
            
            // 3. Get the digit frequencies of the current power of 2.
            int[] powerFreq = CountDigits(powerOf2);
            
            // 4. Compare the digit frequencies.
            // If the frequencies match, we've found a valid reordering.
            if (nFreq.Length != powerFreq.Length) {
                continue;
            }

            bool match = true;
            for (int j = 0; j < 10; j++) {
                if (nFreq[j] != powerFreq[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }

        // If no power of 2 has matching digit frequencies, return false.
        return false;
    }
}
