package bloomberg;

public class LinkedList_Circle {
	public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        if(head.next==null) return false;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode next = dummy;
        dummy.next = head;
        while(next!=null&&next.next!=null){
            pre = pre.next;
            next = next.next.next;
            if(next==null) return false;
            if(pre.val==next.val) return true;
        }
        return false;
    }

}
