package bloomberg;

public class random_linkedlist {
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode cur1 = head;
        RandomListNode next = cur1.next;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur2 = dummy;
        while(cur1!=null){
            cur2 = new RandomListNode(cur1.label);
            cur1.next = cur2;
            cur2.next = next;
            cur1 = next;
            if(cur1==null) break;
            next = cur1.next;
        }
        cur2.next = null;
        cur1 = head;
        cur2 = cur1.next;
        dummy.next = cur2;
        while(cur1!=null&&cur1.next!=null){
            if(cur1.random==null) cur2.random = null;
            else cur2.random = cur1.random.next;
            cur1 = cur1.next.next;
            if(cur1==null) break;
            cur2 = cur1.next;
        }
        cur1 = head;
        cur2 = cur1.next;
        RandomListNode head1 = cur1.next;
        while(cur1!=null){
            cur1.next = cur2.next;
            cur1 = cur1.next;
            if(cur1==null) break;
            cur2.next = cur1.next;
            cur2 = cur2.next;
        }
        return head1;
        
    }

}
