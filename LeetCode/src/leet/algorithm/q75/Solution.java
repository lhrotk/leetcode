package leet.algorithm.q75;

import java.util.Arrays;

public class Solution {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int[] color = new int[3];
		for (int i = 0; i < nums.length; i++) {
			color[nums[i]]++;
		}
		int index = 0;
		for (int j = 0; j < color.length; j++) {
			for (int i = 0; i < color[j]; i++) {
				nums[index++] = j;
			}
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = new int[] {0};
		sol.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
