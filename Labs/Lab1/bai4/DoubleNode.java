public class DoubleNode<Double>
{
    private double a;
    private DoubleNode<Double> Next;

    public DoubleNode(){
        this.a = 0.0;
        this.Next = null;
    }

    public DoubleNode(double a){
        this(a,null);
    }
    public DoubleNode(double a, DoubleNode<Double> next) {
        this.a = a;
        Next = next;
    }
    public double getData() {
        return a;
    }
    
    public void setData(int a) {
        this.a = a;
    }
    public DoubleNode<Double> getNext() {
        return Next;
    }
    public void setNext(DoubleNode<Double> next) {
        Next = next;
    }
}