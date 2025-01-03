class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //edge case
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                list.add(num);
            }
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for (int element : list) {
            answer[index++] = element;
        }
        return answer;
    }
}

/** 
    Algo  -
    1. Add the elements to two sets
    2. Iterate over one set, add to answer values that are present in other set
    T: O(n + m)
    S: O(n + m)
*/