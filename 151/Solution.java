class Solution {
    public String reverseWords(String s) {
        String[] sArr = s.trim().replaceAll(" +", " ").split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = sArr.length - 1; i >= 0; i--) {
            sb.append(sArr[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}