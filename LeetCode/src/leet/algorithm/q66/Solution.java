package leet.algorithm.q66;

import java.util.Arrays;

public class Solution {
	public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i>=0; i--) {
        	digits[i] = digits[i]+1;
        	if(digits[i]<10) {
        		return digits;
        	}else {
        		digits[i] = digits[i] - 10;
        	}
        }
        int[] newResult = new int[digits.length+1];
        newResult[0] = 1;
        for(int i=0; i<digits.length; i++) {
        	newResult[i+1] = digits[i];
        }
        return newResult;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input = new int[] {9,9,9,9};
		System.out.println(Arrays.toString(sol.plusOne(input)));
	}
}
