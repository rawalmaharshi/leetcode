class Solution {
    public void reverseString(char[] s) {
        // iterativeHelper(s);  
        recursiveHelper(s, 0, s.length - 1);
    }
    
    public void recursiveHelper(char[] s, int left, int right) {
        //base case
        if (left >= right) {
            return ;
        }
        
        //swap characters at left and right (just the way we did in the iterative method)
        if (s[left] != s[right]) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
        
        recursiveHelper(s, ++left, --right);
    }
    
    public void iterativeHelper(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            //can save this swap (unnecessary computation): if char[left] == char[right]
            if (s[left] != s[right]) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
            }
            left++;
            right--;
        }
        
        return ;
    }
}