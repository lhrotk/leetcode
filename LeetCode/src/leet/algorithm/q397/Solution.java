package leet.algorithm.q397;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int integerReplacement(int n) {
		if (n == Integer.MAX_VALUE) return 32;
		if (n == 1)
			return 0;
		List<Integer> candidates = new ArrayList<Integer>();
		candidates.add(n);
		for (int i = 1;; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < candidates.size(); j++) {
				if (candidates.get(j) % 2 == 0) {
					int tempResult = candidates.get(j) / 2;
					if (tempResult == 1)
						return i;
					temp.add(tempResult);
				} else {
					int tempResult1 = candidates.get(j) + 1;
					int tempResult2 = candidates.get(j) - 1;
					if (tempResult1 == 1 || tempResult2 == 1) {
						return i;
					}
					temp.add(tempResult1);
					temp.add(tempResult2);
				}
			}
			candidates.removeAll(candidates);
			candidates.addAll(temp);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.integerReplacement(2147483647));
	}
}
