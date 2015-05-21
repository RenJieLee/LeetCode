public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        x = Math.abs(x);
        if (x / 10 == 0) return true;
        return isPalindrome(new Integer(x).toString());
    }
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        
        String reverse = new StringBuilder(s).reverse().toString();
        for (int i = 0, j = 0; i < reverse.length(); i++,j++) {
            if (reverse.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}