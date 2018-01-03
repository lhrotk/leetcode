package leet.algorithm.q143;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	public void reorderList(ListNode head) {
		Queue<ListNode> queue = new LinkedList<ListNode>();
		Stack<ListNode> stack = new Stack<ListNode>();
		Stack<ListNode> stack1 = new Stack<ListNode>();
		ListNode i = head;
		while(i!=null) {
			stack.add(i);
			i = i.next;
		}
		
		int size = stack.size()/2;
		for(int k=0; k<size; k++) {
			queue.add(stack.pop());
		}
		
		while(!stack.isEmpty()) {
			stack1.add(stack.pop());
		}
		
		for(int k=0; (!stack1.empty())||(!queue.isEmpty()); k++){
			if(k%2==0) {
				stack1.pop().next = queue.peek();
				
			}else {
				if(stack1.isEmpty()) {
					queue.poll().next = null;
				}else {
					queue.poll().next = stack1.peek();
				}
			}
		}
		
		return;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Solution sol = new Solution();
		sol.reorderList(node1);
		while(node1!=null) {
			System.out.println(node1.val);
			node1 = node1.next;
		}
	}
}
