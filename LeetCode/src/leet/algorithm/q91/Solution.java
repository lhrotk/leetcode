package leet.algorithm.q91;

public class Solution {
	public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0')
        	return 0;
        int pre = 1;// when no char
        int prepre = 1;//when only 1 char
        int combine = 0, alone = 0;
        for(int i=1; i<s.length(); i++) {
        	if(s.charAt(i)!='0') {// can be taken as individual character
        		alone = 1;
        	}else {
        		alone = 0;
        	}
        	if(s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)-'0'<=6)) {
        		combine = 1;
        	}else {
        		combine = 0;
        	}
        	int temp = pre;
        	pre = pre*alone + prepre*combine;
        	prepre = temp;
        }
        return pre;
    }
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		System.out.println(sol.numDecodings("1011"));
	}
}
