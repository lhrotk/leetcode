package leet.algorithm.q43;

public class Solution {
	public String multiply(String num1, String num2) {
        int[] result = new int[220];
        int startIndex = 0, acc = 0, k=0;
        if(num1 == null|| num2 == null)
        	return null;
        for(int j=num2.length()-1; j>=0; j--, startIndex++) {
        	k = startIndex;
        	for(int i=num1.length()-1; i>=0; i--, k++) {
        		result[k] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0') + acc;
        		acc = result[k]/10;
        		result[k] = result[k]%10;
        	}
        	while(acc!=0) {
        		result[k] += acc;
        		acc = result[k]/10;
        		result[k] = result[k]%10;
        		k++;
        	}
        }
        StringBuffer buffer = new StringBuffer();
        k--;
        for(boolean found = false; k>=0; k--) {
        	if(found)
        		buffer.append(result[k]);
        	else{
        		if(result[k]==0&&k!=0)
        			continue;
        		else {
        			found = true;
        			buffer.append(result[k]);
        		}
        	}
        }
        return buffer.toString();
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.multiply("999999", "10000"));
	}
}
