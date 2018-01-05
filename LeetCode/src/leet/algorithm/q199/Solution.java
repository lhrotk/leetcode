package leet.algorithm.q199;

import java.util.ArrayList;
import java.util.List;

import leet.algorithm.q102.TreeNode;

public class Solution {
	 public void traverse (TreeNode node, List<Integer> result, int depth){
	        if(node!=null){
	            if(depth>result.size()){
	                result.add(node.val);
	            }
	            
	            traverse(node.right, result, depth+1);
	            traverse(node.left, result, depth+1);
	        }
	    }
	    
	    public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> result = new ArrayList<Integer>();
	        traverse(root, result, 1);
	        return result;
	    }
}
