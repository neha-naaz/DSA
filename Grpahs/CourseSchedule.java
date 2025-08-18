/*
You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.
The pair [0, 1], indicates that must take course 1 before taking course 0.
There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.
Return true if it is possible to finish all courses, otherwise return false.

Example 1:
Input: numCourses = 2, prerequisites = [[0,1]]
Output: true
Explanation: First take course 1 (no prerequisites) and then take course 0.

Example 2:
Input: numCourses = 2, prerequisites = [[0,1],[1,0]]
Output: false
Explanation: In order to take course 1 you must take course 0, and to take course 0 you must take course 1. So it is impossible.

Constraints:
1 <= numCourses <= 1000
0 <= prerequisites.length <= 1000
All prerequisite pairs are unique.
*/

class CourseSchedule {
    // DFS-based cycle detection: using coloring system
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] pre : prerequisites)
            graph.get(pre[0]).add(pre[1]);

        int[] state = new int[numCourses];  // 0=unvisited, 1=visiting, 2=visited

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, state, i))
                return false;
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] state, int node) {
        if (state[node] == 1) return true;   // cycle
        if (state[node] == 2) return false;  // already checked

        state[node] = 1; // mark as visiting

        for (int neighbor : graph.get(node)) {
            if (hasCycle(graph, state, neighbor))
                return true;
        }

        state[node] = 2; // done visiting
        return false;
    }

    public boolean canFinishTopologicalSort(int numCourses, int[][] prerequisites) {
        // adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int[] edge: prerequisites) {
            indegree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int finish = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            finish++;
            for (int nei: adj.get(curr)) {
                indegree[nei]--;
                // next course to be taken
                if (indegree[nei] == 0) q.add(nei);
            }
        }
        return finish == numCourses;
    }
}

class DFSCycleDetection {
    List<List<Integer>> adj;
    Set<Integer> visited;   // fully processed nodes

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        visited = new HashSet<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        Set<Integer> recStack = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!noCycle(i, recStack)) return false;
        }
        return true;
    }

    private boolean noCycle(int v, Set<Integer> recStack) {
        if (recStack.contains(v)) return false;  // cycle detected
        if (visited.contains(v)) return true;    // already processed, no cycle
        
        recStack.add(v);
        for (int e : adj.get(v)) {
            if (!dfs(e, recStack)) return false;
        }
        recStack.remove(v);
        visited.add(v);
        return true;
    }
}

