class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //edge case 1
        if (source == target) {
            return 0;
        }

        //Create adj list map
        //Map is from the bus stop to all the routes containing that stop
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                List<Integer> route = adjList.getOrDefault(stop, new ArrayList<>());
                route.add(i);
                adjList.put(stop, route);
            }
        }

        //edge case 2 - source is not there in any routes
        if (!adjList.containsKey(source)) {
            return -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        //Add all routes that contain the source stop into the queue to start BFS
        for (int route : adjList.get(source)) {
            queue.offer(route);
            visited.add(route);
        }

        int busCount = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                int route = queue.poll();

                //Iterate over stops in this route 
                for (int stop : routes[route]) {
                    //check if the end stop
                    if (stop == target) {
                        return busCount;
                    }

                    //Iterate over new possible bus routes
                    for (int nextRoute : adjList.get(stop)) {
                        if (!visited.contains(nextRoute)) {
                            queue.offer(nextRoute);
                            visited.add(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }

        return -1;  //Can't reach target
    }
}

/**
    Complexity Analysis

Here, M is the size of routes, and K is the maximum size of routes[i].

Time complexity: O(M^2∗K)

To store the routes for each stop we iterate over each route and for each route, we iterate over each stop, hence this step will take O(M∗K) time. In the BFS, we iterate over each route in the queue. For each route we popped, we will iterate over its stop, and for each stop, we will iterate over the connected routes in the map adjList, hence the time required will be O(M∗K∗M) or O(M^2∗K).

Space complexity: O(M⋅K)

The map adjList will store the routes for each stop. There can be M⋅K number of stops in routes in the worst case (each of the M routes can have K stops), possibly with duplicates. When represented using adjList, each of the mentioned stops appears exactly once. Therefore, adjList contains an equal number of stop-route element pairs.

 */