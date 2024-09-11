/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid) == false) {
                //search right
                left = mid + 1;
            } else {
                if (isBadVersion(mid - 1) == false) {
                    return mid;
                } else {
                    //otherwise search left
                    right = mid;
                }
            }
        }

        return -1;
    }
}