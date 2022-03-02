class Solution {
    public int[] productExceptSelf(int[] nums) {
        // return usingBruteforce(nums);
        // return optimized(nums);
        return mostOptimized(nums);
    }
    
    public int[] mostOptimized(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;  //left product is 0
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        //uptill this point we have the left sum in the answer
        //now for right
        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= R;
            R *= nums[i];
        }
        
        return answer;
    }
    
    public int[] optimized(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        
        l[0] = 1;   //first element is going to be 1 as nothing on the left
        for (int i = 1; i < n; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }
        
        r[n - 1] = 1;   //last element is going to be 1 as nothing on the right
        for (int i = n - 2; i >= 0; i--) {
            r[i] = nums[i + 1] * r[i + 1];
        }
        
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = l[i] * r[i];
        }
        
        return answer;
    }
    
    public int[] usingBruteforce(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }
        
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                product *= nums[j];
            }
            answer[i] = product;
        }
        
        return answer;
    }
}