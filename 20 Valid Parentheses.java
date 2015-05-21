import java.util.ArrayList;

public class Solution {
    public boolean isValid(String s) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            String ch = s.charAt(i) + "";
            switch (ch) {
                case ")" : if (list.size() >= 1 && list.get(list.size() - 1).equals("(")) list.remove(list.size() - 1);
                           else return false; 
                           break;
                case "}" : if (list.size() >= 1 && list.get(list.size() - 1).equals("{")) list.remove(list.size() - 1);
                           else return false; 
                           break;
                case "]" : if (list.size() >= 1 && list.get(list.size() - 1).equals("[")) list.remove(list.size() - 1);
                           else return false; 
                           break;
                default  : list.add(ch);
            }
        }
        if (list.size() == 0) return true;
        return false;
    }
}