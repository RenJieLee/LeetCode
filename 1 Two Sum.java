import java.util.HashSet;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashSet<Integer> hashset = new HashSet<Integer>();
        for (int i : nums) {
            hashset.add(i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (!hashset.contains(target - nums[i])) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return res;
    }
}