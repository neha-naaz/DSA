/*
You are given a list of flight tickets tickets where tickets[i] = [from_i, to_i] represent the source airport and the destination airport.
Each from_i and to_i consists of three uppercase English letters.
Reconstruct the itinerary in order and return it.
All of the tickets belong to someone who originally departed from "JFK". 
Your objective is to reconstruct the flight path that this person took, assuming each ticket was used exactly once.
If there are multiple valid flight paths, return the lexicographically smallest one.
For example, the itinerary ["JFK", "SEA"] has a smaller lexical order than ["JFK", "SFO"].
You may assume all the tickets form at least one valid flight path.

Example 1:
Input: tickets = [["BUF","HOU"],["HOU","SEA"],["JFK","BUF"]]
Output: ["JFK","BUF","HOU","SEA"]

Example 2:
Input: tickets = [["HOU","JFK"],["SEA","JFK"],["JFK","SEA"],["JFK","HOU"]]
Output: ["JFK","HOU","JFK","SEA","JFK"]
Explanation: Another possible reconstruction is ["JFK","SEA","JFK","HOU","JFK"] but it is lexicographically larger.

Constraints:
1 <= tickets.length <= 300
from_i != to_i
*/

class ReconstructFlightPath {
     Map<String, List<String>> adj;
     List<String> result;
    // Approach: Naive Depth First Search (post order traversal)
    public List<String> findItinerary(List<List<String>> tickets) {
        // sort input
        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));

        // build adjacency list
        adj = new HashMap<>();
        for(List<String> ticket: tickets) {
            adj.putIfAbsent(ticket.get(0), new ArrayList<>());
        }
        for(List<String> ticket: tickets) {
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        result = new ArrayList<>();
        result.add("JFK"); // add src
        // +1 since edges 1 less than nodes
        if (dfs("JFK", tickets.size()+1)) { 
            return result;
        }
        return new ArrayList<>();
    }

    private boolean dfs(String node, int targetLen) {
        // travelled to all nodes
        if (result.size() == targetLen) {
            return true;
        }

        // for an intermediate path 
        if (!adj.containsKey(node)) {
            return false;
        }

        List<String> temp = new ArrayList<>(adj.get(node));
        // for all the paths from this node
        for(int i=0;i<temp.size();i++) {
            String vertex = temp.get(i);
            // remove the considered path
            adj.get(node).remove(i);
            result.add(vertex);
            if (dfs(vertex, targetLen)) return true;
            // add back if the path was not valid
            adj.get(node).add(i, vertex);
            result.remove(result.size()-1);
        }
        return false;
    }

    public List<String> findItinerary1(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dst);
        }

        List<String> res = new ArrayList<>();
        dfs(adj, "JFK", res);

        Collections.reverse(res);
        return res;
    }

    private void dfs1(Map<String, PriorityQueue<String>> adj,
                     String src, List<String> res) {
        PriorityQueue<String> queue = adj.get(src);
        while (queue != null && !queue.isEmpty()) {
            String dst = queue.poll();
            dfs(adj, dst, res);
        }
        res.add(src);
    }

    public List<String> findItinerary3(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), 
            k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        
        LinkedList<String> res = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        
        while (!stack.isEmpty()) {
            String curr = stack.peek();
            if (!adj.containsKey(curr) || adj.get(curr).isEmpty()) {
                res.addFirst(stack.pop());
            } else {
                stack.push(adj.get(curr).poll());
            }
        }
        
        return res;
    }
}

