package leet.algoeithm.q26;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Solution sol = new Solution();
		int[] nums = new int[]{1,1,2};
		System.out.println(sol.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
	
	public int removeDuplicates(int[] nums){
		if(nums==null){
			return 0;
		}else if(nums.length<=1){
			return nums.length;
		}
		
		int lastValue = nums[0];
		int size = 1;
		for(int i=1; i<nums.length; i++){
			if(nums[i]==lastValue){
				continue;
			}else{
				lastValue = nums[i];
				nums[size++] = lastValue;
			}
		}
		return size;
	}
}
