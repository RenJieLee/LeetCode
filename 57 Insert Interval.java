/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int count = 0;
        int firstOverIndex = 0;//1 3, 6 9. 2 5
        while (firstOverIndex < intervals.size() && 
            intervals.get(firstOverIndex).end < newInterval.start) firstOverIndex++;
        if (firstOverIndex == intervals.size()) {
            intervals.add(newInterval);
        }   
        if (intervals.get(firstOverIndex).start > newInterval.end) {
            intervals.add(firstOverIndex, newInterval);
            return intervals;
        }
        intervals.set(firstOverIndex, 
                getOverInterval(
                    intervals.get(firstOverIndex), newInterval));
        for (int i = firstOverIndex + 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > intervals.get(firstOverIndex).end) break;
            intervals.set(firstOverIndex, 
                getOverInterval(
                    intervals.get(firstOverIndex), intervals.get(i)));
            count++;
        }
        while (count > 0) {
            intervals.remove(firstOverIndex + 1);
            count--;
        }
        return intervals;
    }
    public Interval getOverInterval(Interval i1, Interval i2) {
        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }
}