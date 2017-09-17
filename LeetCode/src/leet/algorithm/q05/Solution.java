package leet.algorithm.q05;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public String convert(String s, int numRows) {
		if(numRows==1||s==null){
			return s;
		}
        List<StringBuffer> buffer = new ArrayList<StringBuffer>();
        for(int i=0; i<numRows; i++){
        	StringBuffer temp = new StringBuffer();
        	buffer.add(temp);
        }
        int cycle = 2*numRows - 2;
        for(int i=0; i<s.length();i++){
        	int index = numRows - 1 - Math.abs(i % cycle - numRows + 1);
        	buffer.get(index).append(s.charAt(i));
        }
        for(int i=1; i<numRows; i++){
        	buffer.get(0).append(buffer.get(i));
        }
        return buffer.get(0).toString();
    }

	public static void main(String[] args) {
			Solution sol = new Solution();
			System.out.println(sol.convert("ABC", 2));
	}

}
