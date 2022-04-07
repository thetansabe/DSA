//bai hoan chinh o lab1 -> MyLinkedList
//code duoi day de tham khao, khong run duoc

class bubbleSort{
    public void sort(){
        for(int i = 0;i<numNode;i++){
            Node<E> curNode = head;
            Node<E> next = head.getNext();
            for(int j = 0;j<numNode-1;j++){
                int curVal = (Integer) curNode.getData();
                int nextVal = (Integer) next.getData();
                if(curVal > nextVal){
                    E tmp = curNode.getData();
                    curNode.setData(next.getData());
                    next.setData(tmp);
                }
                curNode = next;
                next = next.getNext();
            }
        }
    }
}

