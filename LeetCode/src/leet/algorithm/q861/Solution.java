/**
 * 
 */
package leet.algorithm.q861;

/**
 * @author Aupera
 *
 */
public class Solution {
	public int matrixScore(int[][] A) {
		int[] countOne = new int[A[0].length-1];
        for(int i=0; i<A.length; i++) {
        	if(A[i][0]==0) {
        		for(int j=1; j<A[0].length; j++) {
        			countOne[j-1] += 1-A[i][j];
        		}
        	}else {
        		for(int j=1; j<A[0].length; j++) {
        			countOne[j-1] += A[i][j];
        		}
        	}
        }
        int result = A.length*(1<<(A[0].length-1));
        for(int i=0; i<A[0].length-1; i++) {
        	if(countOne[i]>=Math.ceil(A.length/2.0)) {
        		result += countOne[i]*(1<<(A[0].length-2-i));
        	}else {
        		result += (A.length-countOne[i])*(1<<(A[0].length-2-i));
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.matrixScore(new int[][] {{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
	}
}
