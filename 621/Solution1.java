class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int max = 0;

        // store freq of all tasks
        for (char task : tasks) {
            freq[task - 'A']++;
            max = Math.max(max, freq[task - 'A']);
        }

        // calculate total time needed for execution
        int time = (max - 1) * (n + 1);
        for (int currFreq : freq) {
            if (currFreq == max) {
                time++;
            }
        }

        return Math.max(tasks.length, time);
    }
}

/*
    Algorithm:
        1. Store freq of all tasks in freq array and also find max freq of any task.
        2. Minimum total time to execute all task is (maxFreq - 1) * (n + 1)
        3. Add all tasks which have freq equal to maxFreq
        4. Return max of tasks.length and time calculated

        Time Complexity: O(n)
        Space Complexity: O(1)
*/

/*
    tasks = ['A', 'A', 'A', 'B', 'B', 'B'], n = 2
    Most frequent task count: max = 3
    Base time formula: (3 - 1) * (2 + 1) = 6
    Adjusting for tasks with max frequency: time = 6 + 2 = 8
    Max between computed time and actual task length: Math.max(6, 8) = 8


    tasks = ['A', 'A', 'A', 'B', 'B', 'C', 'D', 'E', 'F', 'G'], n = 2
    Most frequent task count: max = 3
    Base time formula: (3 - 1) * (2 + 1) = 6
    Adjusting for tasks with max frequency: time = 6 + 1 = 7
    Max between computed time and actual task length: Math.max(10, 7) = 10
    Here we have enough enough distinct tasks to naturally fill the idle slots - 
    we must execute all 10 tasks
*/