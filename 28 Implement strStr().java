public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        if (needle.equals("")) return 0;
        int n1 = haystack.length();
        int n2 = needle.length();
        int index = 0;
        for (int i = 0; i < n1 - n2 + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(index)) {
                boolean judge = true;
                for (int j = 1; j < n2; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        judge = false;
                        break;
                    }
                }
                if (judge) return i;
            }
        }
        return -1;
    }
}