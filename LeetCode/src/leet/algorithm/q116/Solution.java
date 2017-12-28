package leet.algorithm.q116;

public class Solution {
	public void connect(TreeLinkNode root) {
		if(root == null)
			return;
		else if(root.left == null){
			return;
		}
		else{
			TreeLinkNode i = root;
			while(i!=null) {
				i.left.next = i.right;
				if(i.next!=null) {
					i.right.next = i.next.left;
				}
				i = i.next;
			}
			connect(root.left);
		}
	}
}
