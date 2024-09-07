class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // return bruteForce(buildings);
        return priorityQueue(buildings);
    }

    /**
        T: O(n^2) 
        S: O(n)
        Algorithm - 
        1. Maintain a positions set that contains all edges
        2. Sort the positions set
        3. Iterate over position set - 
            i. Iterate over all buildings
            ii. Check if current building overlaps with position - If yes, update maxHeight
        4. If answer's last height is not equal to currentMaxHeight, add to answer
     */
    private List<List<Integer>> bruteForce(int[][] buildings) {
        Set<Integer> edgeSet = new TreeSet<>();
        for (int[] building : buildings) {
            int left = building[0], right = building[1];
            edgeSet.add(left);
            edgeSet.add(right);
        }

        List<Integer> positions = new ArrayList<>(edgeSet);
        Collections.sort(positions);

        List<List<Integer>> answer = new ArrayList<>();
        int maxHeight, left, right, height;

        //draw an imaginary vertical line for all poisitions
        for (int position : positions) {
            //current max height
            maxHeight = 0;

            //iterate over all buildings
            for (int[] building : buildings) {
                left = building[0];
                right = building[1];
                height = building[2];

                //if the current building intersects with the line, update maxHeight
                if (left <= position && position < right) {
                    maxHeight = Math.max(height, maxHeight);
                }
            }

            //if its the first key point or the height changes, we add [position, maxHeight] to answer
            if (answer.isEmpty() || answer.get(answer.size() - 1).get(1) != maxHeight) {
                answer.add(Arrays.asList(position, maxHeight));
            }
        }

        return answer;
    }

    /**
        T: O(nlogn)
        S: O(n)
     */
    private List<List<Integer>> priorityQueue(int[][] buildings) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int left = buildings[i][0], right = buildings[i][1];
            edges.add(Arrays.asList(left, i));
            edges.add(Arrays.asList(right, i));
        }
        Collections.sort(edges, (a, b) -> a.get(0) - b.get(0));

        //Priority Queue of 'live' building with an empty list of skyline key points
        Queue<List<Integer>> pq = new PriorityQueue<>((a, b) -> b.get(0) - a.get(0));

        List<List<Integer>> answer = new ArrayList<>();
        int index = 0;

        //iterate over all sorted edges
        while (index < edges.size()) {
            //we might have multiple edges at the same x, let the currX be the current position
            int currX = edges.get(index).get(0);
            while (index < edges.size() && edges.get(index).get(0) == currX) {
                int b = edges.get(index).get(1);

                if (buildings[b][0] == currX) {
                    int right = buildings[b][1];
                    int height = buildings[b][2];
                    pq.offer(Arrays.asList(height, right));
                }
                index += 1;
            }

            //If the tallest live building has passed, we move it from pq
            while (!pq.isEmpty() && pq.peek().get(1) <= currX) {
                pq.poll();
            }
            
            //Get the max height
            int currHeight = pq.isEmpty() ? 0 : pq.peek().get(0);

            //If the height changed at the current point, add to answer
            if (answer.isEmpty() || answer.get(answer.size() - 1).get(1) != currHeight) {
                answer.add(Arrays.asList(currX, currHeight));
            }
        }
        return answer;
    }
}