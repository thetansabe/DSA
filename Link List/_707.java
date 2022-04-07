
// runtime 5ms __ design linked list
class MyLinkedList {
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        
        ListNode(int val) {
            this.val = val;
        }
    }
    
    private final ListNode head;
    private int size;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0);
        //con tro next va pre tro lai chinh no (head)
        head.next = head;
        head.prev = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        return getPrev(index).next.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addNode(head, head.next, new ListNode(val));
        ++size;
        return;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addNode(head.prev, head, new ListNode(val));
        ++size;
        return;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        ListNode prev = getPrev(index);
        ListNode cur = new ListNode(val);
        addNode(prev, prev.next, cur);
        ++size;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode prev = getPrev(index);
        deleteNode(prev);
        --size;
    }
    
    private ListNode getPrev(int index) {
        ListNode prev = head;
        if (index <= size / 2)
            for (int i = 0; i < index; ++i)
                prev = prev.next;

        else {
            index = size - index;
            for (int i = 0; i <= index; ++i)
                prev = prev.prev;
        }
        return prev;
    }
    
    private void addNode(ListNode prev, ListNode next, ListNode cur) {
        prev.next = cur;
        cur.next = next;
        cur.prev = prev;
        next.prev = cur;
    }
    
    private void deleteNode(ListNode prev) {
        ListNode cur = prev.next;
        ListNode next = cur.next;
        prev.next = next;
        next.prev = prev;
        cur.next = null;
        cur.prev = null;
    }
}