class MedianFinder {
    Queue<Integer> minPQ;
    Queue<Integer> maxPQ;

    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        //Add to maxPQ
        maxPQ.offer(num);

        //Balance
        minPQ.offer(maxPQ.poll());
        
        //Maintain size property
        if (maxPQ.size() < minPQ.size()) {
            maxPQ.offer(minPQ.poll());
        }
    }
    
    public double findMedian() {
        return maxPQ.size() > minPQ.size() ? maxPQ.peek() : ((double) maxPQ.peek() + minPQ.peek())/2 ;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */