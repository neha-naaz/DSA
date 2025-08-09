/*
There are n airports, labeled from 0 to n - 1, which are connected by some flights. You are given an array flights where 
flights[i] = [from_i, to_i, price_i] represents a one-way flight from airport from_i to airport to_i with cost price_i. 
You may assume there are no duplicate flights and no flights from an airport to itself.
You are also given three integers src, dst, and k where:

src is the starting airport
dst is the destination airport
src != dst
k is the maximum number of stops you can make (not including src and dst)
Return the cheapest price from src to dst with at most k stops, or return -1 if it is impossible.

Example 1:
Input: n = 4, flights = [[0,1,200],[1,2,100],[1,3,300],[2,3,100]], src = 0, dst = 3, k = 1
Output: 500
Explanation:
The optimal path with at most 1 stop from airport 0 to 3 is shown in red, with total cost 200 + 300 = 500.
Note that the path [0 -> 1 -> 2 -> 3] costs only 400, and thus is cheaper, but it requires 2 stops, which is more than k.

Example 2:
Input: n = 3, flights = [[1,0,100],[1,2,200],[0,2,100]], src = 1, dst = 2, k = 1
Output: 200
Explanation:
The optimal path with at most 1 stop from airport 1 to 2 is shown in red and has cost 200.

Constraints:
1 <= n <= 100
fromi != toi
1 <= pricei <= 1000
0 <= src, dst, k < n
*/
class NaiveDFS {
  // very slow
  // Time Complexity: O((n-1)^(k+1))
    Map<Integer, List<int[]>> adj;
    int finalPrice;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        adj = new HashMap<>();
        for (int[] edge : flights) {
            adj.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
        finalPrice = Integer.MAX_VALUE;
        dfs(src, dst, k + 1, 0); // k+1 means number of edges allowed
        return finalPrice == Integer.MAX_VALUE ? -1 : finalPrice;
    }

    private void dfs(int src, int dst, int stopsLeft, int price) {
        if (stopsLeft < 0) return;
        if (src == dst) {
            finalPrice = Math.min(finalPrice, price);
            return;
        }
        if (!adj.containsKey(src)) return;

        for (int[] nei : adj.get(src)) {
            if (price + nei[1] >= finalPrice) continue; // prune if already more expensive
            dfs(nei[0], dst, stopsLeft - 1, price + nei[1]);
        }
    }
}

class BFSDijkstra {
  // Time Complexity: O(m*k) m = number of flights
  // Space Complexity: O(n+m)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list: city -> list of (nextCity, cost)
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : flights) {
            adj.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        // BFS queue: {city, totalCost, stopsUsed}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});

        // Track best cost to reach each city with a certain number of stops
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        int minPrice = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int city = cur[0], cost = cur[1], stops = cur[2];

            // If we reached destination, update minPrice
            if (city == dst) {
                minPrice = Math.min(minPrice, cost);
            }

            // If stops exceed limit, skip
            if (stops > k) continue;

            // Explore neighbors
            if (adj.containsKey(city)) {
                for (int[] nei : adj.get(city)) {
                    int nextCity = nei[0], nextCost = cost + nei[1];

                    // Only push if it's cheaper than what we had before
                    if (nextCost < dist[nextCity]) {
                        dist[nextCity] = nextCost;
                        q.offer(new int[]{nextCity, nextCost, stops + 1});
                    }
                }
            }
        }

        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }
}

