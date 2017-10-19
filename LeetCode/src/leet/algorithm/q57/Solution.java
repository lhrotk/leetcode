package leet.algorithm.q57;
/**
 * @author lhrotk
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int i=0;
		for(; i<intervals.size(); i++) {
			if(newInterval.start>intervals.get(i).end) {
				continue;
				}
			else if(newInterval.end<intervals.get(i).start) {
				intervals.add(i, newInterval);
				break;
			}else if(newInterval.start>=intervals.get(i).start&&newInterval.end<=intervals.get(i).end) {
				break;
			}else if(newInterval.start<intervals.get(i).start&&newInterval.end<=intervals.get(i).end) {
				intervals.get(i).start = newInterval.start;
				break;
			}else {
				intervals.get(i).end = newInterval.end;
				if(newInterval.start<intervals.get(i).start) {
					intervals.get(i).start = newInterval.start;
					}
				for(int j=i+1; j<intervals.size(); j++) {
					if(intervals.get(j).start>intervals.get(i).end) {
						return intervals;
						}
					else if(intervals.get(j).end>= intervals.get(i).end) {
						intervals.get(i).end = intervals.get(j).end;
						intervals.remove(j);
						return intervals;
					}else {
						intervals.remove(j);
						j--;
						continue;
					}
				}
				return intervals;
			}
		}
		if(i==intervals.size()) { 
			intervals.add(newInterval);
			}
        return intervals;
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals= new ArrayList<Interval>();
		Interval interval1 = new Interval(1,5);
		intervals.add(interval1);
		Interval interval2 = new Interval(2,7);
//		intervals.add(interval2);
//		Interval interval3 = new Interval(2,5);
//		intervals.add(interval3);
//		Interval interval4 = new Interval(8,10);
//		intervals.add(interval4);
//		Interval interval5 = new Interval(12,16);
//		intervals.add(interval5);
//		Interval interval6 = new Interval(4,9);
		Solution sol = new Solution();
		List<Interval> result = sol.insert(intervals, interval2);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i).start+","+result.get(i).end);
		}
	}

}
