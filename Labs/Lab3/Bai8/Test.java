class Test{
    public static void main(String[] args) {
        // Node<Integer> node1 = new Node<>(5);
        // Node<Integer> node2 = new Node<>(3);
        // System.out.println(node1.compare(node2.getData()));

        SortedList<Integer> list = new SortedList<>();
        list.addSortedList(5);
        list.addSortedList(6);
        list.addSortedList(2);
        list.addSortedList(1);
        list.addSortedList(7);
        list.addSortedList(1);
        list.addSortedList(3);
        
        list.show();
        
    }
}