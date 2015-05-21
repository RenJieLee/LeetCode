public class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        int sign = x / Math.abs(x);
        int res = reverseHelp(Math.abs(x), 0);
        //if (reverseHelp(res, 0) != Math.abs(x)) return 0;
        return sign * res;
    }
    public int reverseHelp(int x, int tmp) {
        if (isOverflow(tmp)) return 0;
        if (x / 10 == 0) {
            return x + tmp * 10;
        }
        tmp = x % 10 + tmp * 10;
        return reverseHelp(x / 10, tmp);
    }
    public boolean isOverflow(int tmp) {
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += tmp;
            if (res < 0) return true;
        }
        return false;
    }
}