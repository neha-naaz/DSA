/*
The median is the middle value in a sorted list of integers. For lists of even length, t
here is no middle value, so the median is the mean of the two middle values.

For example:
For arr = [1,2,3], the median is 2.
For arr = [1,2], the median is (1 + 2) / 2 = 1.5
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far.
Example 1:

Input:
["MedianFinder", "addNum", "1", "findMedian", "addNum", "3" "findMedian", "addNum", "2", "findMedian"]

Output:
[null, null, 1.0, null, 2.0, null, 2.0]

Explanation:
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.findMedian(); // return 1.0
medianFinder.addNum(3);    // arr = [1, 3]
medianFinder.findMedian(); // return 2.0
medianFinder.addNum(2);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0

Constraints:
-100,000 <= num <= 100,000
findMedian will only be called after adding at least one integer to the data structure.
*/
class findMedianFromDataStream {
    PriorityQueue<Integer> leftPq;
    PriorityQueue<Integer> rightPq;
    public MedianFinder() {
        leftPq = new PriorityQueue<>(Collections.reverseOrder());
        rightPq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        leftPq.add(num);

        if (leftPq.size() - rightPq.size() > 1 || 
        !rightPq.isEmpty() && leftPq.peek() > rightPq.peek()) {
                rightPq.add(leftPq.poll());
        } 
        
        if (rightPq.size() - leftPq.size() > 1) {
            leftPq.add(rightPq.poll());
        }
    }
    
    public double findMedian() {
        int left = leftPq.size(), right = rightPq.size();
        if (left == right ) {
            return (double)(leftPq.peek()+rightPq.peek())/2;
        } else if (left > right) {
            return (double)(leftPq.peek());
        } else {
            return (double)(rightPq.peek());
        }
    }
}
