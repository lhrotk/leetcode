package leet.algorithm.q147;

import javax.xml.transform.Result;

public class Solution {
	public ListNode insertionSortList(ListNode head) {
        if(head == null)
        	return head;
        ListNode resultHead = head;
        head = head.next;
        resultHead.next = null;
        while(head!=null) {
        	ListNode newOne = head;
        	head = head.next;
        	if(newOne.val<=resultHead.val) {
        		newOne.next = resultHead;
        		resultHead = newOne;
        	}else {
        		ListNode ite = resultHead;
        		while(ite.next!=null) {
        			if(newOne.val<=ite.next.val) {
        				ListNode temp = ite.next;
        				ite.next = newOne;
        				newOne.next = temp;
        				break;
        			}
        			ite = ite.next;
        		}
        		if(ite.next == null) {
        			ite.next = newOne;
        			newOne.next = null;
        		}
        	}
        	
        }
        return resultHead;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode ite = sol.insertionSortList(node1);
		while(ite!=null) {
			System.out.println(ite.val);
			ite = ite.next;
		}
	}
}
