package leet.algorithm.q96;

public class Solution {
	public int numTrees(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        for(int i=1; i<result.length; i++) {
        	int acc = 0;
        	for(int j=0; j<i; j++) {
        		acc += result[j]*result[i-1-j];
        	}
        	result[i] = acc;
        }
        return result[n];
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.numTrees(5));
	}
}
