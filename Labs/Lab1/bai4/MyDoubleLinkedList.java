import java.util.NoSuchElementException;

public class MyDoubleLinkedList
{
    private DoubleNode<Double> head;
    private int numNode;

    public MyDoubleLinkedList(){
        head = null;
        numNode = 0;
    }

    public void addFirst(Double item){
        head = new DoubleNode<>(item, head);
        numNode++;
    }

    public void add(DoubleNode<Double> current, Double item){
        if(current == null){
            addFirst(item);
        } else {
            DoubleNode<Double> nodeMoi = new DoubleNode<>(item, current.getNext());
            current.setNext(nodeMoi);
        }
        numNode++;
    }

    public void addLast(double item){
        if(head == null) addFirst(item);
        else{
            DoubleNode<Double> tmp = head;
            while(tmp.getNext() != null){
                tmp = tmp.getNext();
            }   
    
            DoubleNode<Double> newNode = new DoubleNode<Double>(item, null);
            tmp.setNext(newNode);
            numNode++;
        }
    }

    public double removeFirst() throws NoSuchElementException{
        if(head == null){
            throw new NoSuchElementException("Can't remove element from an empty list");
        }
        else{
            DoubleNode<Double> tmp = head;
            head = head.getNext();
            numNode --;
            return tmp.getData();
        }
    }

    public Double remove(DoubleNode<Double> curr) throws NoSuchElementException{
        if(curr == null){
            throw new NoSuchElementException("List khong co phan tu de xoa");
        } else {
            DoubleNode<Double> now = head;
            if(now.getData() == curr.getData()) {
              DoubleNode<Double> res = now.getNext();
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
              DoubleNode<Double> res = now.getNext();
              now.setNext(now.getNext().getNext());
              numNode--;
              return res.getData();
            }
        }
    }

    public int find(double a){
        int idx = 0; 
        DoubleNode<Double> tmp = new DoubleNode<>();
        while(tmp != null){
            double x = (Double) tmp.getData();
            if(x == a)  return idx;
            else    idx++;
            tmp.getNext();
        }
    return idx;
    }

    public double findMax(){
        DoubleNode<Double> tmp = head;
        double max = (Double) head.getData();
        while(tmp != null){
            double t = (Double) tmp.getData();
            if(t > max) max = t;
            tmp = tmp.getNext();
        }
        return max;
    }

    public void print(){
        if(head != null){
            DoubleNode<Double> tmp = head;
            System.out.print("List: " + tmp.getData());
            tmp = tmp.getNext();
            while(tmp != null)
            {
                System.out.print(" -> " + tmp.getData());
                tmp = tmp.getNext();
            }
                System.out.println();
        } else {
                System.out.println("List nay khong co!");
        }
    }

}