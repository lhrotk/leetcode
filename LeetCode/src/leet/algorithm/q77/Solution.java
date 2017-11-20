package leet.algorithm.q77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void nextCombine(List<List<Integer>> result, List<Integer> acc, int n, int remain, int current) {
		if(remain==0) {
			List<Integer> oneResult = new ArrayList<Integer>();
			oneResult.addAll(acc);
			result.add(oneResult);
		}else {
			for(int i=current+1; i<=n; i++) {
				acc.add(i);
				this.nextCombine(result, acc, n, remain-1, i);
				acc.remove(acc.size()-1);
			}
		}
	}
	
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> acc = new ArrayList<Integer>();
        if(k==0||n==0||k>n) {
        	return result;
        }
        this.nextCombine(result, acc, n, k, 0);
        return result;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.combine(7, 2));
	}
}
