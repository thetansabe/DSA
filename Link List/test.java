import java.util.*;

interface ListInterface <E> {
    /*Basic*/
    public boolean isEmpty();
    public int size();
    public E getFirst() throws NoSuchElementException; 
    public boolean contains(E item);
    public void addFirst(E item);
    public E removeFirst() throws NoSuchElementException; 
    public void print();
    
    /*New - Enhance*/
    public ListNode <E> getHead(); 
    public void addAfter(ListNode <E> current, E item);
    // public E removeAfter(ListNode <E> current) 
    //             throws NoSuchElementException;
    // public E remove(E item) throws NoSuchElementException;
}

class ListNode <E> {
    /* data attributes */
    private E element;
    private ListNode <E> next;
    
    /* constructors */
    public ListNode(E item) { this(item, null); }
    
    /*{
    Element = item;
    Next = null;
    }*/

    
    public ListNode(E item, ListNode <E> n) { 
        element = item; 
        next = n;
    }

    /* get the next ListNode */
    public ListNode <E> getNext() { return next; }

    /* get the element of the ListNode */
    public E getElement() { return element; }

    /* set the next reference */
    public void setNext(ListNode <E> n) { next = n; }
}

class BasicLinkedList <E> implements ListInterface <E> {
    private ListNode <E> head = null;
    private int num_nodes = 0;
    
    public boolean isEmpty() { return (num_nodes == 0); }
    
    public int size() { return num_nodes; }
    
    public E getFirst() throws NoSuchElementException {
        if (head == null) 
            throw new NoSuchElementException("This is a empty list!!!");
        else return head.getElement();
    }
    
    public boolean contains(E item) {
        for (ListNode <E> n = head; n != null; n = n.getNext())
            if (n.getElement().equals(item)) return true;
        return false;
    }

    public void addFirst(E item) {
        head = new ListNode <E> (item, head);
        //ListNode p = new ListNode (item);
        //p.setNext(head);//p.next = head
        //head = p;
        num_nodes++;
    }
        
    public E removeFirst() throws NoSuchElementException {
        ListNode <E> ln; /*ln = list node*/
        
        if (head == null) 
            throw new NoSuchElementException("can't remove from empty list");
        else { 
            ln = head;
            head = head.getNext();
            num_nodes--;
            return ln.getElement();
        }
    }

    public void print() throws NoSuchElementException {
        if (head == null)
            throw new NoSuchElementException("Nothing to print...");
        
        ListNode <E> ln = head;
        System.out.print("List is: " + ln.getElement());
        
        for (int i=1; i < num_nodes; i++) {
            ln = ln.getNext();
            System.out.print(", " + ln.getElement());
        }
        System.out.println(".");
        }

    /*New - Enhance*/
    public ListNode <E> getHead(){return head;}; 
    
    public void addAfter(ListNode <E> current, E item) {
        if (current != null) { 
        // current.setNext(new ListNode <E>(item,current.getNext()));
            ListNode<E> p = new ListNode<E>(item);
            
            p.setNext(current.getNext());
            current.setNext(p);
        } else { 
            // insert item at front
            head = new ListNode <E> (item, head);
        }
        num_nodes++;
        }
}

class BasicLs1 {
    public static void main(String [] args) 
                        throws NoSuchElementException {
    
    BasicLinkedList <Integer> list = new BasicLinkedList <Integer>();
    list.addFirst(4);
    list.addFirst(7);
    list.addFirst(8);
    list.print();
    
    // System.out.println("Testing removdal");
    // list.removeFirst();
    // list.print();
    
    // if (list.contains(8)) list.addFirst(1);
    // list.print();
    
    System.out.println("Testing add after");
    //p: vi tri' de add phan tu x
    ListNode<Integer> p = list.getHead();
    list.addAfter(p,7);
    list.print();
    }
}