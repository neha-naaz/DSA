/*
You are given an array of CPU tasks tasks, where tasks[i] is an uppercase english character from A to Z. You are also given an integer n.
Each CPU cycle allows the completion of a single task, and tasks may be completed in any order.
The only constraint is that identical tasks must be separated by at least n CPU cycles, to cooldown the CPU.
Return the minimum number of CPU cycles required to complete all tasks.

Example 1:
Input: tasks = ["X","X","Y","Y"], n = 2
Output: 5
Explanation: A possible sequence is: X -> Y -> idle -> X -> Y.

Example 2:
Input: tasks = ["A","A","A","B","C"], n = 3
Output: 9
Explanation: A possible sequence is: A -> B -> C -> Idle -> A -> Idle -> Idle -> Idle -> A.

Constraints:
1 <= tasks.length <= 1000
0 <= n <= 100
*/

class taskScheduler {
    public int leastInterval1(char[] tasks, int n) {
        // Time Complexity : O(n * m)
        // Space Complexity : O(n)
        
        // freq map 
        int[] count = new int[26];
        for(char ch: tasks) {
            count[ch - 'A']++;
        }

        // store freqencies in max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int ct: count) {
            if(ct > 0)pq.add(ct);
        }

        // to keep track of task and next processing time
        Queue<int[]> q = new LinkedList<>();
        int time = 0;   // result

        while (!pq.isEmpty() || !q.isEmpty()) {
            // one task is processed
            time++;

            if (!pq.isEmpty()) {
                // since we are selecting it and processing
                int newFreq = pq.poll() - 1;
                // add this task with new time to queue
                if(newFreq > 0)q.add(new int[]{newFreq, time+n});
            } else {
                // if all tasks processed and there is task in queue 
                // we can directly jump to that time as that is next time
                // to process any task
                time = q.peek()[1];
            }

            // if idle time required is complete for a task in queue
            if (!q.isEmpty() && q.peek()[1] == time) {
                pq.add(q.poll()[0]);
            }
        }
        
        return time;
    }

  public int leastInterval2(char[] tasks, int n) {
        // Time Complexity : O(n)
        // Space Complexity : O(1)

        // freq map 
        int[] count = new int[26];
        for(char ch: tasks) {
            count[ch - 'A']++;
        }

        // sort freq, takes O(26) time
        Arrays.sort(count);
        int maxFreq = count[25];
        // number of total number of idle spaces required
        // to complete processing most frequent character(single char)
        // this will give the most number of idle spaces
        int idle = (maxFreq - 1) * n;

        for (int i=24;i>=0;i--) {
            // Reduce Idle Time by Filling with Other Tasks
            idle -= Math.min(maxFreq-1, count[i]);
        }

        // add obvious time taken to extra idle time
        return Math.max(0, idle) + tasks.length;
    }
}

