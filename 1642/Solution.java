class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // return usingMinHeap(heights, bricks, ladders);
        return usingMaxHeap(heights, bricks, ladders);
    }

    private int usingMinHeap(int[] heights, int bricks, int ladders) {
        //T: O(nlogn), S: O(n) --> Actually, O(nlogl), O(l) where l is the number of climbs
        Queue<Integer> minPQ = new PriorityQueue<>();
        
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            //Skip if climb is actually a jump (getting down is free)
            if (climb <= 0) {
                continue;
            }

            //otherwise allocate ladder
            minPQ.offer(climb);

            //If we have used all ladders (here k is number of ladders)
            if (minPQ.size() > ladders) {
                bricks -= minPQ.poll();
            }

            //If number of bricks is less than 0, we can't go further
            if (bricks < 0) {
                return i;
            }
        }

        //Reached the end
        return heights.length - 1;
    }

    private int usingMaxHeap(int[] heights, int bricks, int ladders) {
        //T: O(nlogn), S: O(n)
        Queue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            //Skip if climb is actually a jump (getting down is free)
            if (climb <= 0) {
                continue;
            }

            //Otherwise use bricks
            maxPQ.offer(climb);
            bricks -= climb;

            //If we have used all bricks and don't have ladders available
            if (bricks < 0 && ladders == 0) {
                return i;
            }

            //If we still have ladders available
            if (bricks < 0) {
                bricks += maxPQ.poll();
                ladders--;
            }
        }

        //Reached end
        return heights.length - 1;
    }
}