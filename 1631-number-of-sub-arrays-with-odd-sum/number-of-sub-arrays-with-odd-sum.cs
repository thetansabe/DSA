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