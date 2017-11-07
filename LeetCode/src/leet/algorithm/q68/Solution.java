package leet.algorithm.q68;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<String>();
		int start = 0, end=0;
		while(start<words.length) {
			int acc = words[start].length();
			StringBuffer buffer = new StringBuffer(maxWidth);
			while(end+1<words.length&&words[end+1].length()+1+acc<=maxWidth) {
				end++;
				acc += words[end].length()+1;
			}
			if(end==start) {
				buffer.append(words[start]);
				for(int i=0; i<maxWidth-words[start].length(); i++) {
					buffer.append(' ');
				}
				result.add(buffer.toString());
			}else if(end!=words.length-1) {
				int[] spaceCount = new int[end-start];
				int remainSpace = maxWidth -acc;
				buffer.append(words[start]);
				for(int i=0; i<end-start; i++){
					spaceCount[i] = 1+(end-start-i-1 + remainSpace)/(end-start);
					for(int j=0; j<spaceCount[i]; j++) {
						buffer.append(' ');
					}
					buffer.append(words[start+i+1]);
				}
				result.add(buffer.toString());
			}else {
				buffer.append(words[start]);
				for(int i=0; i<end-start; i++){
					buffer.append(' ');
					buffer.append(words[start+i+1]);
				}
				for(int i=0; i<maxWidth-acc;i++) {
					buffer.append(' ');
				}
				result.add(buffer.toString());
			}
			start = end = end+1;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.fullJustify(new String[]{"what", "must", "be", "shall", "be."}, 12));
	}
}
