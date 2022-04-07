//Bai 8a lab 3
//add to SortedLinkedList
//day la code tham khao ko run dc

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
        //cach dung obj1.compare(obj2.value)
        //0 => obj1.value = obj2.value
        //-1 => obj1.value < obj2.value
        //1 => obj1.value > obj2.value
        if(count > 1){
            while(tmp != null){
                firstBigNode = tmp;
                if(tmp.compare(newNode.getData()) == 1) break;
                prev = tmp;
                tmp = tmp.getNext();
            }
        }

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

    //////////Redo cho gon. hon
    // public void add(int n){
    //     Node newNode = new Node(n,null);
    //     Node prev = null;
    //     Node tmp = head;

    //     //khong co ptu nao -> add dau`
    //     if(head == null) {
    //         head = newNode;
    //         return;
    //     }
    //     //tim phan tu lon nhat dau tien -> add phia truoc
        
    //     while(tmp != null){
    //         if(tmp.getData() > n){
    //             if(prev == null){ //phan tu dau tien lon' hon so' dc add
    //                 newNode.setNext(tmp);
    //                 head = newNode;
    //                 return;
    //             }
    //             newNode.setNext(tmp);
    //             prev.setNext(newNode);
    //             return;
    //         }
    //         prev = tmp;
    //         tmp = tmp.getNext();
    //     }
    //     //add tail neu ko co' ptu lon hon
    //     prev.setNext(newNode);
    // }

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