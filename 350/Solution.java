class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                //add to answer
                list.add(num);
                //update count
                map.put(num, map.get(num) - 1);

                //remove if zero
                if (map.get(num) == 0) {
                    map.remove(num);
                }
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
    1. Add the elements to a map with count
    2. Iterate over one array, add to answer values that are present in other array
    3. Update count in map
    4. Remove if count is zero
    T: O(n + m)
    S: O(n)
*/