package leet.algorithm.q315;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	class TreeNode{
		int arrayCounter;
		int num;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int counter, int number) {
			arrayCounter = counter;
			num = number;
		}
	}
	
	private void adjustSubTree(TreeNode pointer, List<Integer> result) {
		if(pointer==null)
			return;
		adjustSubTree(pointer.left, result);
		adjustSubTree(pointer.right, result);
		result.set(pointer.arrayCounter, result.get(pointer.arrayCounter)+1);
	}
	
	public List<Integer> countSmaller(int[] nums){
		TreeNode head = new TreeNode(0, nums[0]);
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		for(int i=1; i<nums.length; i++) {
			result.add(0);
			TreeNode pointer = head;
			while(true) {
				if(nums[i] < pointer.num) {
					result.set(pointer.arrayCounter, result.get(pointer.arrayCounter)+1);
					adjustSubTree(pointer.right, result);
					if(pointer.left==null) {
						pointer.left = new TreeNode(i, nums[i]);
						break;
					}
					pointer = pointer.left;
				}else {
					if(pointer.right==null) {
						pointer.right = new TreeNode(i, nums[i]);
						break;
					}
					pointer = pointer.right;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.countSmaller(new int[] {5,2,6,1}));
	}
}
