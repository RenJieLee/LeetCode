public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {//attention range
            if (nums[i] == nums[i + 1]) {
                nums[count++] = nums[i];
                i++;
            }
            if (i == nums.length - 1) break;
            while (nums[i] == nums[i + 1]) {
                i++;
                if (i == nums.length - 1) break;
            }
            //count;
            nums[count++] = nums[i];
        }
        if (nums[count - 1] != nums[nums.length - 1]) 
            nums[count++] = nums[nums.length - 1];
        else if (count == 1 || (count - 2 >= 0 && nums[count - 2] != nums[nums.length - 1]))
            nums[count++] = nums[nums.length - 1];
        return count;
    }
}