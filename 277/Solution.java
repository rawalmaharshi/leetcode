/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // return bruteForce(n);
        return optimized(n);
    }

    //TC: O(n)
    private int optimized(int n) {
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }

            if (isCelebrity(candidate, n)) {
                return candidate;
            }
        }

        //no celebrity
        return -1;
    }

    //TC: O(n^2)
    private int bruteForce(int n) {
        for (int i = 0; i < n; i++) {
            if (isCelebrity(i, n)) {
                return i;
            }
        }

        //no celebrity
        return -1;
    }

    private boolean isCelebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;

            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }

        return true;
    }
}