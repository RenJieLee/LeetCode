public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String tmp = "";
            for (int j = 0; j < res.length() && j < strs[i].length(); j++) {
                if (res.charAt(j) == strs[i].charAt(j)) tmp += res.charAt(j);
                else break;
            }
            res = tmp;
        }
        return res;
    }
}