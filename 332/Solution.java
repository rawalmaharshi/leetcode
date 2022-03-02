class Solution {
    LinkedList<String> itenary = new LinkedList<String>();
    public List<String> findItinerary(List<List<String>> tickets) {
        //edge case
        if (tickets.size() == 0) {
            return itenary;
        }
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!map.containsKey(from)) {
                PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> a.compareTo(b));
                pq.offer(to);
                map.put(from, pq);
            } else {
                map.get(from).offer(to); 
            }
        }
        
        dfs("JFK", map);
        return itenary;
    }
    
    public void dfs(String departure, Map<String, PriorityQueue<String>> graph) {
        //base case
        if (graph.containsKey(departure)) {
            while (!graph.get(departure).isEmpty()) {
                String arrival = graph.get(departure).poll();
                dfs(arrival, graph);
            }
        }
        
        itenary.offerFirst(departure);
        
        return ;
    }
}