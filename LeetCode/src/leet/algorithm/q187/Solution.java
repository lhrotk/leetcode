package leet.algorithm.q187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {

		HashSet<Integer> one = new HashSet<Integer>();
		HashSet<Integer> two = new HashSet<Integer>();
		List<String> result = new ArrayList<String>();
		if(s.length()<10)
			return result;
		
		int[] index = new int[26];
		index['A'-'A'] = 0; 
		index['C'-'A'] = 1; 
		index['T'-'A'] = 2; 
		index['G'-'A'] = 3; 

		int basic = 0;
		for(int i=0; i<10; i++) {
			basic = basic << 2;
			basic += index[s.charAt(i)-'A'];
			basic = basic & 0xfffff;
		}
		one.add(basic);
		
		for(int i=1; i+9<s.length(); i++) {
			basic = basic << 2;
			basic += index[s.charAt(i+9)-'A'];
			basic = basic & 0xfffff;
			if(one.contains(basic)) {
				if(!two.contains(basic)){
					two.add(basic);
					result.add(s.substring(i, i+10));
				}
			}else {
				one.add(basic);
			}
		}
		return result;
    }
	
	

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
}
