import java.util.ArrayList;

public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < paths.length; i++) {
            switch (paths[i]) {
                case ""  : ;
                case "." : break;
                case "..": if (list.size() > 0) list.remove(list.size() - 1); break;
                default  : list.add(paths[i]);
            }
        }
        
        String res = "";
        for (String s : list) {
            res += "/" + s;
        }
        if (res.equals("")) return "/";
        return res;
    }
}