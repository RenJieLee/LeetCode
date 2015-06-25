public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int findIndex = binarySearch(nums, target);
        int[] res = new int[2];
        res[0] = findIndex;
        res[1] = findIndex;
        if (findIndex == -1) return res;
        while (res[0] - 1 >= 0 && nums[res[0] - 1] == target) res[0]--;
        while (res[1] + 1 < nums.length && nums[res[1] + 1] == target) res[1]++;
        return res;
    }
    public int binarySearch(int[] row, int target) {
        int lo = 0;
        int hi = row.length - 1;
        int i = lo + (hi - lo) / 2;
        while (lo <= hi) {
            if (row[i] == target) return i;
            if (row[i] > target) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
            i = lo + (hi - lo) / 2;
        }
        return -1;
    }
}