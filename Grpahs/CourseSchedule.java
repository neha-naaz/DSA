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
}
