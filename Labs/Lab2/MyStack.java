import java.util.NoSuchElementException;

public class MyStack<E>{
    private Node<E> top;

    MyStack(){
        top = null;
    }

    public void push(E n){ //add top
        Node<E> newNode = new Node<E>(n);
        newNode.setNext(top);
        top = newNode;
    }

    public E pop() throws NoSuchElementException{
        if(isEmpty()) throw new NoSuchElementException("Empty stack!!!");
        Node<E> temp = top;
        top = top.getNext();
        return temp.getData();
    }

    public E peek() throws NoSuchElementException{
        if(isEmpty()) throw new NoSuchElementException("Empty stack!!!");
        return top.getData();
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void show(){
        Node<E> t = top;
        System.out.print("Stack: "+t.getData());
        t = t.getNext();
        while(t != null){
            System.out.print("->"+t.getData());
            t = t.getNext();
        }
        System.out.println();
    }

    public int size(){
        int count = 0;
        Node<E> temp = top;
        while(temp != null){
            temp = temp.getNext();
            count++;
        }
        return count;
    }
}