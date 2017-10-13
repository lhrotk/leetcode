package leet.algorithm.q60;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public String getPermutation(int n, int k) {
		List<Integer> numbers = new ArrayList<Integer>();
		StringBuffer buffer = new StringBuffer();
		int permutation = 1;
		for(int i=0; i<n; i++) {
			numbers.add(i+1);
			permutation *= i+1; 
		}
		k--;
		for(int i=0; i<n; i++) {
			permutation /= n-i;
			int order = k/permutation;
			k %= permutation;
			buffer.append(numbers.get(order)+"");
			numbers.remove(order);
		}
		return buffer.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.getPermutation(9, 1));
		System.out.println(sol.getPermutation(9, 2));
		System.out.println(sol.getPermutation(3, 3));
	}

}
