class SelectionSort{
    public static void selectionSort(int a[]){
        int size = a.length;
        
        for(int i=0;i<size-1;i++){
            int min_idx = i;
            //Tim INDEX cua min trong mang
            for(int j=i+1;j<size;j++){
                if(a[j]<a[min_idx]){
                    min_idx = j;
                }   
            }
            //swap
            int tmp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = tmp;
        }
        
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {7,8,5,2,4,6,3};
        selectionSort(a);
        printArray(a);
    }
}