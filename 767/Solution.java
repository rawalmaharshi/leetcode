class Solution {
    public String reorganizeString(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> maxPQ = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (b.getCount() - a.getCount() > 0) {
                    return 1;
                } else if (b.getCount() - a.getCount() < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (Character key : map.keySet()) {
            maxPQ.offer(new Pair(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while (!maxPQ.isEmpty()) {
            int cycle = 2;  // here cycle is 2 because same characters cannot be adjacent
            List<Pair> store = new ArrayList<>();

            while (cycle-- > 0 && !maxPQ.isEmpty()) {
                Pair p = maxPQ.poll();
                char currChar = p.getChar();
                int currCount = p.getCount();

                //check if adjacent characters are same
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == currChar) {
                    return "";
                }

                //append to answer
                sb.append(currChar);

                //add to store only if currCount > 1
                if (currCount > 1) {
                    store.add(new Pair(currChar, currCount - 1));
                }
            }

            //add characters back to PQ with updated frequency
            for (Pair p : store) {
                maxPQ.offer(p);
            }
        }
        
        return sb.toString();
    }
}

class Pair {
    private char c;
    private int count;

    public Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public char getChar() {
        return this.c;
    }
}

/*
    Algo:
    1. Create a map of character and its frequency.
    2. Create a maxPQ to store the characters in decreasing order of frequency.
    3. While maxPQ is not empty, do the following:
        a. Create a cycle of 2 to make sure same characters are not adjacent.
        b. Create a store for characters whose frequency is greater than 1 - these will be added back to pq
        c. While cycle is not 0 and maxPQ is not empty, do the following:
            i. Poll the character from maxPQ.
            ii. Check if the character is not adjacent to the last character in the answer.
            iii. Append the character to the answer.
            iv. If the frequency of the character is greater than 1, add it to the store.
        d. Add the characters back to the maxPQ with updated frequency.
    
    Time Complexity: O(Nlogk), k is at max 26 -> O(N)
    Space Complexity: O(k) -> O(26) -> O(1)
 */