package leet.algorithm.q33;

public class Solution {
	public int search(int[] nums, int target) {
        int i=0, j=nums.length-1;
        while(i<=j) {
        	if(nums[i]<=nums[j]) {
        		if(nums[(i+j)/2]==target)
        			return (i+j)/2;
        		else if(nums[(i+j)/2]>target) {
        			j = (i+j)/2-1;
        		}else {
        			i = (i+j)/2+1;
        		}
        	}else if(nums[i]>nums[j]) {
        		if(target<nums[i]&&target>nums[j])
        			return -1;
        		if(target>=nums[i]&&nums[(i+j)/2]>=nums[i]) {
        			if(target==nums[(i+j)/2])
        				return (i+j)/2;
        			else if(target>nums[(i+j)/2]) {
        				i = (i+j)/2 +1;
        			}else {
        				j = (i+j)/2 -1;
        			}
        		}else if(target>=nums[i]&&nums[(i+j)/2]<=nums[i]) {
        			j = (i+j)/2-1;
        		}else if(target<=nums[j]&&nums[(i+j)/2]<=nums[j]) {
        			if(target==nums[(i+j)/2])
        				return (i+j)/2;
        			else if(target>nums[(i+j)/2]) {
        				i = (i+j)/2 +1;
        			}else {
        				j = (i+j)/2 -1;
        			}
        		}else if(target<=nums[j]&&nums[(i+j)/2]>=nums[j]) {
        			i = (i+j)/2 + 1;
        		}
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = new int[] {4,6,7,0,1,2,3};
		System.out.println(sol.search(nums, -1));
	}
}
