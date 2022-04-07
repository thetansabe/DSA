//Test bai 1 2 6
class Test{
    public static void main(String[] args) {
        MyStack<Fraction> stack = new MyStack<Fraction>();
        MyQueue<Fraction> queue = new MyQueue<Fraction>();
        QueueFormStacks<Fraction> queueFormStacks = new QueueFormStacks<Fraction>();

        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,4);
        Fraction f3 = new Fraction(3,7);
        Fraction f4 = new Fraction(6,7);
        
        //Stack
        stack.push(f1);
        stack.push(f2);
        stack.push(f3);
        stack.push(f4);
        System.out.println("Pop: "+ stack.pop());
        stack.show();
        
        //Queue
        queue.add(f1);
        queue.add(f2);
        queue.add(f3);
        queue.add(f4);
        System.out.println("Poll: "+ queue.poll());
        queue.show();

        //Queue from 2 stacks
        queueFormStacks.add(f1);
        queueFormStacks.add(f2);
        queueFormStacks.add(f3);
        queueFormStacks.add(f4);
        System.out.println("Poll: "+ queueFormStacks.poll());
        System.out.println("Poll: "+ queueFormStacks.poll());
        System.out.println("Poll: "+ queueFormStacks.poll());
        System.out.println("Poll: "+ queueFormStacks.poll());
    }
}