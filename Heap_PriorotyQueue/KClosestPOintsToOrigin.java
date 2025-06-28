/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, r
eturn the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Example 1:
Input: points = [[1,3],[-2,2]], k = 1

Output: [[-2,2]]

Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], k = 2

Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 
Constraints:
1 <= k <= points.length <= 104
-104 <= xi, yi <= 104
*/

// Time - O(nlogk) where n is the number of points O(logk) to add in the heap
// Space - O(k)
class KClosestPOintsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> customComp = (a, b) -> {
            double dist1 = Math.sqrt((a[0]*a[0])+(a[1]*a[1]));
            double dist2 = Math.sqrt((b[0]*b[0])+(b[1]*b[1]));
          // constructs max heap
            return Double.compare(dist2, dist1);
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(customComp);
        for(int[] point: points) {
            pq.offer(point);
          // if size exceeds k 
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int j=0;
        while(pq.size() > 0) {
            result[j++] = pq.poll();
        }

        return result;
    }
}
