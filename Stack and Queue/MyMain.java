class MyMain{
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.pop();
        queue.pop();
        queue.pop();
        queue.push(0);
        queue.show();
    }
}