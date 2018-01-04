package leet.algorithm.q152;

public class Solution {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 1;
		int maxProduct = nums[0];
		int leftPositive = 1;
		int leftNegative = 1;
		int countNeg = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				leftPositive = 1;
				leftNegative = 1;
				countNeg = 0;
				maxProduct = Math.max(0, maxProduct);
			} else if (nums[i] > 0) {
				leftPositive *= nums[i];
				maxProduct = Math.max(leftPositive, maxProduct);
			} else {
				countNeg++;
				if (countNeg == 1) {
					leftNegative = leftPositive * nums[i];
					maxProduct = Math.max(nums[i], maxProduct);
					leftPositive = 1;
				} else {
					if (countNeg % 2 == 0) {
						leftPositive = leftPositive * leftNegative * nums[i];
					} else {
						leftPositive = leftPositive * nums[i] / leftNegative;
					}
					maxProduct = Math.max(leftPositive, maxProduct);
				}
			}
		}
		return maxProduct;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.maxProduct(new int[] { 2, -5, -2, -4, 3 }));
	}
}
