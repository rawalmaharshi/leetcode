class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //edge case
        if (points.length <= k)
            return points;
        
        // return arraySortOnDistance(points, k);
        // return distanceArraySort(points, k);
        return pq(points, k);
    }
    
    public int[][] pq (int[][] points, int k) {
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int distanceA = distance(a[0], a[1]);
                int distanceB = distance(b[0], b[1]);
                
                if (distanceA < distanceB) {
                    return 1;
                } 
                
                if (distanceB < distanceA) {
                    return -1;
                }
                
                return 0;
            }
        });
        
        for (int[] point : points) {
            maxPQ.offer(point);
            if (maxPQ.size() > k) {
                maxPQ.poll();
            }
        }
        int[][] answer = new int[k][2];
        int ansIndex = 0;
        while(!maxPQ.isEmpty()) {
            answer[ansIndex++] = maxPQ.poll();
        }
        
        return answer;
    }
    
    
    public int[][] distanceArraySort(int[][] points, int k) {
        int[] distanceArray = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            distanceArray[i] = distance(points[i][0], points[i][1]);
        }
        
        Arrays.sort(distanceArray);
        int[][] answer = new int[k][2];
        int ansIndex = 0;
        int kthDistance = distanceArray[k];
        for (int[] point : points) {
            int distance = distance(point[0], point[1]);
            if (distance < kthDistance) {
                answer[ansIndex++] = point;
            }
        }
        
        return answer;
    }
    
    public int[][] arraySortOnDistance(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int distanceA = distance(a[0], a[1]);
                int distanceB = distance(b[0], b[1]);
                if (distanceA < distanceB)
                    return -1;
                if (distanceB < distanceA)
                    return 1;
                else
                    return 0;
            }
        });
        
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            answer[i] = points[i];
        }
        
        return answer;
    }
    
    public int distance (int x, int y) {
        return x*x + y*y;
    }
}