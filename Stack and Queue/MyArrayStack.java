public class MyArrayStack implements IStackQueue{
    private int[] array;
    private int SIZE;
    private int top;
    
    MyArrayStack(int size){
        SIZE = size;
        array = new int[SIZE];
        top = -1;
    }
    @Override
    public boolean push(int val){
        if(!isFull()){
            top++;
            array[top] = val;
            return true;
        }
        return false;
    }
    
    public int pop(){
        if(!isEmpty()){
            int value = array[top];
            top--;
            return value;
        }
        //Ko co value de pop => dang li' throw loi
        return -1;
    }
    
    public boolean isFull(){
        return top == SIZE-1;
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public void show(){
        if(isEmpty()){
            System.out.println("Stack is empty");

        }else{
            for(int i=0;i<=top;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }
    }
}