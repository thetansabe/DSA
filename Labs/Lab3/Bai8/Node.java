public class Node <E> {

private E data;
private Node <E> next;
public Object nextNode;
public Node(){
    data = null;
    next = null;
}

public Node(E data){
    this(data, null);
}

public Node(E data, Node <E> next){
    this.data = data;
    this.next = next;
}
public Node <E> getNext(){
    return next;
}
public E getData(){
    return data;
}
public void setData(E data){
    this.data = data;
}
public void setNext(Node <E> n){
    next = n;
}

public int compare(E otherNode){
    //0 => =
    //-1 => this.compare(other) => this < other
    //1 => this > other
    if(otherNode instanceof Integer){
        int a = (Integer)this.getData();
        int b = (Integer)otherNode;
        if(a>b) return 1;
        if(a<b) return  -1;
        return 0;
    }
    return 0;
}

}