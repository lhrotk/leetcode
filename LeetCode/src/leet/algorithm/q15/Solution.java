package leet.algorithm.q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums.length<3)
        	return result;
        for(int i=0; i<nums.length-2;i++){
        	if(i-1>=0&&nums[i]==nums[i-1]){
        		continue;
        	}
        	int target = 0-nums[i];
        	for(int x = i+1, y = nums.length-1; x!=y;){
        		if((x-1>i && nums[x]==nums[x-1])||nums[x]+nums[y]<target){
        			x++;
        		}else if((y+1<nums.length && nums[y+1] == nums[y])||nums[x] + nums[y] > target){
        			y--;
        		}else{
        			result.add(Arrays.asList(nums[i], nums[x], nums[y]));
        			x++;
        		}
        		
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = {-1, 0, 1, 2, -1, -1, -4};
		List<List<Integer>> result = sol.threeSum(nums);
		System.out.println(result);
	}

}
