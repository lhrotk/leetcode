package leet.algorithm.q146;

import java.util.HashMap;

public class LRUCache {
	class BDList{
		int key;
		int val;
		BDList pre;
		BDList next;
		BDList(int key, int x){
			this.key = key;
			val = x;
		}
	}
	
	private BDList head;
	private BDList tail;
	private int capacity;
	private HashMap<Integer, BDList> map;
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, BDList>(capacity);
        this.head = new BDList(-1, -1);
        this.tail = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        	BDList selected = map.get(key);
        	if(selected.next!=null) {//not the last element
        		selected.pre.next = selected.next;
        		selected.next.pre = selected.pre;
        		this.tail.next = selected;
        		selected.pre = tail;
        		selected.next = null;
        		this.tail = selected;
        	}
        	return map.get(key).val;
        }else {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
    	if(this.map.containsKey(key)) {
    		map.get(key).val = value;
    		this.get(key);
    		return;
    	}
    	
        if(this.map.size()==this.capacity) {
        	map.remove(head.next.key);
        	if(this.capacity==1) {
        		tail = head;
        		head.next = null;
        	}else {
        		head.next = head.next.next;
        		head.next.pre = head;
        	}
        }
        
        BDList newOne = new BDList(key, value);
        this.tail.next = newOne;
        newOne.pre = this.tail;
        this.tail = newOne;
        map.put(key, newOne);
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache( 2 /* capacity */ );

    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	System.out.println(cache.get(2));       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	System.out.println(cache.get(1));       // returns -1 (not found)
    	System.out.println(cache.get(3));      // returns 3
    	System.out.println(cache.get(4));       // returns 4
    }
    
}
