class CircularQueue {
    int[] array;
    int head;
    int tail;
    int SIZE;
    int count;
    public CircularQueue(int k) {
       array = new int[k];
       head = tail =-1;
       SIZE = k;
       count = 0;
    }
    
    public boolean enQueue(int value) {
        if(!isFull()){
            tail++;
            //tail dung o cuoi
            if(tail == SIZE) tail = 0;
            //Moi khoi tao.
            if(isEmpty()) head = tail;
            
            array[tail] = value;
            count++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty()){
            head++;
            if(head == SIZE) head = 0;
            count--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return array[head];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return array[tail];
    }
    
    public boolean isEmpty() {
        return count <=0;
    }
    
    public boolean isFull() {
        return count >= SIZE;
    }

    public void show(){
        for(int i = 0;i<SIZE;i++){
            System.out.print(array[i]+" ");
            
        }
        System.out.println("Head index: "+head);
        System.out.println("Tail index: "+tail);
        System.out.println("SIZE: "+SIZE);
        System.out.println();
    }
    public static void main(String[] args) {
        CircularQueue obj = new CircularQueue(6);
        // boolean param_1 = obj.enQueue(6);
        // System.out.println(param_1);
        // obj.deQueue();
        // boolean param_2 = obj.enQueue(5);
        // obj.deQueue();
        // obj.deQueue();obj.deQueue();obj.deQueue();
        // System.out.println(param_2);
        // boolean param_3 = obj.enQueue(3);
        // System.out.println(param_3);
        // obj.show();
        // boolean param_5 = obj.isEmpty();
        // boolean param_6 = obj.isFull();
    }
}