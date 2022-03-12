class Solution {
  Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};

  List<String> output = new ArrayList<String>();

  public void backtrack(String combination, String next_digits) {
    // if there is no more digits to check
    if (next_digits.length() == 0) {
      // the combination is done
      output.add(combination);
    }
    // if there are still digits to check
    else {
      // iterate over all letters which map 
      // the next available digit
      String digit = next_digits.substring(0, 1);
      String letters = phone.get(digit);
      for (int i = 0; i < letters.length(); i++) {
        String letter = phone.get(digit).substring(i, i + 1);
        // append the current letter to the combination
        // and proceed to the next digits
        backtrack(combination + letter, next_digits.substring(1));
      }
    }
  }

  public List<String> letterCombinations(String digits) {
    if (digits.length() != 0)
      backtrack("", digits);
    return output;
  }
}


class Solution2 {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        //edge case
        if (digits == null || digits.length() == 0) {
            return answer;
        }
        
        String[] mapping = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        
        combinationHelper(answer, digits, new StringBuilder(), 0, mapping);
        return answer;
    }
    
    public void combinationHelper(List<String> answer, String digits, StringBuilder current, int index, String[] mapping) {
        //base case
        if (index == digits.length()) {
            answer.add(current.toString());
            return ;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            combinationHelper(answer, digits, current.append(letters.charAt(i)), index + 1, mapping);
            current.setLength(current.length() - 1);
        }
        
        return ;
    }
}