package leet.algorithm.q113;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void pathSum(TreeNode root, int sum, List<Integer> acc, List<List<Integer>> result) {
		if(root == null) {
			return;
		}else {
			if(root.val == sum&&root.left==null&&root.right==null) {
				acc.add(root.val);
				List<Integer> oneResult = new ArrayList<Integer>();
				oneResult.addAll(acc);
				result.add(oneResult);
				acc.remove(acc.size()-1);
				return;
			}else{
				acc.add(root.val);
				pathSum(root.left, sum-root.val, acc, result);
				pathSum(root.right, sum-root.val, acc, result);
				acc.remove(acc.size()-1);
			}
		}
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> acc = new ArrayList<Integer>();
        pathSum(root, sum, acc, result);
        return result;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode node1 = new TreeNode(-2);
		TreeNode node2 = new TreeNode(-3);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(-3);
		node2.right = node4;
		node1.left = node2;
		node1.right = node3;
		System.out.println(sol.pathSum(node1, -8));
	}
}
