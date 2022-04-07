public class MyArrayQueue implements IStackQueue{
    private int[] array;
    private int SIZE;
    private int head;
    private int tail;

    MyArrayQueue(int size){
        SIZE = size;
        array = new int[SIZE];
        tail = -1;
        head = -1;
    }
    @Override
    public boolean push(int val){
        if(!isFull()){
            //Khi queue ko co phan tu ma add them
            if(isEmpty()) head++;
            //TH chu yeu'
            tail ++;
            array[tail] = val;
            return true;
        }
        return false;
    }

    public int count(){
        if(isEmpty()) return 0;
        return tail - head +1;
    }
    
    public int pop(){
        if(!isEmpty()){
            int value = -1;
            
            if(!isEmpty()){
                //TH chu yeu'
                value = array[head];
                head++;
                //TH mang chi co 1 phan tu ma` pop 
                //=> ko con` ptu nao => reset
                if(head>tail){
                    head = tail = -1;
                }
            }
        }
        //Ko co value de pop => dang li' throw loi
        return -1;
    }
    
    public boolean isFull(){
        return tail == SIZE-1;
    }

    public boolean isEmpty(){
        return (head == -1) && (tail == -1);
    }

    public void show(){
        if(isEmpty()){
            System.out.println("Queue is empty");

        }else{
            for(int i=head;i<=tail;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }
    }
}