package leet.algorithm.q55;
/**
 * 
 * @author lhrotk
 *
 */
public class Solution {
	public boolean canJump(int[] nums) {
        if(nums==null) {
        	return false;
        	}
        else if(nums.length<=1) {
        	return true;
        	}
        else {
        	int currentLast = 0;
        	for(int i = 0; i<=currentLast; i++) {
        		if(nums[i] + i> currentLast) {
        			currentLast = nums[i] + i;
        			if(currentLast >= nums.length - 1) {
        				return true;
        				}
        		}
        	}
        	return false;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = new int[] {3,2,2,0,4};
		System.out.println(sol.canJump(nums));
	}

}
