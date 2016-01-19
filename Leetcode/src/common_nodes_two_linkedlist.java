package bloomberg;

public class common_nodes_two_linkedlist {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if(headA==null||headB==null) return null;
	        ListNode curA=headA;
	        ListNode curB=headB;
	        int countA=0;
	        int countB=0;
	        while(curA!=null){
	            curA = curA.next;
	            countA++;
	        }
	        
	        while(curB!=null){
	            curB=curB.next;
	            countB++;
	        }
	        curA=headA;
	        curB=headB;
	        if(countA>countB){
	            int dif = countA-countB;
	            while(dif>0){
	                curA = curA.next;
	                dif--;
	            }
	        }
	        else{
	            int dif = countB-countA;
	            while(dif>0){
	                curB=curB.next;
	                dif--;
	            }
	        }
	        while(curA!=null&&curB!=null){
	            if(curA.val==curB.val) return curA;
	            else{
	                curA = curA.next;
	                curB = curB.next;
	            }
	        }
	        return null;
	        
	    }

}
