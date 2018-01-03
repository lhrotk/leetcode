package leet.algorithm.q150;

import java.util.Stack;

public class Solution {
	public int evalRPN(String[] tokens) {
		if(tokens == null|| tokens.length==0)
			return 0;
		int currentResult = Integer.valueOf(tokens[0]);
		Stack<Integer> stack = new Stack<Integer>();
        for(int i=1; i<tokens.length; i++) {
        	if(tokens[i].equals("+")) {
        		currentResult = currentResult + stack.pop();
        	}else if(tokens[i].equals("-")) {
        		currentResult = stack.pop()- currentResult;
        	}else if(tokens[i].equals("*")) {
        		currentResult = stack.pop() * currentResult;
        	}else if(tokens[i].equals("/")) {
        		currentResult = stack.pop() / currentResult;
        	}else {
        		stack.push(currentResult);
        		currentResult = Integer.valueOf(tokens[i]);
        	}
        }
        return currentResult;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input = new String[] {"4","13","5","/","+"};
		System.out.println(sol.evalRPN(input));
	}
}
