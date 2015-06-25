public class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        while (res < nums.length && nums[res] < target) res++;
        return res;
    }
}