package leet.algorithm.q105;

public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
		if(inEnd == inStart) {
			return null;
		}else {
			TreeNode root = new TreeNode(preorder[preStart]);
			int inIndex=0;
			for(int i=inStart; i<inEnd; i++) {
				if(inorder[i]==preorder[preStart]) {
					inIndex = i;
					break;
				}
			}
			root.left = buildTree(preorder, inorder, preStart+1, preStart+1+inIndex-inStart, inStart, inIndex);
			root.right = buildTree(preorder, inorder, preStart+inIndex-inStart+1, preEnd, inIndex+1, inEnd);
			return root;
		}
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || inorder.length == 0)
        	return null;
        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
	
	public static void main(String[] args) {
		int[] preorder = new int[] {1,2,4,5,3,6,7};
		int[] inorder = new int[] {4,2,5,1,6,3,7};
		Solution sol = new Solution();
		TreeNode result = sol.buildTree(preorder, inorder);
		System.out.println(result.val);
	}
}
