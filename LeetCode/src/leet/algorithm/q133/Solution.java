package leet.algorithm.q133;

import java.util.HashMap;

public class Solution {
	public void dfsExplore(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
		if(!map.containsKey(node.label)) {
			UndirectedGraphNode aNode = new UndirectedGraphNode(node.label);
			map.put(node.label, aNode);
		}
		
		for(int i=0; i<node.neighbors.size(); i++) {
			if(!map.containsKey(node.neighbors.get(i).label)) {
				this.dfsExplore(node.neighbors.get(i), map);
			}
			
			map.get(node.label).neighbors.add(map.get(node.neighbors.get(i).label));
		}
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null)
			return null;
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		this.dfsExplore(node, map);
		UndirectedGraphNode result =  map.get(node.label);
		return result;
	}
}
