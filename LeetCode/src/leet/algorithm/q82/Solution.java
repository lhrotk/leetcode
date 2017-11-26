package leet.algorithm.q82;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode currentValid = result;
        while(currentValid.next != null) {
        	ListNode test = currentValid.next;
        	ListNode tail = test;
        	while(tail.next!=null&&tail.next.val==test.val) {
        		tail = tail.next;
        	}
        	if(tail == test) {
        		currentValid = test;
        	}else {
        		currentValid.next = tail.next;
        	}
        }
        return result.next;
    }
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		Solution sol = new Solution();
		ListNode result = sol.deleteDuplicates(node1);
		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
	}
}
