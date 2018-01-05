package leet.algorithm.q162;

public class Solution {
	public int findPeakElement(int[] nums) {
		if(nums == null)
			return 0;
		int i = 0;
		int j = nums.length-1;
		if(j==0)
			return 0;
		else{
			while(j-i>1) {
				if(nums[(i+j)/2]>nums[(i+j)/2+1]) {
					j = (i+j)/2;
				}else {
					i = (i+j)/2+1;
				}
			}
			
			if(nums[i]>nums[j]){
				return i;
			}else {
				return j;
			}
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.findPeakElement(new int[] {2,1}));
	}
}
