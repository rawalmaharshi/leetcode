class Solution {
    public int trap(int[] height) {
        //edge case
        if (height.length <= 1) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int answer = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                answer += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                answer += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        
        return answer;
    }
}