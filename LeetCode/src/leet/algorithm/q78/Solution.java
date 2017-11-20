package leet.algorithm.q78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums==null||nums.length==0) {
			List<Integer> oneResult = new ArrayList<Integer>();
			result.add(oneResult);
			return result;
		}
        int size = nums.length;
        for(int i=0; i<Math.pow(2, size); i++) {
        	List<Integer> oneResult = new ArrayList<Integer>();
        	for(int j=0; j<size; j++) {
        		if((i&(int)Math.pow(2, j))!=0) {
        			oneResult.add(nums[j]);
        		}
        	}
        	result.add(oneResult);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = new int[] {};
		System.out.println(sol.subsets(nums));
	}

}
