package leet.algorithm.q89;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(n<1) {
        	result.add(0);
        	return result;
        }
        result.add(0);
        result.add(1);
        for(int i=1; i<n; i++) {
        	for(int j=result.size()-1; j>=0; j--) {
        		result.add((int) (result.get(j)+Math.pow(2, i)));
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.grayCode(3));
	}
}
