package leet.algorithm.q45;
//greedy algorithm; think about what exploration is meaningless!!!
/**
 * 
 * @author lhrotk
 *
 */
public class Solution {
	public int jump(int[] nums) {
		int currMin = 0, currMax = 0, currDepth = 0;
		while (currMax < nums.length - 1) {
			currDepth++;
			int nextMax = currMax;
			for (int i = currMin; i <= currMax; i++) {
				nextMax = Math.max(nextMax, nums[i] + i);
				if (nextMax >= nums.length - 1) {
					return currDepth;
				}
			}
			currMin = currMax + 1;
			currMax = nextMax;
		}
		return currDepth;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, 2, 3 };
		Solution sol = new Solution();
		System.out.println(sol.jump(nums));
	}

}
