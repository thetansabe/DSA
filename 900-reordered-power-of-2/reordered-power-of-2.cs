// public class Solution {
//     public bool ReorderedPowerOf2(int n) {
//         Dictionary<int, int> freq = new(); // { digit : count}
//         int numLen = 0;

//         // 1. init freq map
//         while(n > 0){
//             int digit = n % 10;
//             if(!freq.ContainsKey(digit)){
//                 freq[digit] = 0;
//             }
//             freq[digit] += 1;
//             n = n / 10;
//             ++numLen;
//         }

//         // 2. generate permutations
//         for(int i = 0; i < numLen; i++){
//             // code to gen permuatations from map 
//         }
//     }
// }

public class Solution {
public bool ReorderedPowerOf2(int n) {
    // Helper function to count digit frequencies of a number.
    // It returns an integer array of size 10 where the index represents the digit
    // and the value represents its frequency.
    int[] CountDigits(int num) {
        int[] freq = new int[10];
        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }
        return freq;
    }

    // 1. Get the digit frequencies of the input number n.
    int[] nFreq = CountDigits(n);

    // 2. Iterate through all powers of 2.
    // The maximum possible value for n is 10^9, so the largest power of 2
    // we need to check is 2^29 (which is less than 10^9).
    // The length of the number n and the power of 2 must be the same.
    for (int i = 0; i < 30; i++) {
        int powerOf2 = 1 << i; // This is equivalent to 2^i.
        
        // 3. Get the digit frequencies of the current power of 2.
        int[] powerFreq = CountDigits(powerOf2);
        
        // 4. Compare the digit frequencies.
        // If the frequencies match, we've found a valid reordering.
        if (nFreq.Length == powerFreq.Length) {
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
    }

    // If no power of 2 has matching digit frequencies, return false.
    return false;
}
}
