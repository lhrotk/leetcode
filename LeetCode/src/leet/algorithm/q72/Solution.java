package leet.algorithm.q72;

class Solution {	
    public int minDistance(String word1, String word2) {
    	char[] str1 = word1.toCharArray();
    	char[] str2 = word2.toCharArray();
    	int m = str1.length;
    	int n = str2.length;
    	int[][] cost = new int[m+1][n+1];//0-m, 0-n
    	for(int i=0; i<=m; i++) {
    		cost[i][0] = i;
    	}
    	
    	for(int i=0; i<=n; i++) {
    		cost[0][i] = i;
    	}
    	
    	for(int i=1; i<=m; i++) {
    		for(int j=1; j<=n; j++) {
    			if(str1[i-1]==str2[j-1]) {
    				cost[i][j] = cost[i-1][j-1];
    			}else {
    				cost[i][j] = 1 + Math.min(cost[i][j-1], Math.min(cost[i-1][j], cost[i-1][j-1]));
    			}
    		}
    	}
    	
    	return cost[m][n];
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.minDistance("horse", "ros"));
    	System.out.println(sol.minDistance("intention", "execution"));
    }
}
