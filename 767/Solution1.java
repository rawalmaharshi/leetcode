//REFACTORED CODE FROM THE OTHER SOLUTION

class Solution {
    public String reorganizeString(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> maxPQ = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));

        for (Character key : map.keySet()) {
            maxPQ.offer(new Pair(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while (!maxPQ.isEmpty()) {
            int cycle = 2;  // here cycle is 2 because same characters cannot be adjacent
            List<Pair> store = new ArrayList<>();

            while (cycle-- > 0 && !maxPQ.isEmpty()) {
                Pair curr = maxPQ.poll();

                //check if it is not adjacent
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == curr.c) {
                    return "";
                }

                //append to answer
                sb.append(curr.c);

                //add to store only if currCount > 1
                if (curr.count > 1) {
                    store.add(new Pair(curr.c, curr.count - 1));
                }
            }
            maxPQ.addAll(store);
        }
        
        return sb.toString();
    }
}

class Pair {
    char c;
    int count;

    public Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }
}