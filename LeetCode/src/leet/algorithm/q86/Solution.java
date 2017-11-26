package leet.algorithm.q86;

public class Solution {
	public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode lessPointer = lessHead;
        ListNode moreHead = new ListNode(0);
        ListNode morePointer = moreHead;
        while(head!=null) {
        	if(head.val<x) {
        		lessPointer.next = head;
        		lessPointer = head;
        	}else {
        		morePointer.next = head;
        		morePointer = head;
        	}
        	head = head.next;
        }
        morePointer.next = null;
        lessPointer.next = null;
        if(lessHead.next == null)
        	return moreHead.next;
        lessPointer.next = moreHead.next;
        return lessHead.next;
    }
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		node1.next = node2;
		Solution sol = new Solution();
		ListNode result = sol.partition(node1, 2);
		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
	}
}
