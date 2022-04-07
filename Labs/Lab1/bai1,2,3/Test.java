public class Test {
    public static void main(String[] args){
    MyLinkedList <Integer> list = new MyLinkedList <Integer>();
    list.addFirst(4);
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(6);
  
    //list.addLast((1));
    list.print();
    System.out.println("Remove: ");
    Node<Integer> curr = new Node<Integer>(6);
    list.removeCurr(curr);
    list.print();
    // list.removeFirst();
    // list.print();
    System.out.println("Count even number: ");
    System.out.println(list.countEven());
    System.out.println("Count prime number: ");
    System.out.println(list.countPrime());
    System.out.println("Add before first even num (7): ");
    list.addBeforeFirstEven(7);
    list.print();
    System.out.println("Find max element: ");
    System.out.println(list.findMax());
    System.out.println("Sort by ascending order: ");
    list.bubbleSort();
    list.print();
    System.out.println("Sort by descending order: ");
    list.reverse();
    list.print();
    }
}