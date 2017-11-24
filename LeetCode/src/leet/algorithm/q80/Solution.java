package leet.algorithm.q80;

import java.util.Arrays;

public class Solution {
	public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
        	return 0;
        else if(nums.length==1)
        	return 1;
        
        int state = 1, lastNum = nums[0], index = 1;
        for(int i=1; i<nums.length; i++) {
        	if(nums[i]!=lastNum) {
        		nums[index++] = nums[i];
        		lastNum = nums[i];
        		state = 1;
        	}else {
        		if(state==1) {
        			nums[index++] = nums[i];
        			state++;
        		}
        	}
        }
        return index;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = new int[] {1,2,3,3,3,4};
		int result = sol.removeDuplicates(nums);
		System.out.println(result+":"+Arrays.toString(nums));
	}
}
