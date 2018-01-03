package leet.algorithm.q129;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void sumNumbers(TreeNode root, int current, List<Integer> result) {
		if(root.left != null) {
			this.sumNumbers(root.left, current*10 + root.val, result);
		}
		
		if(root.right!=null){
			this.sumNumbers(root.right, current*10 + root.val, result);
		}
		
		if(root.left==null&&root.right==null){
			result.set(0, current*10 + root.val + result.get(0));
		}
	}
	public int sumNumbers(TreeNode root) {
        if(root == null)
        	return 0;
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        this.sumNumbers(root, 0, result);
        return result.get(0);
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		System.out.println(sol.sumNumbers(node1));
	}
}
