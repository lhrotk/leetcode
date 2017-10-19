package leet.algorithm.q51;
/**
 * @author lhrotk
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public void findSolution(List<List<String>> result, List<Integer> accumulator, int n, int row) {
		if(row == n) {
			ArrayList<String> oneResult = new ArrayList<String>();
			char[] b = new char[n];
			Arrays.fill(b, '.');
			String allDot = String.valueOf(b);
			StringBuffer buffer = new StringBuffer(allDot);
			for(int i=0; i<n; i++) {
				buffer.setCharAt(accumulator.get(i), 'Q');
				oneResult.add(buffer.toString());
				buffer.setCharAt(accumulator.get(i), '.');
			}
			result.add(oneResult);
		}else {
			for(int i=0; i<n; i++) {
				int j;
				for(j=0 ; j<row; j++) {
					if(accumulator.get(j)==i||Math.abs(accumulator.get(j)-i)==row-j) {
						break;
						}
				}
				if(j==row) {
					accumulator.add(i);
					findSolution(result, accumulator, n, row+1);
					accumulator.remove(accumulator.size()-1);
				}
			}
		}
	}
	public List<List<String>> solveNQueens(int n) {
        List<Integer> accumulator = new ArrayList<Integer>();
        List<List<String>> result = new ArrayList<List<String>>();
        findSolution(result, accumulator, n, 0);
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.solveNQueens(4));
	}

}
