public class Solution {
    public int NumOfUnplacedFruits(int[] fruits, int[] baskets) {
        HashSet<int> usedIndexes = new();

        foreach(int fruit in fruits){
            for(int j = 0; j < baskets.Length; j++){
                if(usedIndexes.Contains(j)){
                    continue;
                }

                if(baskets[j] >= fruit){
                    usedIndexes.Add(j);
                    break;
                }
            }
        }

        return fruits.Length - usedIndexes.Count;
    }
}