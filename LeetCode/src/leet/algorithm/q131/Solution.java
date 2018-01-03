package leet.algorithm.q131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void partition(String s, List<String> currentResult, List<List<String>> result) {
		if(s.length()==0) {
			List<String> oneResult = new ArrayList<String>();
			oneResult.addAll(currentResult);
			result.add(oneResult);
		}
		
		for(int i=0; i<s.length(); i++) {
			boolean flag = true;
			for(int j=0; j<=i/2; j++) {
				if(s.charAt(j)!=s.charAt(i-j)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				currentResult.add(s.substring(0, i+1));
				partition(s.substring(i+1), currentResult, result);
				currentResult.remove(currentResult.size()-1);
			}
		}
	}
	
	public List<List<String>> partition(String s){
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> oneResult = new ArrayList<String>();
		this.partition(s, oneResult, result);
		return result;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.partition("aabb"));
	}
}
