package leet.algorithm.q10;
/**
 * @author lhrotk
 */
import java.util.Arrays;
public class Solution {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.isEmpty();
			}
		else if (p.length() == 1) {
			return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		} else {// p.length()>=2
			if (p.charAt(1) != '*') {
				return s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
						&& isMatch(s.substring(1), p.substring(1));
			} else {
				while (true) {
					if (isMatch(s, p.substring(2))) {
						return true;
						}
					if (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
						s = s.substring(1);
					} else {
						break;
						}
				}
				return false;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "test";
		Solution sol = new Solution();
		System.out.println(sol.isMatch("a", "ab*a"));
	}

}
