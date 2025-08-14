public class Solution {

    // Tips: 
    // from char to int: num - '0'
    // from int to char: (char)('0' + max)
    public string LargestGoodInteger(string num) {
        int max = -1;
        int l = 0;

        for (int r = 0; r < num.Length; r++)
        {
            // update pointers
            if (num[r] == num[l])
            {
                if (r - l >= 2) {
                    // convert char to int
                    max = Math.Max(num[l] - '0', max);
                }
            }
            else
            { 
                l = r;
            }
        }
        
        if(num.Length - l >= 3)
        {
            max = Math.Max(num[l] - '0', max);
        }

        if(max < 0) return string.Empty;

        // from int to char
        char maxChar = (char)('0' + max);
        return new string(maxChar, 3);
    }
}