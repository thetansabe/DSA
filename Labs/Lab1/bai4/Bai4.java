public class Bai4
{
    public static void main(String[] args)
    {
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.addFirst(1.2);
        list.addLast(4.3);
        list.addLast(5.4);
        list.addLast(3.6);
        list.addLast(0.3);
        list.print();
        DoubleNode<Double> curr = new DoubleNode<Double>(5.4);
        System.out.println("Remove: ");
        list.remove(curr);
        list.print();
        System.out.println("Node o vi tri: " + list.find(3.6));
        System.out.println("Max num: " + list.findMax()); 
    }
}
