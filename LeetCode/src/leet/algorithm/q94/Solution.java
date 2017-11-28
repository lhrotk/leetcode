package leet.algorithm.q94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while((!stack.isEmpty())||root!=null) {
        	if(root!=null) {
        		stack.push(root);
        		root = root.left;
        	}else {
        		root = stack.pop();
        		result.add(root.val);
        		root = root.right;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.right = node2;
		node2.left = node3;
		System.out.println(sol.inorderTraversal(node1));
	}
}
