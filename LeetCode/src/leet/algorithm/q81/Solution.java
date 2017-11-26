package leet.algorithm.q81;

public class Solution {
	public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0)
        	return false;
        int i=0, j=nums.length-1;
        while(i<=j) {
        	if(nums[i]<nums[j]) {
        		if(nums[(i+j)/2]==target)
        			return true;
        		else if(nums[(i+j)/2]>target) {
        			j = (i+j)/2-1;
        		}else {
        			i =  (i+j)/2+1;
        		}
        	}else if(nums[i]==nums[j]&&i!=j) {
        		j--;     		
        	}
        	else{
        		if(target>=nums[i]) {
        			if(nums[(i+j)/2]==target) {
        				return true;
        			}else if(nums[(i+j)/2]<nums[i])
        				j = (i+j)/2-1;
        			else if(target>nums[(i+j)/2]){
        				i = (i+j)/2+1;
        			}else {
        				j = (i+j)/2-1;
        			}
        		}else if(target<=nums[j]) {
        			if(nums[(i+j)/2]==target) {
        				return true;
        			}else if(nums[(i+j)/2]>nums[j])
        				i = (i+j)/2+1;
        			else if(target>nums[(i+j)/2]){
        				i = (i+j)/2+1;
        			}else {
        				j = (i+j)/2-1;
        			}
        		}else {
        			return false;
        		}
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = new int[] {6,6,1,2,3,4,5};
		System.out.println(sol.search(nums, 1));
	}
}
