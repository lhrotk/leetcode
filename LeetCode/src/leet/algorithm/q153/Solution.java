package leet.algorithm.q153;

public class Solution {
	public int findMin(int[] nums) {
        if(nums == null|| nums.length==0) {
        	return 0;
        }
		int i=0; 
        int j=nums.length-1;
        while(i<j) {
        	if(nums[i]<nums[j])
        		return nums[i];
        	else {
        		if(nums[(i+j)/2]>=nums[i]) {
        			i = (i+j)/2+1;
        		}else {
        			j = (i+j)/2;
        		}
        	}
        }
        
        return nums[i];
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.findMin(new int[] {5,6,7,0,1,2,4}));

	}

}
