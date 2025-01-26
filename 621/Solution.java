class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        //Mak PQ on the frequency of tasks
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (char task : map.keySet()) {
            maxPQ.offer(map.get(task));
        }

        int time = 0;

        while (!maxPQ.isEmpty()) {
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;

            //Either the cycle finishes or there are no elements left in PQ to process
            while (cycle-- > 0 && !maxPQ.isEmpty()) {
                int currentFreq = maxPQ.poll();
                if (currentFreq > 1) {
                    store.add(currentFreq - 1);
                }
                taskCount++;
            }

            //add these elements updated frequency back into PQ
            for (int i : store) {
                maxPQ.offer(i);
            }

            //time calculated depending on whether a whole cycle was run or not
            time += (maxPQ.isEmpty() ? taskCount : n + 1);
        }

        return time;
    }
}

/*
    Algo:
    1. Create a map of tasks and their frequency
    2. Create a maxPQ on the frequency of tasks
    3. While PQ is not empty, keep processing the tasks
    4. In each cycle, process n + 1 tasks
    5. If the frequency of task is greater than 1, add it back to PQ
    6. If PQ is empty, add the number of tasks processed in this cycle to time
    7. Else add n + 1 (cycle length) to time
    8. Return time
    Time Complexity: O(nlogk), k is at max 26 (number of alphabets) --> O(n)
    Space Complexity: O(26) ~ O(1)
 */