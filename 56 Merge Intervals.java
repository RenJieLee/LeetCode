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
    public List<Interval> merge(List<Interval> intervals) {
        while (!isSorted(intervals))
            sort(intervals, 0, intervals.size() - 1);
        return intervals;
    }
    public boolean isSorted(List<Interval> intervals) {
        for (int i = 1; i < intervals.size(); i++)
            if (intervals.get(i).start <= intervals.get(i - 1).end)
                return false;
        return true;
    }
    public void sort(List<Interval> intervals, int lo, int hi) {
        if (hi <= lo) return;
        int i = lo + 1, lt = lo, gt = hi;
        int start = intervals.get(lo).start;
        int end = intervals.get(lo).end;
        while (i <= gt) {
            if (intervals.get(i).end < start) {
                exch(intervals, i++, lt++);
            } else if (intervals.get(i).start > end) {
                exch(intervals, i, gt--);
            } else {
                i++;
            }
        }
        for (int j = 0; j < i - lt - 1; j++) {
            Interval tmp = intervals.remove(lt + 1);
            intervals.set(lt, getOverInterval(tmp, intervals.get(lt)));
        }
        
        sort(intervals, lo, lt - 1);
        
        sort(intervals, lt + 1, intervals.size() - 1);
    }
    public Interval getOverInterval(Interval i1, Interval i2) {
        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }
    public void exch(List<Interval> intervals, int i, int j) {
        Interval tmp = intervals.get(i);
        intervals.set(i, intervals.get(j));
        intervals.set(j, tmp);
    }
}