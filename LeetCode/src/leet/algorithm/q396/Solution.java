package leet.algorithm.q396;

public class Solution {
	public int maxRotateFunction(int[] A) {
		int baseLine = 0;
		int total=0;
        for(int i=0; i<A.length; i++) {
        	baseLine += A[i]*i;
        	total += A[i];
        }
        int max = baseLine;
        for(int i=1; i<A.length; i++) {
        	baseLine += total-A.length*A[A.length-i];
        	if(max<baseLine)
        		max = baseLine;
        }
        return max;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.maxRotateFunction(new int[] {0,1,2,3,4}));
	}
}	
