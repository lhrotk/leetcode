package leet.algorithm.q16;

import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int minValue = 0;
        for(int i=0; i<nums.length-2; i++) {
        	if(i!=0&&nums[i]==nums[i-1]) {
        		continue;
        	}
            int m=i+1;
            int n=nums.length-1;
            while(m<n) {
            	int sum = nums[i]+nums[m]+nums[n];
            	if(target==sum)
            		return target;
            	else if(Math.abs(target-sum)<minGap) {
            		minGap = Math.abs(target-sum);
            		minValue = sum;
            	}
            	if(nums[i]+nums[m]+nums[n]>target) {
            		n--;
            	}else {
            		m++;
            	}
            }
        }
        return minValue;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.threeSumClosest(new int[] {-1, 2,1,-4}, 1));
	}
}
