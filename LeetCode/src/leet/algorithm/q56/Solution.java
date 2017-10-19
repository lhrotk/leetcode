package leet.algorithm.q56;
/**
 * @author lhrotk
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null || intervals.size() <= 1) {
			return intervals;
			}
		Collections.sort(intervals, new Comparator<Interval>() {
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
    	   
       });
       
       for(int i=0; i<intervals.size(); i++) {
    	   int j=i+1;
    	   while(j<intervals.size()) {
    		   if(intervals.get(j).start>intervals.get(i).end) {
    			   break;
    		   }else {
    			   if(intervals.get(j).end > intervals.get(i).end) {
    				   intervals.get(i).end = intervals.get(j).end;
    				   }
    			   intervals.remove(j);
    		   }
    	   }
       }
       
       return intervals;
    }
	
	public static void main(String[] args) {
		List<Interval> intervals= new ArrayList<Interval>();
		Interval interval1 = new Interval(1,3);
		intervals.add(interval1);
		Interval interval2 = new Interval(8,10);
		intervals.add(interval2);
		Interval interval3 = new Interval(2,6);
		intervals.add(interval3);
		Interval interval4 = new Interval(15,18);
		intervals.add(interval4);
//		Interval interval5 = new Interval(12,16);
//		intervals.add(interval5);
//		Interval interval6 = new Interval(4,9);
		Solution sol = new Solution();
		List<Interval> result = sol.merge(intervals);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i).start+","+result.get(i).end);
		}
	}
}
