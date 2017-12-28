package leet.algorithm.q120;

import java.util.List;

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=1; i<triangle.size(); i++) {
        	List<Integer> previous = triangle.get(i-1);
        	List<Integer> current = triangle.get(i);
        	current.set(0, current.get(0)+previous.get(0));
        	current.set(current.size()-1, current.get(current.size()-1)+previous.get(previous.size()-1));
        	for(int j=1; j<current.size()-1; j++) {
        		current.set(j, current.get(j)+Math.min(previous.get(j), previous.get(j-1)));
        	}
        }
        List<Integer> lastLayer = triangle.get(triangle.size()-1);
        int result = lastLayer.get(0);
        for(int i=1; i<lastLayer.size(); i++) {
        	result = Math.min(lastLayer.get(i), result);
        }
        return result;
    }
}
