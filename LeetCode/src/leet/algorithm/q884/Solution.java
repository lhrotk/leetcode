/**
 * 
 */
package leet.algorithm.q884;

import java.util.Stack;

/**
 * @author lhrotk
 *
 */
public class Solution {
	public boolean isDigit(char oneChar) {
		if(oneChar>='0'&&oneChar<='9')
			return true;
		else 
			return false;
	}
	
	
	public String decodeAtIndex(String S, int K) {
        int currentL = 0;
        int currentPos = 0;
        int mul = 1;
        char[] charArray = S.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        while(currentPos<charArray.length) {
        	if(this.isDigit(charArray[currentPos]))
        		currentPos++;
        	else
        		break;
        }
        
        stack.push(0);
        stack.push(1);
        stack.push(0);
        
        while(currentPos<charArray.length) {
        	while(currentPos<charArray.length&&currentL<K) {
        		if(!this.isDigit(charArray[currentPos])) {
        			currentL++;
        			currentPos++;
        		}
        		else 
        			break;
        	}
        	mul = 1;
        	while(currentPos<charArray.length&&currentL*mul<K) {
        		if(this.isDigit(charArray[currentPos])) {
        			mul *= charArray[currentPos]-'0';
        			currentPos++;
        		}
        		else 
        			break;
        	}
        	stack.push(currentL);
        	stack.push(mul);
        	stack.push(currentPos);
        	currentL *= mul;
        	if(currentL>=K)
        		break;
        	
        }
        
        if(currentPos==charArray.length&&currentL<K)
        	return "";
        
        while(true) {
        	int startIndex = stack.pop();
        	mul = stack.pop();
        	int preLength = stack.pop();
        	if(K>preLength*mul) {
        		return charArray[K-preLength*mul-1+startIndex]+"";
        	}else {
        		K = Math.floorMod(K-1, preLength)+1;
        	}
        }
        
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.decodeAtIndex("leet2code3",10));
		}
}
