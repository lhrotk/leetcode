package leet.algorithm.q98;

public class Solution {
	long compare = (long)Integer.MIN_VALUE-1;
	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		if(this.isValidBST(root.left)&&root.val>this.compare) {
			this.compare = root.val;
			return this.isValidBST(root.right);
		}else {
			return false;
		}
    }
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		/*TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(25);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;*/
		Solution sol = new Solution();
		System.out.println(sol.isValidBST(node1));
	}
}	
