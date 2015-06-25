import java.util.ArrayList;

public class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int res = 0;
        list.add(height[0]);
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= list.get(list.size() - 1)) list.add(height[i]);
            else res += trapHelp(list, height[i]);
        }
        return res;
    }
    public int trapHelp(ArrayList<Integer> list, int height) {
        int res = 0;
        if (list.size() == 1) {
            list.add(height);
            return res;
        }
        int index = list.size() - 1;
        while (true) {
            if (list.get(index - 1) >= height) return trapSpecial(list, height);
            if (list.get(--index) > list.get(list.size() - 1)) break;
            if (index == 0) {
                list.add(height);
                return 0;
            }
        }
        
        int count = 0;
        while (list.get(index) > list.get(list.size() - 1)) {
            res += list.get(index) - list.remove(list.size() - 1);
            count++;
        }
        for (int i = 0; i < count; i++) list.add(list.get(index));
        return res += trapHelp(list, height);
    }
    public int trapSpecial(ArrayList<Integer> list, int height) {
        int count = 0;
        int res = 0;
        while (height > list.get(list.size() - 1)) {
            res += height - list.remove(list.size() - 1);
            count++;
        }
        for (int i = 0; i < count + 1; i++) list.add(height);
        return res;
    }
}