package leet.algorithm.q97;

public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
	       if(s3.length()!= s1.length() + s2.length())
	    	   return false;
	       boolean[] bag = new boolean[s1.length()+1];
	       bag[0] = true;
	       for(int i=1; i<bag.length; i++) {
	    	   bag[i] = bag[i-1]&&(s1.charAt(i-1) == s3.charAt(i-1));
	       }
	       for(int j=1; j<s2.length()+1; j++) {
	    	   bag[0] = bag[0]&&(s2.charAt(j-1)==s3.charAt(j-1));
	    	   for(int i=1; i<bag.length; i++) {
	    		   bag[i] = bag[i]&&(s2.charAt(j-1)==s3.charAt(i+j-1))||bag[i-1]&&(s1.charAt(i-1)==s3.charAt(i+j-1));
	    	   }
	       }
	       return bag[bag.length-1];
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.isInterleave("aabcc","dbbca","aadbbcbcac"));
		System.out.println(sol.isInterleave("aabcc","dbbca","aadbbbaccc"));
	}
}	
