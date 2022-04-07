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

//  static void bubbleSort(int arr[], int n)
//  {
//      int i, j, temp;
//      boolean swapped;
//      for (i = 0; i < n - 1; i++)
//      {
//          swapped = false;
//          for (j = 0; j < n - i - 1; j++)
//          {
//              if (arr[j] > arr[j + 1])
//              {
//                  // swap arr[j] and arr[j+1]
//                  temp = arr[j];
//                  arr[j] = arr[j + 1];
//                  arr[j + 1] = temp;
//                  swapped = true;
//              }
//          }

//          // IF no two elements were
//          // swapped by inner loop, then break
//          if (swapped == false)
//              break;
//      }
//  }