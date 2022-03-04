class Solution {
    public int findKthLargest(int[] nums, int k) {
        // return arraySortMethod(nums, k);
        // return pqApproach1(nums, k);
        // return pqApproach2One(nums, k);
        return pqApproach2TwoOptimized(nums, k);
    }
    
    private int pqApproach2TwoOptimized(int[] nums, int k) {
        //Similar to pqApproach2One
        //Make a priority queue(min-heap) of size k
        //when all elements are added to pq, the kth largest element would be add top
        //OPTIMIZATION: rather than adding and deleting; adding only if the element is bigger than root
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            if (pq.size() >= k) {
                if (pq.peek() < num) {
                    pq.offer(num);
                    pq.poll();
                }
            } else {
                pq.offer(num);   
            }
        }
        
        return pq.peek();
    }
    
    private int pqApproach2One(int[] nums, int k) {
        //Make a priority queue(min-heap) of size k
        //when all elements are added to pq, the kth largest element would be add top
        
        // T: O(nlogk) -> Add n elements and deletion takes logk time if the size exceeds k
        // S: O(k) -> Storing k elements in min-heap
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
    
    private int pqApproach1(int[] nums, int k) {
        //Add all elements to a max-priority queue. Remove elements until k
        // T: O(klogn + n) -> Deleting takes logn time. Deleting k elements takes klogn, insertion takes O(n + logn) [O(n)] time
        // S: O(n) -> For storing all elements in PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.offer(num);
        }
        
        while (k-- > 1) {
            pq.poll();
        }
        
        return pq.peek();
    }
    
    private int arraySortMethod(int[] nums, int k) {
        // T: O(nlogn) -> Time for sorting
        // S: O(1) -> In place sort takes place
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}