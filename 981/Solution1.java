class TimeMap {

    Map<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> innerMap = this.map.getOrDefault(key, new TreeMap<>());
        innerMap.put(timestamp, value);
        map.put(key, innerMap);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return ""; 
        }
        
        /*The floorKey method returns a key equal to or less than searched key or null if no such key exists that satisfies the above condition.*/
        Integer floorKey = map.get(key).floorKey(timestamp);
        
        if (floorKey != null) {
            return map.get(key).get(floorKey);
        }
        
        return ""; 
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

/**
 If M is the number of set function calls, N is the number of get function calls, and L is average length of key and value strings.

Time complexity:

In the set() function, in each call we store a value at (key, timestamp) location, which takes O(L⋅logM) time as the internal implementation of sorted maps is some kind of balanced binary tree and in worst case we might have to compare logM nodes (height of tree) of length L each with our key.
Thus, for M calls overall it will take, O(L⋅M⋅logM) time.

In the get() function, we will find correct key in our map, which can take O(L⋅logM) time and then use binary search on that bucket which can have at most M elements, which takes O(logM) time. Thus, for N calls overall it will take, O(N⋅(L⋅logM+logM)) time.

Space complexity:

In the set() function, in each call we store one value string of length L, which takes O(L) space.
Thus, for M calls we may store M unique values, so overall it may take O(M⋅L) space.

In the get() function, we are not using any additional space.
Thus, for all N calls it is a constant space operation.

*/