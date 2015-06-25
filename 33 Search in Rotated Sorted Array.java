public class Solution {
    public int search(int[] nums, int target) {
        int index = nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        int res = binarySearch(nums, 0, index, target);
        if (res != -1) return res;
        return binarySearch(nums, index + 1, nums.length - 1, target);
    }
    public int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (nums[mid] == target) return mid;
            else if (nums[mid] > target)  hi = mid - 1;
            else                          lo = mid + 1;
        }
        return -1;
    }
}