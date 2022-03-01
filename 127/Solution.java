class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //make a hashset for O(1) retrieval
        Set<String> wordSet = new HashSet<>(wordList);
        //no transformation is possible
        if (!wordSet.contains(endWord)) return 0;
        
        int level = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                String curr = queue.poll();
                char[] currChar = curr.toCharArray();

                for (int i = 0; i < currChar.length; i++) {
                    char origChar = currChar[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == origChar) continue;
                        currChar[i] = c;
                        String checkIt = String.valueOf(currChar);
                        if (checkIt.equals(endWord)) {
                            return 1 + level;
                        }

                        if (wordSet.contains(checkIt)) {
                            queue.offer(checkIt);
                            wordSet.remove(curr);
                        }
                    }
                    currChar[i] = origChar;
                }   
            }
            level++;
        }
        
        return 0;   //no transformation is possible
    }
}