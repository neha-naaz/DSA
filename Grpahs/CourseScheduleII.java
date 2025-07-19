/*
You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.
Return a valid ordering of courses you can take to finish all courses. If there are many valid answers, return any of them. 
If it's not possible to finish all courses, return an empty array.

Example 1:
Input: numCourses = 3, prerequisites = [[1,0]]
Output: [0,1,2]
Explanation: We must ensure that course 0 is taken before course 1.

Example 2:
Input: numCourses = 3, prerequisites = [[0,1],[1,2],[2,0]]
Output: []
Explanation: It's impossible to finish all courses.

Constraints:
1 <= numCourses <= 1000
0 <= prerequisites.length <= 1000
All prerequisite pairs are unique.
*/

class CourseScheduleII {
  // Topological sort (kahn's algorithm)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] p: prerequisites) {
            indegree[p[1]]++;
            graph.get(p[0]).add(p[1]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int k = 0;
        while(!q.isEmpty()) {
            int vertex = q.poll();
            result[numCourses-k-1] = vertex;
            k++;
            for(int neighbor: graph.get(vertex)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if(k != numCourses) {
            return new int[0];
        }
        return result;
    }
}
