package leet.algorithm.q49;
/**
 * @author lhrotk
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		if(strs==null||strs.length==0) {
			return new ArrayList<List<String>>();
			}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(int i=0; i<strs.length; i++) {
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String index = String.valueOf(temp);
			if(!map.containsKey(index)) {
				map.put(index, new ArrayList<String>());
				}
			map.get(index).add(strs[i]);
		}
        return new ArrayList<List<String>>(map.values());
    }
	
	public static void main(String[] args) {
		
	}
}
