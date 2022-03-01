class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //edge case
        if (prerequisites.length == 0) {
            return true;    //no prerequisites, can do any course
        }
        
        Map<Integer, List<Integer>> graph = makeGraph(prerequisites);
        int[] status = new int[numCourses];
        boolean noCycles = true;
        for(int[] prereq : prerequisites) {
            noCycles = checkCyclic(graph, status, prereq[0]);
            if (!noCycles)  {
                break;
            }
        }
        return noCycles;
        // return canFinishTopSort(numCourses, prerequisites);
    }
    
    public boolean checkCyclic(Map<Integer, List<Integer>> graph, int[] status, int course) {
        /*
            0 -> Initial State
            1 -> Processed
            2 -> Processing
        */
        // for (int i = 0; i < status.length; i++) System.out.println(i + " " + status[i] + " ");
        if (status[course] == 2) {
            return false;
        }
        
        if (status[course] == 1) {
            return true;    //no cycles here; node already processed
        }
        
        status[course] = 2; //set this node as processing
        List<Integer> adj = graph.get(course);
        if (adj != null) {
            for (int currCourse : adj) {
                boolean noCycle = checkCyclic(graph, status, currCourse);
                if (!noCycle)   {
                    //cycle found
                    return noCycle;
                }
            }
        }
        status[course] = 1;
        return true;
    }
    
    public Map<Integer, List<Integer>> makeGraph(int[][] pre) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prereq : pre) {
            if (graph.containsKey(prereq[0])) {
                graph.get(prereq[0]).add(prereq[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prereq[1]);
                graph.put(prereq[0], list);
            }
        }
        
        return graph;
    }
    
    public boolean canFinishTopSort(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Boolean> seen = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        // Building the graph
        for(int[] courses : prerequisites) {
            int to = courses[0];
            int from = courses[1];
            var list = map.getOrDefault(from, new ArrayList<>());
            list.add(to);
            map.put(from, list);
            indegree[to]++;
        }
        
        // Implementation of Kahn's Alg
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            count++;
            if(map.containsKey(node)) {
                for(int nei : map.get(node)) {
                    indegree[nei]--;
                    if(indegree[nei] == 0) {
                        q.add(nei);
                    }
                }
            }
        }
        return count == numCourses;
    }
}