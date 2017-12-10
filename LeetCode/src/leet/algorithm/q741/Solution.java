package leet.algorithm.q741;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int cherryPickup(int[][] grid) {
        if(grid == null)
        	return 0;
        List<List<Integer>> state = new ArrayList<List<Integer>>();
        int[] cherry = new int[grid[0].length];
        state.add(new ArrayList<Integer>());
        cherry[0] = grid[0][0];
        for(int i=1; i<grid[0].length; i++) {
        	List<Integer> path = new ArrayList<Integer>();
        		if(grid[0][i]!=-1&&cherry[i-1]!=-1) {
        			cherry[i] = cherry[i-1]+grid[0][i];
        			path.addAll(state.get(i-1));
        			path.add(1);//1: go left 0:go down
        		}else {
        			cherry[i] = -1;
        		}
        	state.add(path);
        }
        
        for(int i=1; i<grid.length; i++) {
        	if(grid[i][0]!=-1&&cherry[0]!=-1) {
        		state.get(0).add(0);
        		cherry[0] = grid[i][0] + cherry[0];
        	}else {
        		cherry[0] = -1;
        	}
        	for(int j=1; j<grid[i].length; j++) {
        		if(grid[i][j]!=-1) {
        			if(cherry[j]>=cherry[j-1]&&cherry[j]!=-1) {
        				state.get(j).add(0);
        				cherry[j] = cherry[j] + grid[i][j];
        			}else if(cherry[j-1]>cherry[j]) {
        				state.remove(j);
        				List<Integer> path = new ArrayList<Integer>();
        				path.addAll(state.get(j-1));
        				path.add(1);
        				state.add(j, path);
        				cherry[j] = cherry[j-1] + grid[i][j];
        			}else {
        				cherry[j] = -1;
        			}
        		}else {
        			cherry[j] = -1;
        		}
        	}
        }
        
        int stage1 = cherry[grid[0].length-1];
        if(stage1==-1) {
        	return 0;
        }
        
        grid[0][0] = 0;
        for(int i=0, j=0; i+j<grid[0].length+grid.length-2;) {
        	if(state.get(state.size()-1).get(i+j)==0) {
        		i++;
        	}else {
        		j++;
        	}
        	grid[i][j] = 0;
        }
        
        
        
        cherry[0] = 0;
        for(int i=1; i<grid[0].length; i++) {
        		if(grid[0][i]!=-1&&cherry[i-1]!=-1) {
        			cherry[i] = cherry[i-1]+grid[0][i];
        		}else {
        			cherry[i] = -1;
        		}
        }
        
        for(int i=1; i<grid.length; i++) {
        	if(grid[i][0]!=-1&&cherry[0]!=-1) {
        		cherry[0] = grid[i][0] + cherry[0];
        	}else {
        		cherry[0] = -1;
        	}
        	for(int j=1; j<grid[i].length; j++) {
        		if(grid[i][j]!=-1) {
        			if(cherry[j]>=cherry[j-1]&&cherry[j]!=-1) {
        				cherry[j] = cherry[j] + grid[i][j];
        			}else if(cherry[j-1]>cherry[j]) {
        				cherry[j] = cherry[j-1] + grid[i][j];
        			}else {
        				cherry[j] = -1;
        			}
        		}else {
        			cherry[j] = -1;
        		}
        	}
        }
        return cherry[grid[0].length-1]+stage1;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] grid = new int[][] {{0,0,-1},{1,0,1},{1,-1,1}};
		System.out.println(sol.cherryPickup(grid));
	}
}
