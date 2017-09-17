package leet.algorithm.q32;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int longestValidParentheses(String s) {
		int result = 0, currentValid = 0, leftBalance = 0;
		if(s==null){
			return 0;
		}
		int[] stack = new int[s.length()];
		int[] value = new int[s.length()];
		for(int i=0; i<s.length(); i++){
			value[i] = 1;
		}
		for(int i=0; i< s.length(); i++){
			switch(s.charAt(i)){
			case '(': 
					stack[leftBalance] =  value[i];
					leftBalance++;
					break;
			case ')':
					if(leftBalance>0){
						leftBalance--;
						currentValid = value[i] + stack[leftBalance];
						if(i+1<s.length())
							value[i+1] = value[i+1]+currentValid;
						result = Math.max(result, currentValid);
					}else{//leftBalance = 0;
						currentValid = 0;
					}
					break;
			default: break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.longestValidParentheses("(()())(()"));
	}

}
