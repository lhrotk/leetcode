package leet.algorithm.q04;

import java.util.HashMap;

public class Solution {
	 public String longestPalindrome(String s) {
	        String Result;
	        int maxLength = 1;
	        if(s==null||s.length()<=1){
	        	return s;
	        }else{
	        	Result = s.substring(0, 1);
	        }
	        for(double i=0.5; i<=s.length()-1.5;i = i+0.5){
	        	int x = (int) Math.ceil(i);
	        	int y = (int) Math.floor(i);
	        	int j = 0;
	        	for(; x+j<s.length()&&y-j>=0;j++){
	        		if(!(s.charAt(x+j)==s.charAt(y-j))) {
	        			break;
	        			}
	        	}
	        	if(2*j-(1-x+y)>maxLength){
	        		Result = s.substring(y-j+1, x+j);
	        		maxLength =2*j-(1-x+y);
	        	}
	        }
	        return Result;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.longestPalindrome("dd"));
	}

}
