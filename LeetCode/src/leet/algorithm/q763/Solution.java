/**
 * 
 */
package leet.algorithm.q763;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aupera
 *
 */
public class Solution {
	class LinkedList{
		int startIndex;
		int endIndex;
		LinkedList next;
		public LinkedList(int start, int end) {
			this.startIndex = start;
			this.endIndex = end;
		}
	}
	
	public List<Integer> partitionLabels(String S) {
		if(S.length()==0)
			return null;
        int[] firstOccurance = new int[26];
        LinkedList head =  new LinkedList(-1, -1);
        LinkedList tail = head;
        for(int i=0; i<S.length(); i++){
        	char temp = S.charAt(i);
        	if(firstOccurance[temp-'a']==0) {
        		firstOccurance[temp-'a'] = i+1;
        		LinkedList newPoint = new LinkedList(i,i);
        		tail.next = newPoint;
        		tail = tail.next;
        	}else {
        		LinkedList ite = head.next;
        		LinkedList pre = head;
        		for(; ite!=null; ite=ite.next, pre = pre.next) {
        			if(ite.endIndex>=firstOccurance[temp-'a']-1) {
        				pre.next = new LinkedList(ite.startIndex, i);
        				tail = pre.next;
        				break;
        			}
        		}
        	}
        }
        List<Integer> result = new ArrayList<Integer>();
        for(LinkedList ite = head.next; ite!=null; ite=ite.next){
        	result.add(ite.endIndex-ite.startIndex+1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.partitionLabels("aaaaaaaaaaaabbbbbbbbbbasdfasdfannnnnn"));
	}
}
