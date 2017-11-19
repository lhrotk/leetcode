package leet.algorithm.q73;

import java.util.Arrays;

public class Solution {
	public void setZeroes(int[][] matrix) {
        if(matrix == null) {
        	return; 
        }
        int[] record = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
        	boolean zero = false;
        	for(int j=0; j<matrix[i].length; j++) {
        		if(matrix[i][j]==0) {
        			record[j] = -1;
        			zero = true;
        		}
        	}
        	if(zero) {
        		for(int j=0; j<matrix[i].length; j++) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        for(int i=0; i<matrix.length; i++) {
        	for(int j=0; j<matrix[i].length; j++) {
        		matrix[i][j] = matrix[i][j]*(record[j]+1);
        	}
        }
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] data = new int[4][];
		data[0] = new int[] {1,2,3,0};
		data[1] = new int[] {1,2,3,4};
		data[2] = new int[] {1,0,3,4};
		data[3] = new int[] {0,2,3,4};
		sol.setZeroes(data);
		for(int i=0; i<data.length; i++) {
			System.out.println(Arrays.toString(data[i]));
		}
	}
}
