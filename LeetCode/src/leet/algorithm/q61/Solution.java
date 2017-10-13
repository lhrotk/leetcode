package leet.algorithm.q61;

public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null)
			return head;
        int length = 1;
        ListNode iterator = head;
        while(iterator.next != null) {
        	iterator = iterator.next;
        	length++;
        }
        k = length-k%length;
        if(k==0)
        	return head;
        else {
        	ListNode iterator2 = head;
        	for(int i=0; i<k-1; i++) {
        		iterator2 = iterator2.next;
        	}
        	iterator.next = head;
        	head = iterator2.next;
        	iterator2.next = null;
        	return head;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		Solution sol = new Solution();
		ListNode result = sol.rotateRight(node1, 6);
		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
		System.out.println("null");
	}

}
