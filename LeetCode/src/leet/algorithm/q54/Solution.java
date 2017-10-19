package leet.algorithm.q54;
/**
 * @author lhrotk
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length==0 || matrix[0].length == 0) {
        	return result;
        	}
        int left =0;
        int top = 0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        int i=0, j=0, direct = 0, count=0, total = matrix.length*matrix[0].length;
        while(count<total) {
        	switch(direct) {
        	case 0:{
        		if(j<right) {
        			result.add(matrix[i][j]);
        			j++;
        		}else {
        			result.add(matrix[i][j]);
        			i++;
        			direct = 1;
        			top++;
        		}
        		break;
        	}
        	case 1:{
        		if(i<bottom) {
        			result.add(matrix[i][j]);
        			i++;
        		}else {
        			result.add(matrix[i][j]);
        			j--;
        			direct = 2;
        			right--;
        		}
        		break;
        	}
        	case 2:{
        		if(j>left) {
        			result.add(matrix[i][j]);
        			j--;
        		}else {
        			result.add(matrix[i][j]);
        			i--;
        			direct =3;
        			bottom--;
        		}
        		break;
        	}
        	case 3:{
        		if(i>top) {
        			result.add(matrix[i][j]);
        			i--;
        		}else {
        			result.add(matrix[i][j]);
        			j++;
        			direct = 0;
        			left++;
        		}
        		break;
        	}
        	default: break;
        	}
        	count++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2},{4,5},{7,8}};
		Solution sol = new Solution();
		System.out.println(sol.spiralOrder(matrix));
	}
}
