public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) return false;
        int l = matrix[0].length;
        int lo = 0;
        int hi = matrix.length - 1;
        int i = lo + (hi - lo) / 2;
        while (lo <= hi) {
            if (matrix[i][0] <= target && matrix[i][l - 1] >= target) {
                return binarySearch(matrix[i], target);
            }
            if (matrix[i][0] > target) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
            i = lo + (hi - lo) / 2;
        }
        return false;
    }
    public boolean binarySearch(int[] row, int target) {
        int lo = 0;
        int hi = row.length - 1;
        int i = lo + (hi - lo) / 2;
        while (lo <= hi) {
            if (row[i] == target) return true;
            if (row[i] > target) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
            i = lo + (hi - lo) / 2;
        }
        return false;
    }
}