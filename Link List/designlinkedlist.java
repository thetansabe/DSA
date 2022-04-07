//_707 runtime 14ms
class Node{
    int val;
    Node next;
    Node(int x){ val =  x;}
}
class MyLinkedList{
    private Node head;
    //empty constructor
    public MyLinkedList(){
        head = null;
    }
    //get value at index. index ko ton tai retrun -1
    public int get(int index){
        Node tempNode = head;
        int count = 0;
        while(tempNode != null){
            if(count == index) return tempNode.val;
            count++;
            tempNode=tempNode.next;
        }
        return -1;
    }
    //them vao dau list
    public void addAtHead(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }
    //them vao cuoi list
    public void addAtTail(int val){
        Node lastNode = head;
        while(lastNode != null){
            //Xac dinh last node
            if(lastNode.next == null){
                Node newNode = new Node(val);
                lastNode.next = newNode;
                return;
            }
            lastNode = lastNode.next;
        }
        //TH list trong phai addHead
        addAtHead(val);
    }
    //them vao vi tri index
    public void addAtIndex(int index,int val){
        int count=0;
        //TH list ko co phan tu nao
        if(index == 0) addAtHead(val);
        //TH chinh
        else{
            Node cur = head;
            Node newNode = new Node(val);
            
            while (cur != null){
                if(count == (index - 1)){
                    newNode.next = cur.next;
                    cur.next = newNode;
                    return;
                }
                count++;
                cur = cur.next;
            }
        }
        //TH index == length list thi` append cuoi'
        if(count == index ) addAtTail(val);
    }
    //Delete index note
    public void deleteAtIndex(int index){
        Node cur = head;
        int count = 0;
        Node prev = null;

        while (cur != null){
            if(count == index){
                //TH xoa ptu dau tien
                if(index == 0){
                    head = head.next;
                }else{
                    prev.next = cur.next;
                    return;
                }
            }
            count++;
            prev = cur;
            cur = cur.next;
        }
    }
    //print
    public void printList(){
        Node temp = head;
        System.out.print("List: ");
        
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        
        //obj.addAtHead(1); obj.printList();
        obj.addAtTail(1); obj.printList();
        //obj.addAtIndex(1,2); obj.printList();
        //obj.deleteAtIndex(1); obj.printList();
    
        int param_1 = obj.get(0);
        System.out.print(param_1);
    }
}

