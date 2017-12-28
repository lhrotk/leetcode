package leet.algorithm.q739;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		if(temperatures==null)
			return null;
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<temperatures.length; i++) {
        	while(!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]) {
        		result[stack.peek()] = i - stack.pop();
        	}
        	stack.push(i);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] temp = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(Arrays.toString(sol.dailyTemperatures(temp)));
	}
}
