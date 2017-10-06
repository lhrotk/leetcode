package leet.algorithm.q41;

import java.util.HashSet;

public class Solution {
	public int firstMissingPositive(int[] nums) {
		int expectMax = 50;
		int rollBackIndex = -1;
		int currentMiss = 1;
		HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
        	if(nums[i]<currentMiss)
        		continue;
        	else if(nums[i]>expectMax&&rollBackIndex!=-1) {
        		rollBackIndex = i;
        	}else if(nums[i] == currentMiss) {
        		do {
        			currentMiss++;
        		}while(set.contains(currentMiss));
        		if(currentMiss>expectMax) {
        			if(rollBackIndex!=-1)//you need to roll back
        				i = rollBackIndex - 1;
        			rollBackIndex = -1;
        			expectMax += 50;
        		}
        	}else {// current[i]<= expectMax && current[i]>currentMiss
        		set.add(nums[i]);
        	}
        }
        return currentMiss;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = new int[] {11,6,5,3,4,3,2,-1,1,7,8,9,10};
		System.out.println(sol.firstMissingPositive(nums));
	}

}
