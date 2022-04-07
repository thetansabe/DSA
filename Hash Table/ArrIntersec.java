import java.util.HashSet;
import java.util.Set;
class ArrIntersec{
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashset = new HashSet<>();
        Set<Integer> resultset = new HashSet<>();
        //khu trung lap 1 mang
        for(int i = 0 ; i<nums1.length; i++){
            if(!hashset.contains(nums1[i])) hashset.add(nums1[i]);
        }
        //tim ptu giong nhau giua hashset voi' mang con lai
        for(int i = 0 ; i<nums2.length; i++){
            if(hashset.contains(nums2[i])) resultset.add(nums2[i]);
        }
        //tao mang ket qua
        int[] ans = new int[resultset.size()];
        int count = 0;
        for(Integer i: resultset){
            ans[count++] = (int)i;
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] arr = intersection(nums1,nums2);
        for(int i = 0 ; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}