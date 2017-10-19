package leet.algorithm.q53;
/**
 * 
 * @author lhrotk
 *
 */
public class Solution {
	public int maxSubArray(int[] nums) {
		if(nums.length==0) {
			return 0;
			}
		int maxSub = nums[0], currentSum=nums[0];
		if(nums[0]<0) {
			currentSum = 0;
			}
		for(int i=1; i<nums.length; i++) {
			if(nums[i] <0 && nums[i] > maxSub) {
				maxSub = nums[i];
				}
			if(nums[i]+currentSum>=0) {
				currentSum += nums[i];
				if(currentSum > maxSub) {
					maxSub = currentSum;
					}
			}else {
				currentSum = 0;
				}
		}
		return maxSub;
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = new int[] {1,2};
		System.out.println(sol.maxSubArray(nums));
	}
}
