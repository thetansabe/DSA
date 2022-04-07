//sort array
class QuickSort{
    public static void quickSort(int[] a, int iL, int iR){
        //dieu kien neo
        if(iL >= iR) return;

        //tim pivot khoi tao
        int pivot = a[(iL+iR)/2];

        //phan phoi mang -> ben trai < pivot, ben phai > pivot
        int k = partition(a,iL,iR,pivot);
        //k la gia tri pivot moi (pivot de. quy)

        //chia doi mang roi lap lai
        quickSort(a, iL, k-1);
        quickSort(a, k, iR);
    }

    public static int partition(int[] a,int iL,int iR,int pivot){
        while(iL<=iR){
            //Ben trai, TIM index ptu >= pivot
            while(a[iL] < pivot) iL++;
            //Ben phai, TIM index ptu <= pivot
            while(a[iR] > pivot) iR--;
            //kiem tra roi swap 2 ptu vua tim duoc
            if(iL <= iR){ 
                int t = a[iR];
                a[iR] = a[iL];
                a[iL] = t;
                //tang len de xet' ptu tiep theo
                iL++;iR--; 
            }
        }
        return iL;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
    public static void main(String[] args) {
        //QuickSort s = new QuickSort();
        int a[] = {7,8,5,2,4,6,3};
        quickSort(a, 0, a.length-1);
        printArray(a);
        //System.out.print(Arrays.toString);
    }
}