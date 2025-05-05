package BinarySearch;

import java.util.Scanner;

/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23

Constraints:
1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
 */
public class KokoEatingBananas {
    int minEatingSpeed(int[] piles, int h) {
        int minS = 1, maxS = piles[0];
        for(int p: piles){
            if(p > maxS)maxS = p;
        }

        while(minS < maxS) {
            int mid = (minS+maxS)/2;
            int hourTaken = calcTime(piles, mid, h);

            if(hourTaken > h) {
                minS = mid+1;
            } else maxS = mid;
        }
        return minS;
    }

    private int calcTime(int[] piles, int mid, int h) {
        int time = 0;
        for(int p: piles) {
            time += p%mid == 0 ? (p/mid) : (p/mid)+1;
        }
        return time;
    }
}

class ExecuteKokoEatingBananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int t = sc.nextInt();

        KokoEatingBananas solObj = new KokoEatingBananas();
        System.out.println(solObj.minEatingSpeed(arr, t));
    }
}
