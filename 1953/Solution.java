//GETTING TLE

class Solution {
    public long numberOfWeeks(int[] milestones) {
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[1], a[1]);
            }
        });

        for (int i = 0; i < milestones.length; i++) {
            maxPQ.offer(new int[] {i, milestones[i]});
        }

        List<Integer> answer = new ArrayList<>();

        while (!maxPQ.isEmpty()) {
            int cycle = 2;  //cannot work on same project two consecutive weeks 
            List<int[]> store = new ArrayList<>();

            while (cycle-- > 0 && !maxPQ.isEmpty()) {
                int[] curr = maxPQ.poll();

                //cannot work on a milestone if worked on it previously
                int size = answer.size();
                if (size > 0 && answer.get(size - 1) == curr[0]) {
                    break;
                }

                //otherwise work on it
                answer.add(curr[0]);

                //update store with updated count
                if (curr[1] > 1) {
                    store.add(new int[] {curr[0], curr[1] - 1});
                }
            }

            //re-populate maxPQ
            for (int[] item : store) {
                maxPQ.offer(item);
            }
        } 

        return (long) answer.size();
    }
}