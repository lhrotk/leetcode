package leet.algorithm.q92;

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode zero = new ListNode(0);
        zero.next = head;
        ListNode ite = zero;
        for(int i=0; i<m-1; i++) {
        	ite = ite.next;
        }
        ListNode preReverse = ite;
        ite = ite.next;
        ListNode reverseHead = ite;
        ListNode pre = ite;
        ite = ite.next;
        for(int i=m+1; i<=n; i++) {
        	ListNode temp = ite.next;
        	ite.next = pre;
        	pre = ite;
        	if(i==n) {
        		preReverse.next = ite;
        	}
        	ite = temp;
        }
        reverseHead.next = ite;
        return zero.next;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode result = sol.reverseBetween(node1, 4, 5);
		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
	}
}
