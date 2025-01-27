class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }

        PriorityQueue<int[]> maxPQ = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for (int key : map.keySet()) {
            maxPQ.offer(new int[] {key, map.get(key)});
        }

        List<Integer> answer = new ArrayList<>();

        while (!maxPQ.isEmpty()) {
            int cycle = 2;
            List<int[]> store = new ArrayList<>();

            while (cycle-- > 0 && !maxPQ.isEmpty()) {
                int[] curr = maxPQ.poll();
                int element = curr[0], freq = curr[1];

                //add to answer
                answer.add(element);

                //add to store - to repopulate maxPQ
                if (freq > 1) {
                    store.add(new int[] {element, freq - 1});
                }
            }

            for (int[] item : store) {
                maxPQ.offer(item);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}