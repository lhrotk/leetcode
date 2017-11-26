package leet.algorithm.q85;

public class Solution {
	public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
        	return 0;
        }
        int maxArea = 0;
        for(int i=0; i<matrix.length; i++) {
        	for(int j=0; j<matrix[i].length; j++) {
        		for(int k = i; k<matrix.length&&matrix[k][j] == '1'; k++) {
        			int m = j;
        			while(true) {
        				if((m-j+1)*(k-i+1)>maxArea) {
        					maxArea = (m-j+1)*(k-i+1);
        				}
        				m++;
        				if(!(m<matrix[i].length))
        					break;
        				int n = i;
        				for(; n<=k; n++) {
        					if(matrix[n][m]!='1') {
        						break;
        					}
        				}
        				if(n!=k+1)
        					break;
        			}
        		}
        	}
        }
        return maxArea;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		char[][] matrix = {{'1','0', '1', '0', '0'},{'1','1', '1', '1', '1'},{'1','1', '1', '1', '1'},{'1','0', '0', '1', '0'}};
		System.out.println(sol.maximalRectangle(matrix));
	}
}
