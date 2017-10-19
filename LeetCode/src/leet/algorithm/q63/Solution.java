package leet.algorithm.q63;
/**
 * 
 * @author lhrotk
 *
 */
public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if(row == 0) {
        	return 0;
        	}
        int column = obstacleGrid[0].length;
        if(column == 0) {
        	return 0;
        	}
        if(obstacleGrid[0][0]==1) {
        	return 0;
        	}
        int[][] resultMatrix = new int[row][column];
        resultMatrix[0][0]=1;
        for(int i = 0; i<row; i++) {
        	for(int j=0; j<column; j++) {
        		if(obstacleGrid[i][j]==0) {
        			if(i>=1) {
        				resultMatrix[i][j] += resultMatrix[i-1][j];
        			}
        			if(j>=1) {
        				resultMatrix[i][j] += resultMatrix[i][j-1];
        			}
        		}
        	}
        }
        return resultMatrix[row-1][column-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[][] grid = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(sol.uniquePathsWithObstacles(grid));
	}

}
