public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        ArrayList<Integer> resList = new ArrayList<Integer>();
        //resList.add(1);
        HashMap<Character, Integer> set = new HashMap<Character, Integer>();
        int i = 0;
        int j = 1;
        set.put(s.charAt(0), 0);
        while (j < s.length()) {
            Character c = s.charAt(j);
            if (set.containsKey(c)) {
                resList.add(j - i);
                if (set.get(c) + 1 > i) i = set.get(c) + 1;
            }
            set.put(c, j++);
        }
        resList.add(j - i);
        int res = resList.get(0);
        for (Integer t : resList) {
            if (t > res) res = t;
        }
        return res;
    }
}