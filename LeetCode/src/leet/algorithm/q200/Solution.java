package leet.algorithm.q200;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int numIslands(char[][] grid) {
		if(grid == null||grid.length==0||grid[0].length==0) {
			return 0;		}
		List<Integer> labelList = new ArrayList<Integer>();
		labelList.add(0);
		int[][] label = new int[grid.length][grid[0].length];
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j]=='1') {
					if((i!=0&&grid[i-1][j]=='1')&&(j!=0&&grid[i][j-1]=='1')) {
						
						int root1 = label[i-1][j];
						int root2 = label[i][j-1];
						while(labelList.get(root1)!=root1) {
							root1 = labelList.get(root1);
						}
						while(labelList.get(root2)!=root2) {
							root2 = labelList.get(root2);
						}
						label[i][j] = Math.min(root1, root2);
						labelList.set(Math.max(root1, root2), Math.min(root1, root2));
						
					}else if(i!=0&&grid[i-1][j]=='1') {
						label[i][j] = label[i-1][j];
					}else if(j!=0&&grid[i][j-1]=='1') {
						label[i][j] = label[i][j-1];
					}else {
						label[i][j] = (labelList.size());
						labelList.add(labelList.size());
						
					}
				}
			}
		}
		
		int count = 0;
		for(int i=1; i<labelList.size(); i++) {
			if(labelList.get(i)==i)
				count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
		Solution sol = new Solution();
		System.out.println(sol.numIslands(grid));
	}
}
