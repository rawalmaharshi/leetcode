class Solution {
    public void sortColors(int[] nums) { 
        // usingCount(nums);
        usingDijkstra(nums);
    }
    
    public void usingDijkstra(int[] nums) {
        //Dutch National Flag problem
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;
        
        int temp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                //Swap p0, curr -> increment p0, curr
                temp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = temp;
            } else if (nums[curr] == 2) {
                //Swap p2, curr -> decrement p2
                temp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = temp;
            } else {
                //when encounter 1, increment counter
                curr++;
            }
        }
    }
    
    public void usingCount(int[] nums) {
        int[] countColors = new int[3];
        for (int num : nums) {
            countColors[num]++;
        }
        
        int numIndex = 0;
        while (countColors[0]-- > 0) {
            nums[numIndex++] = 0;
        }
        
        while (countColors[1]-- > 0) {
            nums[numIndex++] = 1;
        }
        
        while (countColors[2]-- > 0) {
            nums[numIndex++] = 2;
        }
    }
}