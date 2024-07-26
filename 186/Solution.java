class Solution {
    public void reverseWords(char[] s) {
        //edge case
        if (s == null || s.length <= 1) {
            return ;
        }

        //1st pass - reverse the whole array (in-place by swapping)
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        //2nd pass - reverse each word 
        int i = 0, j = 1;
        while(j < s.length) {
            //iterate till a space character is reached
            if (s[j] == ' ' || j == s.length - 1) {
                //in case its a space, one position before it, in case it's the end, then that position
                int k = s[j] == ' ' ? j - 1 : j;
                while (i < k) {
                    char temp = s[i];
                    s[i] = s[k];
                    s[k] = temp;
                    i++;
                    k--;
                }
                // i is set to next position after space character
                i = j + 1;
            }
            j++;
        }

        return ;
    }
}