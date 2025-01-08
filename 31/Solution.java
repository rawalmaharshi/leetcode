class Solution {
    public void nextPermutation(int[] nums) {
        int pivotIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            //before this pivot point, elements are monotonically decreasing i.e no next permutation is possible
            if (nums[i] > nums[i - 1]) {
                pivotIndex = i - 1;
                break;
            }
        }

        //swap the element at the pivotIndex with the next largest element (find this by traversing the array from the end again) , this will be the next bigger permutation 
        if (pivotIndex > -1) {
            int n = nums.length - 1;
            while (nums[n] <= nums[pivotIndex]) {
                n--;
            }
            swap(nums, pivotIndex, n);
        }

        //reverse the elements on the right of the pivotIndex
        reverse(nums, pivotIndex + 1, nums.length - 1);

        return ;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}

/*
    Algo: 
    1. Find the pivot point where the next element is bigger than the current element
    2. Swap the pivot element with the element just bigger than it which can be found by traversing the array from the end
    3. Reverse the elements on the right of the pivot point
    
    Time complexity: O(N)
    Space complexity: O(1)
 */

/*
    Test cases:
    3, 4, 3, 8, 1 --> 3, 4, 8, 1, 3 
        (swapped 3 with 8 and reversed the elements on the right of 3)
    
    3, 4, 3, 2, 1 --> 4, 1, 2, 3, 3 
        (swapped 4 with 3 and reversed the elements on the right of 3)
    
    1, 2, 3 --> 1, 3, 2 
        (swapped 2 with 3 and reversed the elements on the right of 2)
    
    3, 2, 1 --> 1, 2, 3 
        (no swapping as it is monotonically decreasing; just reverse)
    
    1, 1, 5 --> 1, 5, 1 
    
    7, 4, 5, 8, 6, 3, 2, 1 --> 7, 4, 6, 1, 2, 3, 5, 8
        (swapped 5 with 6 and reversed the elements on the right of 5)
        (Important test case to understand what element to swap)
 */