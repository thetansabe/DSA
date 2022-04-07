public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class mergeSort{
    public ListNode sortList(ListNode head){
        //Neo:
        if(head == null || head.next == null) return head;
        //Chia va get mid
        ListNode mid = getMidAndSplit(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        //Tron
        return merge(left,right);
    }

    public ListNode getMidAndSplit(ListNode head){
        ListNode midPrev = null;
        while(head != null && head.next != null){
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
    //merge 2 sorted lists
    public ListNode merge(ListNode l1,ListNode l2){
        //l1, l2 == list 1, list 2
        if(l1 == null) return l2; //chu y' khi duyet het l1 thi` buoc tra ve con tro l2;
        if(l2 == null) return l1;

        if(l1.val <= l2.val){ //lay phan tu cua l1
            ListNode nextL1 = l1.next;
            ListNode nextElement = merge(nextL1,l2);
            l1.next = nextElement;
            return l1;
        }else{ //lay phan tu cua l2
            merge(l2,l1);
            return l2;
        }
    }
}