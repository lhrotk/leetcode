package leet.algorithm.q142;

public class Solution {
	public ListNode detectCycle(ListNode head) {
		if(head == null)
			return null;
		ListNode po1 = head;
		ListNode po2 = head.next;
		int cycLength = 1;
		while(true) {
			if(po2==null||po2.next==null) {
				return null;
			}else if(po1 == po2) {
				break;
			}else {
				po1 = po1.next;
				po2 = po2.next.next;
				cycLength++;
			}
		}
		
		po1 = head;
		po2 = head;
		for(int i=0; i<cycLength; i++) {
			po2 = po2.next;
		}
		
		while(po2!=po1) {
			po1 = po1.next;
			po2 = po2.next;
		}
		
		return po1;
	}
}
