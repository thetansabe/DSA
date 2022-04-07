//sort array
class BubbleSort{
    public static int[] bubbleSort(int a[]){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n-i-1;j++){
                if(a[j+1] < a[j]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }

        return a;
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
        bubbleSort(a);
        printArray(a);
    }
}