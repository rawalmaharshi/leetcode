class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] topologicalSort = new int[numCourses];
        int topologicalIndex = 0;
        
        //form the adjacency list
        for (int[] prereq : prerequisites) {
            int source = prereq[1];
            int destination = prereq[0];
            inDegree[destination]++;
            
            List<Integer> list = adjList.getOrDefault(source, new ArrayList<>());
            list.add(destination);
            adjList.put(source, list);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        //add nodes with in-degree 0 to the queue
        for (int i  = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            topologicalSort[topologicalIndex++] = node;
            
            if (adjList.containsKey(node)) {
                for (int neighbor : adjList.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }    
            }
        }
        
        if (topologicalIndex == numCourses) {
            return topologicalSort;
        }
        
        return new int[]{};
    }

    /* ----------- 2nd Solution ------------- */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++)    ans[i] = i;
            return ans;
        }
        
        Map<Integer, List<Integer>> graph = makeGraph(prerequisites);
        int[] status = new int[numCourses];
        boolean noCycles = true;
        
        //check cycles
        for (int i = 0; i < numCourses; i++) {
            noCycles = checkCyclic(graph, status, i);
            if (!noCycles)  {
                return new int[]{}; //impossible to finish all courses
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == false) {
                dfs(graph, visited, queue, i);
            }
        }
        
        int[] answer = new int[numCourses];
        int ansIndex = 0;
        while (!queue.isEmpty()) {
            answer[ansIndex++] = queue.poll();
        }
        return answer;
    }
    
    public void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, Queue<Integer> queue, int course) {
        //base case
        if (visited[course] == true) {
            return ;
        }
        
        List<Integer> adj = graph.get(course);
        visited[course] = true;
        if (adj != null) {
            for (int cour : adj) {
                dfs(graph, visited, queue, cour);
            }    
        }
        
        queue.offer(course);
        
        return;
    }
    
    public boolean checkCyclic(Map<Integer, List<Integer>> graph, int[] status, int currCourse) {
        if (status[currCourse] == 2) {
            return false;
        }
        
        if (status[currCourse] == 1) {
            return true;    //no cycles here; node already processed
        }
        
        status[currCourse] = 2; //set this node as processing
        List<Integer> adj = graph.get(currCourse);
        if (adj != null) {
            for (int course : adj) {
                boolean noCycle = checkCyclic(graph, status, course);
                if (!noCycle)   {
                    //cycle found
                    return noCycle;
                }
            }
        }
        status[currCourse] = 1;
        return true;
    }
    
    public Map<Integer, List<Integer>> makeGraph(int[][] pre) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prereq : pre) {
            if (map.containsKey(prereq[0])) {
                map.get(prereq[0]).add(prereq[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prereq[1]);
                map.put(prereq[0], list);
            }
        }
        return map;
    }
}