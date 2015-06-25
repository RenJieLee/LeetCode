public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        return countAndSayHelp(n - 2, "1");
    }
    public String countAndSayHelp(int n, String start) {
        String res = "";
        if (start.length() == 1) res += ("1" + start);
        else {
            int index = 0;
            for (; index < start.length() - 1; index++) {
                int count = 1;
                while (start.charAt(index) == start.charAt(index + 1)) {
                    index++;
                    count++;
                    if (index == start.length() - 1) break;
                }
                res += count + "" + start.charAt(index);
                if (index == start.length() - 2) {
                    res += 1 + "" + start.charAt(++index);
                }
            }
        }
        if (n == 0) return res;
        return countAndSayHelp(n - 1, res);
    }
}