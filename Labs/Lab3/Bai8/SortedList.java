//Bai 8a
//addSortedList to LinkList

class SortedList <E>{
    private Node<E> headNode;
    private Node<E> firstBigNode;
    private int count;

    SortedList(){
        headNode = null;
        firstBigNode = null;
        count = 0;
    }

    public void addSortedList(E value){
        Node<E> newNode = new Node<E>(value);
        //moi tao list
        if(headNode == null){
            headNode = newNode;
            headNode.setNext(null);
            firstBigNode = headNode;
            count++;
            return;
        }

        //Tim first big node
        Node<E> tmp = headNode;
        Node<E> prev = null;
        
        //this.compare(other.getData())
        //0 => this = other
        //-1 =>this < other
        //1 => this > other

        //mang co' 1 phan tu thi khoi tim
        if(count > 1){
            while(tmp != null){
                firstBigNode = tmp;
                if(tmp.compare(newNode.getData()) == 1) break;
                prev = tmp;
                tmp = tmp.getNext();
            }
        }

        //add new node
        if(firstBigNode.compare(newNode.getData()) == -1){//big < new 
            //-> add sau big -> cap nhat big
            firstBigNode.setNext(newNode);  
        }else{//big >= new -> add new trc big
            if(prev == null) {//big dung o head -> cap nhat head
                newNode.setNext(firstBigNode);
                headNode = newNode;
            }else{
                newNode.setNext(firstBigNode);
                prev.setNext(newNode);
            }    
        }

        count++;
    }
    ////////////cau b
	public int countEvenInt() {
		Node<E> cur = headNode;
		int count = 0;
		while (cur != null) {
			if ((Integer)cur.getData() % 2 == 0) count++;
			cur = cur.getNext();
		}
		return count;
    }
    
	public int sumInt() {
		Node<E> cur = headNode;
		int sum = 0;
		while (cur != null) {
			sum += (Integer)cur.getData();
			cur = cur.getNext();
		}
		return sum;
    }
    
    public void show(){
        Node<E> tmp = headNode;
        System.out.print("Linked List: "+tmp.getData());
        tmp = tmp.getNext();
        while(tmp != null){
            System.out.print("->"+tmp.getData());
            tmp = tmp.getNext();
        }
        System.out.println();
    }
}