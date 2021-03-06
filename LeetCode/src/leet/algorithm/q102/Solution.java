package leet.algorithm.q102;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void traverseLevel(TreeNode root, int level, List<List<Integer>> result) {
		if(root == null)
			return;
		else {
			if(result.size()<level+1) {
				List<Integer> oneLevel = new ArrayList<Integer>();
				result.add(oneLevel);
			}
			result.get(level).add(root.val);
			traverseLevel(root.left, level+1, result);
			traverseLevel(root.right, level+1, result);
		}
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traverseLevel(root, 0, result);
        for(int i=0; i<result.size(); i++) {
        	if(i%2!=0) {
        		List<Integer> reverseResult = new ArrayList<Integer>();
        		List<Integer> origin = result.get(i);
        		for(int j=origin.size()-1; j>=0; j--) {
        			reverseResult.add(origin.get(j));
        		}
        		result.set(i, reverseResult);
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		System.out.println(sol.levelOrder(node1));
	}

}
