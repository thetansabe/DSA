public class Solution {
    public string LargestGoodInteger(string num) {
        int max = 0;
        int l = 0;

        bool hasGood = false;
        
        for (int r = 0; r < num.Length; r++)
        {
            // update pointers
            if (num[r] == num[l])
            {
                if (r - l >= 2) {
                    hasGood = true;
                    max = Math.Max(int.Parse(num[l].ToString()), max);
                }
            }
            else
            { 
                l = r;
            }
        }

        if(num.Length - l >= 3)
        {
            max = Math.Max(int.Parse(num[l].ToString()), max);
            return new string(max.ToString()[0], 3);
        }

        if(!hasGood) return string.Empty;

        return new string(max.ToString()[0], 3);
    }
}