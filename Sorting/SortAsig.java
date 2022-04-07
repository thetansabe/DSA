import java.util.*;

class SortAsig{
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

    public static void insertionSort(int a[], int size){
        for(int i = 1;i< a.length;i++){
            int key = a[i]; //running pointer
            int j = i -1;

            //Move ptu phia ben phai va lon hon key
            //cu. the? la move den vi tri' lien sau no (vi da la sorted list)
            while(j>=0 && a[j] > key){
                a[j+1] = a[j];
                j = j - 1; //neu move dc 1 phan tu
                //-> j-1 de check phan tu phia sau co' con` > key ko?
                //-> cau lenh de vua thoat vong lap vua duyet nguoc sorted arr ben phai key
            }
            //sau khi move len -> tao spot trong' de nhet key vao
            a[j+1] = key; //j+1 vi` vong lap vua lam thao tac j - 1
        }
    }

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

    static void bubbleSort2(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
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
        int[] inputArray = new int[8];

        System.out.println("Moi ban nhap vao mang 8 phan tu: ");
        for(int i = 0; i<8 ; i++){
            Scanner sc = new Scanner(System.in);
            inputArray[i] = sc.nextInt();
        }
        System.out.println("Mang ban dau: ");
        printArray(inputArray);
        boolean flag = true;
        while(flag){
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Bubble Sort 2");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("Nhap lua chon cua ban: ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    int[] newArray = bubbleSort(inputArray);
                    System.out.println("Ket qua sau bubble sort: ");
                    printArray(newArray);
                    flag = false;
                    break;
                case 2:
                    System.out.println("Ket qua sau selection sort: ");
                    selectionSort(inputArray);
                    flag = false;
                    printArray(inputArray);
                    break;
                case 3:
                    System.out.println("Ket qua sau insertion sort: ");
                    insertionSort(inputArray, 8);
                    printArray(inputArray);
                    flag = false;
                    break;
                case 4:
                    System.out.println("Ket qua sau bubble sort 2: ");
                    bubbleSort2(inputArray, 8);
                    printArray(inputArray);
                    flag = false;
                case 0:
                    flag = false;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}