public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int count = 0;
        if (nums[0] != val) {
            nums[count++] = nums[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            while (nums[i + 1] == val)  {
                i++;
                if (i == nums.length - 1) break;
            }
            if (i == nums.length - 1) break;
            nums[count++] = nums[i + 1];
        }
        
        if (count < nums.length && nums[nums.length - 1] != val) nums[count] = nums[nums.length - 1];
        return count;
        
    }
}