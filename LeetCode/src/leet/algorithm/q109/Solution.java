package leet.algorithm.q109;

public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        	return null;
        ListNode node1 = head;
        ListNode node2 = head;
        ListNode preNode2 = head;
        while(node1.next!=null&&node1.next.next!=null) {
        	node1 = node1.next.next;
        	preNode2 = node2;
        	node2 = node2.next;
        }
        TreeNode root = new TreeNode(node2.val);
        if(preNode2 != node2) {
        	preNode2.next = null;
        	root.left = this.sortedListToBST(head);
        }
        root.right = this.sortedListToBST(node2.next);
        return root;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode node1 = new ListNode(-10);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		TreeNode result = sol.sortedListToBST(node1);
		System.out.println(result.val);
	}
}
