class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxPQ = new PriorityQueue<>((x, y) -> Integer.compare(y.count, x.count));

        //Add to PQ
        if (a > 0) maxPQ.offer(new Pair('a', a));
        if (b > 0) maxPQ.offer(new Pair('b', b));
        if (c > 0) maxPQ.offer(new Pair('c', c));

        StringBuilder sb = new StringBuilder();
        while (!maxPQ.isEmpty()) {
            Pair curr = maxPQ.poll();

            //check if curr character is similar to last 2 character, if it is, get another element from pq
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == curr.c && sb.charAt(sb.length() - 2) == curr.c) {
                if (maxPQ.isEmpty()) {
                    break;
                }

                Pair next = maxPQ.poll();

                //add to answer
                sb.append(next.c);
                //decrement count
                next.count -= 1;

                //add to pq if count > 0
                if (next.count > 0) {
                    maxPQ.offer(new Pair(next.c, next.count));
                }
            } else {
                //add to answer
                sb.append(curr.c);
                //decrement count
                curr.count -= 1;
            }

            //add to pq if count > 0
            if (curr.count > 0) {
                maxPQ.offer(new Pair(curr.c, curr.count));
            }
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

/*
    Algorithm:
        1. Add characters to PQ if their frequency > 0
        2. Poll from PQ and add to answer depending on -
            a. If last 2 characters are not same as current character, add to answer
            b. If last 2 characters are same as current character, poll another character from PQ
        3. Continue until PQ is empty
        Time Complexity - O(nlogn) where n is (a + b + c) -> logn = 1 --> O(n)
        Space Complexity - O(n) -> O(a + b + c) -> O(1)
 */