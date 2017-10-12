package leet.algorithm.q59;

import java.util.Arrays;

public class Solution {
	public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int total = n*n;
        int i=0, j=0, d=0, left=0, right = n-1, top =0, bottom = n-1; 
        for(int k=1; k<=total; k++) {
        	switch(d) {
        		case 0:{
        			result[i][j] = k;
        			if(j+1<=right)
        				j++;
        			else {
        				top++;
        				d = 1;
        				i++;
        			}
        			break;
        		}
        		case 1:{
        			result[i][j] = k;
        			if(i+1<=bottom)
        				i++;
        			else {
        				right--;
        				d = 2;
        				j--;
        			}
        			break;
        		}
        		case 2:{
        			result[i][j] = k;
        			if(j-1>=left)
        				j--;
        			else {
        				bottom--;
        				d = 3;
        				i--;
        			}
        			break;
        		}
        		case 3:{
        			result[i][j] = k;
        			if(i-1>=top)
        				i--;
        			else {
        				left++;
        				d = 0;
        				j++;
        			}
        			break;
        		}
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[][] result = sol.generateMatrix(5);
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println("");
		}
	}

}
