package leet.algorithm.q71;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
        	return null;
        }else if(path.charAt(0) != '/') {
        	return null;
        }
        List<String> pathSet = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer();
        for(int i=1; i<path.length(); i++) {
        	if(path.charAt(i)!='/') {
        		buffer.append(path.charAt(i));
        		if(i == path.length()-1) {
        			String temp = buffer.toString();
        			if(temp.equals("..")) {
        				if(pathSet.size()>0) {
            				pathSet.remove(pathSet.size()-1);
            			}
            		}else if(!temp.equals("")&&!temp.equals(".")) {
            			pathSet.add(temp);
            		}
        		}
        	}else {
        		String temp = buffer.toString();
        		buffer = new StringBuffer();
        		if(temp.equals("..")) {
        			if(pathSet.size()>0) {
        				pathSet.remove(pathSet.size()-1);
        			}
        		}else if(!temp.equals("")&&!temp.equals(".")) {
        			pathSet.add(temp);
        		}
        	}
        }
        buffer = new StringBuffer();
        if(pathSet.size() == 0)
        	return "/";
        for(int i=0; i<pathSet.size(); i++) {
        	buffer.append('/');
        	buffer.append(pathSet.get(i));
        }
        return buffer.toString();
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.simplifyPath("/.."));
    }
}
