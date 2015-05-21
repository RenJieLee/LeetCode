public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return getMedian(nums2);
        if (nums2 == null || nums2.length == 0) return getMedian(nums1);
        int[] res = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < res.length; i++) {
            if (index1 < nums1.length && index2 < nums2.length) {
                if (nums1[index1] < nums2[index2]) res[i] = nums1[index1++];
                else if (nums1[index1] >= nums2[index2]) res[i] = nums2[index2++];
            } 
            else if (index1 >= nums1.length) res[i] = nums2[index2++];
            else res[i] = nums1[index1++];
        }
        return getMedian(res);
    }
    public double getMedian(int[] res) {
        
        if (res.length % 2 == 0) return (res[res.length / 2] + res[res.length / 2 - 1]) / 2.0;
        else return res[res.length / 2] * 1.0;
    }
}