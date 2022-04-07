import java.util.NoSuchElementException;

//implement queue using 2 stack
class QueueFormStacks<E>{
    private MyStack<E> stack1 = new MyStack<E>();//=top1 = head
    private MyStack<E> stack2 = new MyStack<E>();//=top2 = tail
    private int count = 0;

    QueueFormStacks(){}

    public boolean isEmpty(){
        return count == 0;
    }

    public void add(E value){
        //moi khoi tao
        if(count == 0) 
            stack1.push(value);
        //khi co > 1 phan tu
        else
            stack2.push(value);
        count++;
    }

    public E poll() throws NoSuchElementException{
        //neu queue rong~
        if(isEmpty()) throw new NoSuchElementException("Empty queue!!!");
        
        //binh thuong
        if(stack1.isEmpty()){
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        count--;
        return stack1.pop();
    }
}