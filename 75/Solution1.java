class Solution {
    public void sortColors(int[] nums) {
        // usingCount(nums);
        usingPointers(nums);
    }

    /**
        * Dutch national flag problem
        * Will keep 3 pointers 
            - Rightmost edge of 0
            - Leftmost edge of 2
            - curr pointer
        * If the current element is 0, swap it with rightmost edge of 0, increase rightmost edge of 0
        * If the current element is 2, swap it with leftmost edge of 2, decrease leftmost edge of 2
     */
    private void usingPointers(int[] nums) {
        int p0 = 0, curr = 0, p2 = nums.length - 1;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums, p0++, curr++);
            } else if (nums[curr] == 2) {
                swap(nums, p2--, curr); //Incase 2 is swapped, curr is kept same otherwise some elements will not be sorted
            } else {
                curr++;
            }
        }

        return ;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void usingCount(int[] nums) {
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] == 1) {
                oneCount++;
            } else {
                twoCount++;
            }
        }

        int index = 0;
        while (zeroCount-- > 0) {
            nums[index++] = 0;
        }

        while (oneCount-- > 0) {
            nums[index++] = 1;
        }

        while (twoCount-- > 0) {
            nums[index++] = 2;
        }

        return ;
    }
}