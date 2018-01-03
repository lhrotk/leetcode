package leet.algorithm.q148;


public class Solution {
	class result{
		ListNode head;
		ListNode tail;
		public result(ListNode head, ListNode tail) {
			this.head = head;
			this.tail = tail;
		}
	}
	
	public result qSortList(ListNode head){
		if(head == null) {
			return new result(null, null);
		}
		
		ListNode rulerhead = head;
		ListNode rulertail = head;
		ListNode sm = new ListNode(-1);
		ListNode smit = sm;
		ListNode big = new ListNode(-1);
		ListNode bigit = big;
		head = head.next;
		while(head!=null) {
			if(head.val>rulerhead.val) {
				bigit.next = head;
				bigit = head;
				head = head.next;
				bigit.next = null;
			}else if(head.val<rulerhead.val){
				smit.next = head;
				smit = head;
				head = head.next;
				smit.next = null;
			}else {
				rulertail.next = head;
				rulertail = head;
				head = head.next;
				rulertail.next = null;
			}
		}
		
		result re1 = this.qSortList(sm.next);
		result re2 = this.qSortList(big.next);
		
		if(re1.head == null) {
			sm.next = rulerhead;
		}else {
			sm.next = re1.head;
			re1.tail.next = rulerhead;
		}
		
		if(re2.head == null) {
			rulertail.next = null;
			return new result(sm.next, rulertail);
		}else {
			rulertail.next = re2.head;
			return new result(sm.next, re2.tail);
		}
	}
	
	public ListNode sortList(ListNode head) {
		result re = this.qSortList(head);
		return re.head;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode ite = sol.sortList(node1);
		while(ite!=null) {
			System.out.println(ite.val);
			ite = ite.next;
		}
	}
}
