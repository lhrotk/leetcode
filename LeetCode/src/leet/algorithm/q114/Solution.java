package leet.algorithm.q114;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void preOrder(TreeNode root, List<TreeNode> result){
		if(root!=null) {
			result.add(root);
			preOrder(root.left, result);
			preOrder(root.right, result);
		}else {
			return;
		}
	}
	
    public void flatten(TreeNode root) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        this.preOrder(root, result);
        for(int i=0; i<result.size(); i++) {
        	result.get(i).left = null;
        	if(i<result.size()-1) {
        		result.get(i).right = result.get(i+1);
        	}else {
        		result.get(i).right = null;
        	}
        }
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	node1.left = node2;
    	node1.right = node3;
    	sol.flatten(node1);
    	while(node1!=null) {
    		System.out.println(node1.val);
    		node1 = node1.right;
    	}
    }
}
