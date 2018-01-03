package leet.algorithm.q138;

import java.util.HashMap;

public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode i = head;
        while(i!=null) {
        	map.put(i, new RandomListNode(i.label));
        	i = i.next;
        }
        
        i = head;
        while(i!=null) {
        	map.get(i).next = map.get(i.next);
        	map.get(i).random = map.get(i.random);
        	i = i.next;
        }
        
        return map.get(head);
    }
	
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(5);
		RandomListNode node2 = new RandomListNode(5);
	}
}
