class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[1], a[1]);    //Sorted on freq
            }
        });

        for (int i = 0; i < amount.length; i++) {
            //add to pq only if it requires time to add to the cup
            if (amount[i] > 0) {
                maxPQ.offer(new int[] {i, amount[i]});
            }
        }

        int time = 0;
        
        while (!maxPQ.isEmpty()) {
            int cycle = 2;  // in one cycle - can fill either 1 cup or 2 cups
            List<int[]> store = new ArrayList<>();

            while (cycle-- > 0 && !maxPQ.isEmpty()) {
                int[] curr = maxPQ.poll();
                int cup = curr[0], count = curr[1];

                if (count > 1) {
                    store.add(new int[] {cup, count - 1});
                }
            }
            //increment time after one cycle
            time++;
            maxPQ.addAll(store);
        }

        return time;
    }
}