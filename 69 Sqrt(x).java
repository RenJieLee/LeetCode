public class Solution {
    public int mySqrt(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        double c = x;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t) t = (c/t + t) / 2.0;
        return (int)t;
    }
}