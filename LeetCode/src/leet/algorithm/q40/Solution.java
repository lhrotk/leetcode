package leet.algorithm.q40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public void findMore(int[] candidates, int currentSum, int currentPos, int target, List<Integer> oneResult, List<List<Integer>> result) {
		int lastUsed = 0;
		for(int i=currentPos; i<candidates.length; i++) {
			if(candidates[i]!=lastUsed) {
				lastUsed = candidates[i];
				if(currentSum+lastUsed>target)
					return;
				else if(currentSum + lastUsed == target) {
					oneResult.add(lastUsed);
					List<Integer> aResult = new ArrayList<Integer>();
					aResult.addAll(oneResult);
					result.add(aResult);
					oneResult.remove(oneResult.size()-1);
				}else {
					oneResult.add(lastUsed);
					findMore(candidates, currentSum+lastUsed, i+1, target, oneResult, result);
					oneResult.remove(oneResult.size()-1);
				}
			}
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        if(candidates == null)
	        	return null;
	        Arrays.sort(candidates);
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        List<Integer> oneResult = new ArrayList<Integer>();
	        findMore(candidates, 0, 0, target, oneResult, result);
	        return result;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] candidates = new int[] {10, 1, 2, 7, 6, 1, 5};
		System.out.println(sol.combinationSum2(candidates, 8));
	}

}
