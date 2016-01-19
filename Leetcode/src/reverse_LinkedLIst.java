package bloomberg;

public class reverse_LinkedLIst {
	public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode pre = dummy;
        pre.next = head;
        while(next!=null){
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return dummy.next;
        
    }

}
