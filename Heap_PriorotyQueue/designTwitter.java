/*
Implement a simplified version of Twitter which allows users to post tweets, follow/unfollow each other, 
and view the 10 most recent tweets within their own news feed.

Users and tweets are uniquely identified by their IDs (integers).

Implement the following methods:
Twitter() Initializes the twitter object.
void postTweet(int userId, int tweetId) Publish a new tweet with ID tweetId by the user userId. You may assume that each tweetId is unique.
List<Integer> getNewsFeed(int userId) Fetches at most the 10 most recent tweet IDs in the user's news feed. Each item must be posted by users who the user is following or by the user themself. Tweets IDs should be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId follows the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId unfollows the user with ID followeeId.

Example 1:
Input:
["Twitter", "postTweet", [1, 10], "postTweet", [2, 20], "getNewsFeed", [1], "getNewsFeed", [2], "follow", [1, 2], "getNewsFeed", [1], "getNewsFeed", [2], "unfollow", [1, 2], "getNewsFeed", [1]]
Output:
[null, null, null, [10], [20], null, [20, 10], [20], null, [10]]

Explanation:
Twitter twitter = new Twitter();
twitter.postTweet(1, 10); // User 1 posts a new tweet with id = 10.
twitter.postTweet(2, 20); // User 2 posts a new tweet with id = 20.
twitter.getNewsFeed(1);   // User 1's news feed should only contain their own tweets -> [10].
twitter.getNewsFeed(2);   // User 2's news feed should only contain their own tweets -> [20].
twitter.follow(1, 2);     // User 1 follows user 2.
twitter.getNewsFeed(1);   // User 1's news feed should contain both tweets from user 1 and user 2 -> [20, 10].
twitter.getNewsFeed(2);   // User 2's news feed should still only contain their own tweets -> [20].
twitter.unfollow(1, 2);   // User 1 follows user 2.
twitter.getNewsFeed(1);   // User 1's news feed should only contain their own tweets -> [10].

Constraints:
1 <= userId, followerId, followeeId <= 100
0 <= tweetId <= 1000
*/

class designTwitter {
    private static int count;
    // userId -> set of people user follows
    Map<Integer, Set<Integer>> followMap;
    // userId -> List of pairs(count, tweetId). count to maintain recency order
    Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        // since we are using min heap we'd decrement count
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count--, tweetId});
        if (tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // since the recent tweets should contains self tweets too
        followMap.computeIfAbsent(userId, k->new HashSet<>()).add(userId);
        // for all the following of user
        for (int followeeId: followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                // get no. of tweets of the curr person user follows
                int lastIndex = tweetMap.get(followeeId).size()-1;
                int[] tweet = tweetMap.get(followeeId).get(lastIndex);
                // we store int arr of size 4 - count, tweetId, followeeId, 
                // next index(next tweet we have to get when required for this followeeId)
                pq.add(new int[]{tweet[0], tweet[1], followeeId, lastIndex});
            }
        }

        while (!pq.isEmpty() && result.size() < 10) {
            //arr of size 4 - count, tweetId, followeeId, index
            int[] curr = pq.poll();
            result.add(curr[1]);
            if (curr[3] > 0) {
                int[] tweet = tweetMap.get(curr[2]).get(curr[3]-1);
                pq.add(new int[]{tweet[0], tweet[1], curr[2], curr[3]-1});
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<Integer>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

