import java.util.NoSuchElementException;
import java.util.*;
public class MyLinkedList <E> implements ListInterface <E> {

private Node <E> head;
private int numNode;
public MyLinkedList(){
    head = null;
    numNode = 0;
}

@Override
public void addFirst(E item){
    head = new Node<E>(item, head);
    numNode++;
}
@Override
public void addAfter(Node<E> curr, E item){
    if(curr == null){
        addFirst(item);
    }
    else{
        Node<E> newNode = new Node<E>(item, curr.getNext());
        curr.setNext(newNode);
    }
        numNode++;
}

@Override
public void addLast(E item){
    if(head == null) addFirst(item);
    else{
        Node<E> tmp = head;
        while(tmp.getNext() != null){
            tmp = tmp.getNext();
        }   

        Node<E> newNode = new Node<E>(item, null);
        tmp.setNext(newNode);
        numNode++;
    }
}

@Override
public E removeFirst() throws NoSuchElementException{
    if(head == null){
        throw new NoSuchElementException("Can't remove element from an empty list");
    }
    else{
        Node<E> tmp = head;
        head = head.getNext();
        numNode --;
        return tmp.getData();
    }
}

@Override
public void print(){
    if(head != null){
        Node<E> tmp = head;
        System.out.print("List: " + tmp.getData());
        tmp = tmp.getNext();
        while(tmp != null){
            System.out.print(" -> " + tmp.getData());
            tmp = tmp.getNext();
        }
        System.out.println();
    }else{
        System.out.println("List is empty!");
    }
}


public E removeCurr(Node<E> curr) 
    throws NoSuchElementException
{
    if(curr == null) {
        throw new NoSuchElementException("cant find");
    }else {
        // //int count = 0;
        // // Node<E> prev = null;
        // Node<E> curNode = head;
    
        // if(curNode.getData() == curr.getData()){
        //     return removeFirst();
        // }
    
        // // while(curNode != null && curNode.getNext() != null){
        // //     if(curNode.getNext().getData() == curr.getData()){
        // //         prev = curNode;
        // //         break;
        // //     }
        // //     curNode = curNode.getNext();
        // // }
        // // prev.setNext(curNode.getNext().getNext());
        // // numNode--;
    
        // // while(curNode != null){
        // //     if(curNode.getData() == curr.getData()){
        // //         System.out.print(curNode.getData()+" ");
        // //         prev.setNext(curNode.getNext());
        // //         numNode--;
        // //         return curr.getData(); //thanh cong
        // //     }
        // //     prev = curNode;
        // //     curNode = curNode.getNext();
        // // }
        
        // // return curr.getData();
    
        
        // while(curNode.getNext() != null){
        //     if(curNode.getNext().getData() == curr.getData()){
        //         System.out.println(curNode.getData());
        //         System.out.println(curr.getData());
        //         break;
        //     }
        //     curNode = curNode.getNext();
        // }
        // Node<E> res = curNode.getNext();
        // curNode.setNext(curNode.getNext().getNext());
        // numNode -- ;
        // return res.getData();
        Node<E> now = head;
      if(now.getData() == curr.getData()) {
        Node<E> res = now.getNext();
        removeFirst();
        return res.getData();
      }
      else {
        while(now.getNext() != null) {
          if(now.getNext().getData() == curr.getData()){
            break;
          }
          now = now.getNext();
        }
        Node<E> res = now.getNext();
        now.setNext(now.getNext().getNext());
        numNode--;
        return res.getData();
    }

    }
}

public int countEven(){
    Node<E> tmp = head;
    int count = 0;
    while(tmp != null){
        int t =  (Integer) tmp.getData();
        if(t % 2 == 0){
            count++;
        }
        tmp = tmp.getNext();
    }
    return count;
}

public int countPrime(){
    int count = 0;
    for(Node<E> k = head; k != null; k = k.getNext()){
        int c = 0;
        int t =  (Integer) k.getData();
            for(int i = 1; i <= t; ++i){
                if(t % i == 0){
                    c++;
                }
            }
        if(c == 2)  count++;
    }
    return count;
}

public boolean addBeforeFirstEven(E item){
    Node<E> tmp = head;
    Node<E> prev = new Node<>();
    while(tmp.getNext() != null){
        int t =  (Integer) tmp.getData();
        if(t % 2 == 0 && tmp == head){
            head = new Node<E>(item, head); 
            numNode++;
            break;
        } else if(t % 2 == 0 && tmp != head){
            for(Node<E> k = head; k != null; k = k.getNext()){
                if(tmp.getData() == k.getData()){
                   addAfter(prev, item);
                } 
                prev = k;
            }
        }
        tmp = tmp.getNext();
    }  
    return false;
}

public int findMax(){
    Node<E> tmp = head;
    int max = (Integer) head.getData();
    while(tmp != null){
        int t = (Integer) tmp.getData();
        if(t > max) max = t;
        tmp = tmp.getNext();
    }
    return max;
}

public Node <E> getHead(){
    return head;
}

//////////// sort
public void bubbleSort(){
    for(int i = 0;i<numNode;i++){
        Node<E> curNode = head;
        Node<E> next = head.getNext();
        for(int j = 0;j<numNode-1;j++){
            int curVal = (Integer) curNode.getData();
            int nextVal = (Integer) next.getData();
            if(curVal > nextVal){
                E tmp = curNode.getData();
                curNode.setData(next.getData());
                next.setData(tmp);
            }
            curNode = next;
            next = next.getNext();
        }
    }
}

///reverse
public void reverse(){
    Node<E> curNode = head;
    while(curNode != null && curNode.getNext() != null){
        Node<E> nextNode = curNode.getNext();
        curNode.setNext(nextNode.getNext());
        nextNode.setNext(head);
        head = nextNode;
    }
    return;
}

}