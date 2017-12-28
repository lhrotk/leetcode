package leet.algorithm.q740;

public class Solution {
	public int deleteAndEarn(int[] nums) {
        int[] acc = new int[100001];
        int max = 1;
        for(int i=0; i<nums.length; i++) {
        	acc[nums[i]] += nums[i];
        	max = Math.max(max, nums[i]);
        }
        acc[2]=Math.max(acc[1],acc[2]);
        for(int i=3; i<=max; i++) {
        	acc[i] = Math.max(acc[i-1], acc[i-2]+acc[i]);
        }
        return acc[max];
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = new int[] {2,3,4};
		System.out.println(sol.deleteAndEarn(nums));

	}

}
