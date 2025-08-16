public class Solution {
    public int Maximum69Number (int num) {
        string numStr = num.ToString();
        int len = numStr.Length;
        bool isChanged = false;
        int res = 0;
        
        for(int i = 0; i < len; i++){
            int pow = (int) Math.Pow(10, len - 1 - i);
            if(!isChanged && numStr[i] == '6'){
                res = res + 9 * pow;
                isChanged = true;
            }else{
                res = res + (numStr[i] - '0') * pow;
            }
        }
        
        return res;
    }
}