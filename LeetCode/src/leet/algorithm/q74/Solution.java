package leet.algorithm.q74;

import java.util.Arrays;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null) {
        	return false;
        }else if(target<matrix[0][0]) {
        	return false;
        }
        int i=0;
        int j=matrix.length-1;
        if(target>=matrix[j][0]) {
        	i=j;
        }else {
        	while(i<j-1) {
            	if(target>=matrix[(i+j)/2][0]) {
            		i = (i+j)/2;
            	}else {
            		j = (i+j)/2;
            	}
            }	
        }
        
        int index = i;
        i =0;
        j = matrix[index].length-1;
        while(i<=j) {
        	if(matrix[index][(i+j)/2]==target) {
        		return true;
        	}else if(matrix[index][(i+j)/2]>target) {
        		j = (i+j)/2-1;
        	}else{
        		i = (i+j)/2+1;
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] data = new int[2][];
		data[0] = new int[] {1};
		data[1] = new int[] {3};
		System.out.println(sol.searchMatrix(data, 3));
		System.out.println(sol.searchMatrix(data, 42));
		System.out.println(sol.searchMatrix(data, 3));
		System.out.println(sol.searchMatrix(data, 10));
	}
}
