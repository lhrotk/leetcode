package leet.algorithm.q813;

public class Solution {
	    public int findLength(int[] A, int[] B) {
	    	if(A== null||B==null)
	    		return 0;
	        int[] dp = new int[A.length];
	        int max = 0;
	        for(int i=0; i<A.length; i++) {
	        	dp[i] = (A[i]==B[0])?1:0;
	        	max = Math.max(dp[i], max);
	        }
	        for(int j=1; j<B.length; j++) {
	        	for(int i=A.length-1; i>=1; i--) {
	        		if(A[i]==B[j]) {
	        			dp[i] = 1+dp[i-1];
	        			max = Math.max(dp[i], max);
	        		}else {
	        			dp[i] = 0;
	        		}
	        	}
	        	dp[0] = (A[0]==B[j])?1:0;
	        	max = Math.max(dp[0], max);
	        }
	        return max;
	    }
	    
	    public static void main(String[] args) {
	    	Solution sol = new Solution();
	    	System.out.println(sol.findLength(new int[] {0,1,3,2,1}, new int[] {3,2,1,0,1}));
	    }
}
