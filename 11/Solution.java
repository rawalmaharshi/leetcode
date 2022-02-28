class Solution {
    public int maxArea(int[] height) {
        // return bruteForce(height);
        return optimized(height);
    }
    
    public int optimized(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    
    public int bruteForce(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i],height[j]) * (j - i));
            }
        }
        return max;
    }
}