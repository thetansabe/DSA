public class MyLinkedListQueue implements IStackQueue{
    private class Node{
        int value;
        Node next;
        Node(int val){this.value = val;}
    }

    private Node headNode;
    private Node tailNode;

    MyLinkedListQueue(){
        headNode = null;
        tailNode = null;
    }

    @Override
    public boolean push(int val){
        //addToTail linkedlist
        Node newNode = new Node(val);
        
        if(isEmpty()){ //moi tao list
            headNode = tailNode = newNode;
        }
        tailNode.next = newNode;
        tailNode = newNode;
        
        return true; //luon them thanh cong
    }

    public int pop(){
        //Ko co value de pop => dang li' throw loi
        if(isEmpty()) return -1;
        
        int val = headNode.value;
        if(tailNode == headNode){ //Khi mang co 1 ptu
            headNode = tailNode = null;
            return val;
        }else{
            headNode = headNode.next;
        }
        
        return val;
    }
    
    public boolean isFull(){
        return false;
    }

    public boolean isEmpty(){
        return tailNode == null;
    }

    public void show(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }else{
            System.out.println("First to last (Head to tail):");
            Node temp = headNode;
            while(temp != null){
                System.out.print(temp.value+" ");
                temp = temp.next;
            }
        }
    }
}