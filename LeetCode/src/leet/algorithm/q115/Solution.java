package leet.algorithm.q115;

public class Solution {
	public int numDistinct(String s, String t) {
		int m = s.length();
		int n = t.length();
		if(m==0||n==0) {
			return 0;
		}
		int[][] record = new int[n][m];
		if(s.charAt(0)==t.charAt(0)) {
			record[0][0] = 1;
		}
		for(int j=1; j<m; j++) {
			if(s.charAt(j)==t.charAt(0)) {
				record[0][j] = record[0][j-1]+1;
			}else {
				record[0][j] = record[0][j-1];
			}
		}
		for(int i=1; i<n; i++) {
			for(int j=i; j<m; j++) {
				if(s.charAt(j)==t.charAt(i)) {
					record[i][j] = record[i][j-1] + record[i-1][j-1];
				}else {
					record[i][j] = record[i][j-1];
				}
			}
		}
		return record[n-1][m-1];
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.numDistinct("rabbbit", "rabbit"));
	}
}
