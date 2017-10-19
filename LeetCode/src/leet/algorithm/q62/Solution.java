package leet.algorithm.q62;
/**
 * 
 * @author lhrotk
 *
 */
public class Solution {
	public int uniquePaths(int m, int n) {
		if(m<=1 || n<=1) {
			return 1;
			}
		if(m>n) {
			int temp = m;
			m = n; 
			n = temp;
		}
        long divident = 1;
        for(int i=0; i<=m-2; i++) {
        	divident *= m+n-2-i;
        	divident /= i+1;
        }
        return (int)(divident);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.uniquePaths(36, 7));
	}

}
