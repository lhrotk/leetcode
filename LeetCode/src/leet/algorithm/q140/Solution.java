package leet.algorithm.q140;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void wordBreak(String s, String current, List<String> wordDict, List<String> result) {
		if(s.length()==0) {
			current = current.substring(0, current.length()-1);
			result.add(current);
		}else {
			for(int i=1; i<=s.length(); i++) {
				if(wordDict.contains(s.substring(0, i))) {
					wordBreak(s.substring(i), current + s.substring(0, i) + " ", wordDict, result);
				}
			}
		}
	}
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<String>();
        if(s==null||s.length()==0)
        	return result;
        if(this.checkWordBreak(s, wordDict)) {
        	this.wordBreak(s, "", wordDict, result);
        }
        return result;
    }
	
	public boolean checkWordBreak(String s, List<String> wordDict) {
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
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
	}
}
