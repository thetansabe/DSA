import java.util.NoSuchElementException;

public class MyQueue<E>{
    private Node<E> head;
    private Node<E> tail;
    private int count;

    MyQueue(){
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void add(E value){
        Node<E> newNode = new Node<E>(value);
        //khi moi' tao. lan dau
        if(isEmpty()){
            head = newNode;
            head.setNext(tail);
            count++;
        }
        //khi queue chi co 1 phan tu
        if(count == 1){
            newNode.setNext(tail);
            head.setNext(tail);
        } 
        //binh thuong: add tail
        else{
            tail.setNext(newNode);
            tail = newNode;
        }
        
        tail = newNode;
        count++;
            
    }

    public E poll() throws NoSuchElementException{
        if(isEmpty()) throw new NoSuchElementException("Empty queue!!!");
        Node<E> t = head;
        head = head.getNext();
        return t.getData();
    }

    public E peek() throws NoSuchElementException{
        if(isEmpty()) throw new NoSuchElementException("Empty queue!!!");
        return head.getData();
    }

    public void show(){
        Node<E> t = head;
        System.out.print("Queue: "+t.getData());
        t = t.getNext();
        while(t != null){
            System.out.print("->"+t.getData());
            t = t.getNext();
        }
        System.out.println();
    }
}