class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }
        return -1.0;
    }

    public double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] mergedArray = new int[len1 + len2];
        int l1p = 0, l2p = 0, mergp = 0;
        while (l1p != len1 && l2p != len2) {
            if (nums1[l1p] <= nums2[l2p]) {
                mergedArray[mergp++] = nums1[l1p++];
            } else {
                mergedArray[mergp++] = nums2[l2p++];
            }
        }
        
        while (l1p != len1) {
            mergedArray[mergp++] = nums1[l1p++];
        }
        
        while (l2p != len2) {
            mergedArray[mergp++] = nums2[l2p++];
        }
        
        double median = 0.0;
        int mLength = mergedArray.length;
        if (mLength % 2 == 0) {
            median = (double) (mergedArray[mLength / 2] + mergedArray[(mLength - 1) / 2])/2;
        } else {
            median = mergedArray[mLength/2];
        }
        
        return median;
    }
}