class InsertionSort{
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

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {7,8,5,2,4,6,3};
        insertionSort(a, a.length);
        printArray(a);
    }
}