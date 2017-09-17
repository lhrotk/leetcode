package leet.algorithm.q17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public void findCombination(StringBuffer buffer, List<String> result, String digits){
		if(digits.length()==0){
			if(!buffer.toString().equals(""))
				result.add(buffer.toString());
			return;
		}else{
			switch(digits.charAt(0)){
			case'2':
				findCombination(buffer.append('a'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('b'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('c'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				break;
			case'3':
				findCombination(buffer.append('d'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('e'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('f'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				break;
			case'4':
				findCombination(buffer.append('g'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('h'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('i'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				break;
			case'5':
				findCombination(buffer.append('j'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('k'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('l'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				break;
			case'6':
				findCombination(buffer.append('m'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('n'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('o'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				break;
			case'7':
				findCombination(buffer.append('p'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('q'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('r'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('s'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				break;
			case'8':
				findCombination(buffer.append('t'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('u'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('v'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				break;
			case'9':
				findCombination(buffer.append('w'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('x'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('y'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				findCombination(buffer.append('z'), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				break;
			case'0':
				findCombination(buffer.append(' '), result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
				break;
			default:
				findCombination(buffer, result, digits.substring(1));
				buffer.deleteCharAt(buffer.length()-1);
			}
		}
	}
	public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits==null)
        	return result; 
        StringBuffer buffer = new StringBuffer();
        findCombination(buffer, result, digits);
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.letterCombinations("23"));
	}

}
