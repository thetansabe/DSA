public class MyLinkedListStack implements IStackQueue{
    private class Node{
        int value;
        Node next;
        Node(int val){this.value = val;}
    }

    private Node topNode;

    MyLinkedListStack(){
        topNode = null;
    }
    @Override
    public boolean push(int val){
        //addToHead linkedlist
        Node newNode = new Node(val);
        newNode.next = topNode;
        topNode = newNode;
        return true; //luon them thanh cong
    }

    public int pop(){
        //Ko co value de pop => dang li' throw loi
        if(isEmpty()) return -1;
        
        int val = topNode.value;
        topNode = topNode.next;
        return val;
    }
    
    public boolean isFull(){
        return false;
    }

    public boolean isEmpty(){
        return topNode == null;
    }

    public void show(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
            System.out.println("Top to bottom:");
            Node temp = topNode;
            while(temp != null){
                System.out.print(temp.value+" ");
                temp = temp.next;
            }
        }
    }

}