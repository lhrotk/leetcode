package leet.algorithm.q48;
/**
 * @author lhrotk
 */
import java.util.Arrays;

public class Solution {
	public void rotate(int[][] matrix) {
		//Flip vertically
		for (int i = 0; i < matrix.length; i++) {
			int length = matrix[i].length;
			for (int j = 0; j < (length - 1) / 2.0; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][length - j - 1];
				matrix[i][length - j - 1] = temp;
			}
		}
		//Flip along diagonal
		for (int i = 0; i < matrix.length; i++) {
			int base = matrix.length - i -1;
			for(int j=1; i+j<matrix.length; j++) {
				int temp = matrix[i][base-j];
				matrix[i][base-j] = matrix[i+j][base];
				matrix[i+j][base] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3,4 }, { 5, 6, 7, 8 }, { 9,10,11,12 },{13,14,15,16} };
		Solution sol = new Solution();
		sol.rotate(matrix);
		for(int i=0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

}
