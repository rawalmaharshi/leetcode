class Solution {
    public int maxDistToClosest(int[] seats) {
        //edge case
        if (seats.length == 0) {
            return 0;
        }

        int [] maxDist = new int[seats.length];
        int maxD = 0;
        for (int i = 0; i < seats.length; i++) {
            int leftWinSize = 0;
            int rightWinSize = 0;
            boolean goLeft = true, goRight = true;
            int currWinSize = 1;
            if (seats[i] == 1) {
                maxDist[i] = 0; //Can't sit here
                continue;
            }

            while ((i - currWinSize) >= 0 || (i + currWinSize) < seats.length) {
                if (goLeft && goRight) {
                    if ((i - currWinSize) >= 0) {
                        if (seats[i - currWinSize] == 1) {
                            goLeft = false;
                            leftWinSize = currWinSize;
                        }
                    }

                    if ((i + currWinSize) < seats.length) {
                        if (seats[i + currWinSize] == 1) {
                            goRight = false;
                            rightWinSize = currWinSize;
                        }
                    }
                } else {
                    break;
                }
                currWinSize++;
            }
            goLeft = true;
            goRight = true;
            maxDist[i] = Math.max(leftWinSize, rightWinSize);
            maxD = Math.max(maxD, maxDist[i]);
        }

        return maxD;
    }
}

class Solution1 {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int K = 0; //current longest group of empty seats
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                K = 0;
            } else {
                K++;
                ans = Math.max(ans, (K + 1) / 2);
            }
        }

        for (int i = 0; i < N; ++i)  if (seats[i] == 1) {
            ans = Math.max(ans, i);
            break;
        }

        for (int i = N-1; i >= 0; --i)  if (seats[i] == 1) {
            ans = Math.max(ans, N - 1 - i);
            break;
        }

        return ans;
    }
}