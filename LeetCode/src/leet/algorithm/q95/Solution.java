package leet.algorithm.q95;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<TreeNode> generateTrees(List<Integer> candidates){
		List<TreeNode> result = new ArrayList<TreeNode>();
		for(int i=0; i<candidates.size(); i++) {
			List<Integer> bigger = new ArrayList<Integer>();
			List<Integer> smaller = new ArrayList<Integer>();
			for(int j=0; j<i; j++) {
				smaller.add(candidates.get(j));
			}
			for(int j = i+1; j<candidates.size(); j++) {
				bigger.add(candidates.get(j));
			}
			List<TreeNode> leftTree = generateTrees(smaller);
			List<TreeNode> rightTree = generateTrees(bigger);
			if(leftTree.size()==0) {
				leftTree.add(null);
			}
			if(rightTree.size()==0) {
				rightTree.add(null);
			}
			for(int m = 0; m<leftTree.size(); m++) {
				for(int n =0; n<rightTree.size(); n++) {
					TreeNode root = new TreeNode(candidates.get(i));
					root.left = leftTree.get(m);
					root.right = rightTree.get(n);
					result.add(root);
				}
			}
		}
		return result;
	}
	
	public List<TreeNode> generateTrees(int n) {
        List<Integer> candidates = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
        	candidates.add(i);
        }
        return generateTrees(candidates);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		List<TreeNode> result = sol.generateTrees(3);
		System.out.println(result.size());
	}

}
