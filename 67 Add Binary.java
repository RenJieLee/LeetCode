public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int tmp = 0;
        String res = "";
        while (i >= 0 && j >= 0) {
            int addResult = Integer.parseInt("" + a.charAt(i)) + Integer.parseInt("" + b.charAt(j)) + tmp;
            if (addResult == 2 || addResult == 0) res = 0 + res;
            else                                  res = 1 + res;
            tmp = addResult / 2;
            i--;
            j--;
        }
        if (i == -1) {
            while (j >= 0) {
                int addResult = Integer.parseInt("" + b.charAt(j)) + tmp;
                if (addResult == 2 || addResult == 0) res = 0 + res;
                else                res = 1 + res;
                tmp = addResult / 2;
                j--;
            }
        } else {
            while (i >= 0) {
                int addResult = Integer.parseInt("" + a.charAt(i)) + tmp;
                if (addResult == 2 || addResult == 0) res = 0 + res;
                else                res = 1 + res;
                tmp = addResult / 2;
                i--;
            }
        }
        if (tmp == 1) {
            res = 1 + res;
        }
        return res;
    }
}