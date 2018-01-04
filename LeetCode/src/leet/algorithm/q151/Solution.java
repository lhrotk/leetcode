package leet.algorithm.q151;

import java.util.Stack;

public class Solution {
	public String reverseWords(String s) {
		Stack<String> stack = new Stack<String>();
		StringBuffer buffer = new StringBuffer();
		char[] source = s.toCharArray();
		for(int i=0; i<source.length; i++) {
			if(source[i]==' ') {
				if(buffer.length()!=0) {
					stack.push(buffer.toString());
					buffer = new StringBuffer();
				}
			}else {
				buffer.append(source[i]);
			}
		}
		
		if(buffer.length()!=0) {
			stack.add(buffer.toString());
			buffer = new StringBuffer();
		}
		
		while(!stack.isEmpty()) {
			buffer.append(stack.pop());
			buffer.append(' ');
		}
		if(buffer.length()!=0)
			buffer.deleteCharAt(buffer.length()-1);
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.reverseWords("i "));
	}
}
