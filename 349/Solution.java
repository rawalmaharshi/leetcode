class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //edge case
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                set.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1] < nums2[ptr2]) {
                ptr1++;
            } else {
                ptr2++;
            }
        }
        
        int[] answer = new int[set.size()];
        int index = 0;
        for (int element : set) {
            answer[index++] = element;
        }
        return answer;
    }
}

/** 
    Algo  -
    1. Sort both the arrays
    2. Two pointers -> increase the pointer for array that has the smaller element
    3. When same, add to answer and increase both pointers
    T: O(nlogn + mlogm + n + m) = O(nlogn + mlogm)
    S: O(n + m)
*/