class Solution {
    List<List<String>> answer = new ArrayList<>();
    public List<List<String>> partition(String s) {
        partitionHelper(s, 0, new ArrayList<>());
        return answer;
    }

    private void partitionHelper(String s, int start, List<String> currList) {
        //end case
        if (start == s.length()) {
            answer.add(new ArrayList<>(currList));
            return ;
        }

        for (int i = start; i < s.length(); i++) {
            String subString = s.substring(start, i + 1);
            if (isPalindrome(subString)) {
                //add
                currList.add(subString);

                //recurse
                partitionHelper(s, i + 1, currList);

                //remove
                currList.remove(currList.size() - 1);
            }
        }

        return ;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}