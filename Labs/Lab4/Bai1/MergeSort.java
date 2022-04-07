import java.util.Arrays;

class MergeSort{
    public int[] mergeSort(int[] a,int left,int right){
        //dieu kien neo
        if(left > right) return new int[0];
        if(left==right){
            int[] singleElement = {a[left]};
            return singleElement;
        }

        //tim` mid -> chia
        int k = (left+right)/2;
        int[] a1 = mergeSort(a, left, k);
        int[] a2 = mergeSort(a,k+1,right);

        //tron
        int n = a1.length + a2.length;
        int[] result = new int[n];

        int i = 0;//con tro cua result
        int i1 = 0; //con tro cua a1
        int i2 = 0; //con tro cua a2

        while(i<n){
            //neu ca i1 va i2 deu nam trong range
            if(i1<a1.length && i2<a2.length){
                if(a1[i1] <= a2[i2]){
                    result[i] = a1[i1];
                    i++; i1++;
                }else{
                    result[i] = a2[i2];
                    i++; i2++;
                }
            }else{ //neu 1 trong 2 out range
                if(i1<a1.length){ //a2 out range
                    result[i] = a1[i1];
                    i++; i1++;
                }else{ //a1 out range
                    result[i] = a2[i2];
                    i++; i2++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort s = new MergeSort();
        int a[] = {7,8,5,2,4,6,3};
        System.out.print(Arrays.toString(s.mergeSort(a, 0, 6)));
    }
}