class TimeMap {

    Map<String, Map<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Map<Integer, String> innerMap = this.map.getOrDefault(key, new HashMap<>());
        innerMap.put(timestamp, value);
        map.put(key, innerMap);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return ""; 
        }
        
        Map<Integer, String> innerMap = map.get(key);
        if (innerMap.containsKey(timestamp)) {
            return innerMap.get(timestamp);
        }
        
        for (int i = timestamp; i >= 0; i--) {
            if (innerMap.containsKey(i)) {
                return innerMap.get(i);
            }
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

In the set() function, in each call, we store a value at (key, timestamp) location, which takes O(L) time to hash the string.
Thus, for M calls overall it will take, O(M⋅L) time.

In the get() function, in each call, we iterate linearly from timestamp to 1 which takes O(timestamp) time and again to hash the string it takes O(L) time.
Thus, for N calls overall it will take, O(N⋅timestamp⋅L) time.

Note: This approach can be TLE, since the time complexity is not optimal given the current data range in the problem description.

Space complexity:

In the set() function, in each call we store one value string of length L, which takes O(L) space.
Thus, for M calls we may store M unique values, so overall it may take O(M⋅L) space.

In the get() function, we are not using any additional space.
Thus, for all N calls it is a constant space operation.

*/