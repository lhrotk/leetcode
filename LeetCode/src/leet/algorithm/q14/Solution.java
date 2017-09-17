package leet.algorithm.q14;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
        	return "";
        }
        String common = strs[0];
        for(int i=1; i<strs.length;i++){
        	int j=0;
        	for(; j<strs[i].length()&&j<common.length();j++){
        		if(common.charAt(j)!=strs[i].charAt(j)){
        			break;
        		}
        	}
        	common = common.substring(0, j);
    		if(j==0)
    			return common;
        }
        return common;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[] strs = new String[]{"adaaa"};
		System.out.println(sol.longestCommonPrefix(strs));
	}
}
