package leet.algorithm.q127;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int depth = 1;
		Set<String> beginList = new HashSet<String>();
		Set<String> nUsedList = new HashSet<String>();
		for(int i=0; i<wordList.size(); i++) {
			nUsedList.add(wordList.get(i));
		}
		beginList.add(beginWord);
        while(depth<wordList.size()&&!beginList.isEmpty()) {
        	depth++;
        	Set<String> tempList = new HashSet<String>();
        	for(String each: beginList) {
        		for(int j=0; j<each.length(); j++) {
        			char[] chars = each.toCharArray();
        			for(char c = 'a'; c<='z'; c++) {
        				chars[j] = c;
        				String word = new String(chars);
        				if(nUsedList.contains(word)) {
        					if(word.equals(endWord))
        						return depth;
        					nUsedList.remove(word);
        					tempList.add(word);
        				}
        			}
        		}
        	}
        	beginList = tempList;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(sol.ladderLength("hit", "cog", wordList));
	}
}
