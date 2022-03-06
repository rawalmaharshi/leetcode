class SparseVector {
    
    int[] nums;
    
    SparseVector(int[] nums) {
        this.nums = nums;    
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int answer = 0;
        for (int i = 0; i < this.nums.length; i++) {
            answer += this.nums[i] * vec.nums[i];
        }
        return answer;
    }
}


// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);


/* USING HASHMAP */
class SparseVector2 {
    
    Map<Integer, Integer> map;
    
    SparseVector2(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                this.map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector2 vec) {
        int answer = 0;
        for (int key : vec.map.keySet()) {
            if (this.map.containsKey(key)) {
                answer += this.map.get(key) * vec.map.get(key);
            }
        }
        return answer;
    }
}


/* USING ARRAYLIST INDEX-VALUE PAIRS */
class SparseVector3 {
    
    List<int[]> pair;
    
    SparseVector3(int[] nums) {
        pair = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                this.pair.add(new int[] {i, nums[i]});
            }
        }
    }
    
    public int dotProduct(SparseVector3 vec) {
        //two pointer approach
        int answer = 0;
        int p = 0,  q = 0;
        while (p < this.pair.size() && q < vec.pair.size()) {
            //same index
            if (this.pair.get(p)[0] == vec.pair.get(q)[0]) {
                answer += this.pair.get(p)[1] * vec.pair.get(q)[1];
                p++;
                q++;
            } else if (this.pair.get(p)[0] > vec.pair.get(q)[0]) {
                q++;
            } else {
                p++;
            }
        }
        
        return answer;
    }
}
