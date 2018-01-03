package leet.algorithm.q139;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] record = new boolean[s.length()+1];
		
		record[0] = true;
		
		for(int i=1; i<=s.length(); i++) {
			for(int j=0; j<i; j++) {
				if(record[j]&&wordDict.contains(s.substring(j, i))) {
					record[i] = true;
					break;
				}
			}
		}
		
		return record[s.length()];
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("lee");
		wordDict.add("tcode");
		System.out.println(sol.wordBreak("leetcode", wordDict));
	}
}
