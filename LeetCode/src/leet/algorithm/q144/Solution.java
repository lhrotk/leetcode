package leet.algorithm.q144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> result = new Stack<Integer>();
		List<Integer> post = new ArrayList<Integer>();
        while(root!=null||!stack.isEmpty()) {
        	if(root == null) {
        		root = stack.pop();
        	}else {
            	result.push(root.val);
            	if(root.left!=null)
            		stack.push(root.left);
            	root = root.right;
        	}
        	
        }
        
        while(!result.isEmpty()) {
        	post.add(result.pop());
        }
        return post;
    }
}
