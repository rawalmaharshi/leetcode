class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }   
        
        if (haystack.length() == 0) {
            return -1;
        }
        
        return firstApproach(haystack, needle);
        // return secondBetterApproach(haystack, needle);
    }
    
    public int secondBetterApproach(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
          // find the position of the first needle character
          // in the haystack string
          while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

          // compute the max match string
          int currLen = 0, pL = 0;
          while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
            ++pn;
            ++pL;
            ++currLen;
          }

          // if the whole needle string is found,
          // return its start position
          if (currLen == L) return pn - L;

          // otherwise, backtrack
          pn = pn - currLen + 1;
        }
        return -1;
    }
    
    public int firstApproach(String haystack, String needle) {
        int winStart = 0, winEnd = needle.length();
        while (winEnd <= haystack.length()) {
            String hayString = haystack.substring(winStart, winEnd);
            if (needle.equals(hayString)) {
                return winStart;
            } else {
                winStart++;
                winEnd++;
            }
        }
        
        return -1;
    }
}