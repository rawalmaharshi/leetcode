class Solutio1 {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;
        
        //precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        
        //Declare our array along with base cases
        int[] maxPoints = new int[maxNumber + 1];
        maxPoints[1] = points.getOrDefault(1, 0);
        
        for (int num = 2; num < maxPoints.length; num++) {
            //recurence relation
            int gain = points.getOrDefault(num, 0);
            maxPoints[num] = Math.max(maxPoints[num - 1], maxPoints[num - 2] + gain);
        }
        
        return maxPoints[maxNumber];
    }
}