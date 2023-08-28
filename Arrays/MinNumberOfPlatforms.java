package Arrays;
/*
You have been given to arrays AT and DT representing the arrival and departure times of all the trains that reach
railway station. Your task is to find the new number of platform required for the railway station so that no train
needs to wait

Sample input 1:
2
6
900 940 950 1100 1500 1800
910 1200 1120 1130 1900 2000
4
100 200 300 400
200 300 400 500
Output:
3
2
Explanation:
In test case 1, For the given input, the following will be the schedule of the trains:

Train 1 arrived at 900 on platform 1.
Train 1 departed at 910 from platform 1.
Train 2 arrived at 940 on platform 1.
Train 3 arrived at 950 on platform 2 (since platform 1 was already occupied by train 1).
Train 4 arrived at 1100 on platform 3 (since both platforms 1 and 2 were occupied by trains 2 and 3 respectively).
Train 3 departed at 1120 from platform 2 (platform 2 becomes vacant).
Train 4 departed at 1130 from platform 3 (platform 3 also becomes vacant).
Train 2 departed at 1200 from platform 1 (platform 1 also becomes vacant).
Train 5 arrived at 1500 on platform 1.
Train 6 arrived at 1800 on platform 2.
Train 5 departed at 1900 from platform 1.
Train 6 departed at 2000 from platform 2.

Thus, minimum 3 platforms are needed for the given input.

In test case 2, For the given input, the following will be the schedule of the trains:

Train 1 arrived at 100 on platform 1.
Train 2 arrived at 200 from platform 2 (as platform 1 is occupied by train 1).
Train 1 departed at 200 from platform 1.
Train 3 arrived at 300 on platform 1.
Train 2 departed at 300 from platform 2.
Train 4 arrived at 400 on platform 2.
Train 3 departed at 400 from platform 1.
Train 4 departed at 500 from platform 2.

Thus, 2 platforms are needed for the given input.

Sample input 2:
2
2
900 1000
999 1100
3
1200 1300 1450
1310 1440 1600
Output:
1
2
Explanation:
In test case 1, For the given input, the following will be the schedule of the trains:

Train 1 arrived at 900 on platform 1.
Train 1 departed at 999 from platform 1.
Train 2 arrived at 1000 on platform 1.
Train 2 arrived at 1100 on platform 1.

Thus, only 1 platform is needed for the given input.

In test case 2, For the given input, the following will be the schedule of the trains:

Train 1 arrived at 1200 on platform 1.
Train 2 arrived at 1300 on platform 2. (since platform 1 was already occupied by train 1).
Train 1 departed at 1310 from platform 1.
Train 2 departed at 1440 from platform 2.
Train 3 arrived at 1450 on platform 1.
Train 3 departed at 1600 on platform 1.

Thus, minimum 2 platforms are needed for the given input.
 */
    /*
    Time Complexity : O(N)
    Space Complexity : O(1)

    Where 'N' is the number of trains.
*/

import java.util.Arrays;

class MinNumberOfPlatforms {
    static int calculateMinPatforms(int at[], int dt[], int n) {
        // Array to store the number of platforms required at different points of time.
        int platforms[] = new int[2361];
        Arrays.fill(platforms, 0);

        // Variable to store the final answer i.e. minimum number of platforms required.
        int minNumOfPlatforms = 1;

        for (int i = 0; i < n; i++) {

            // Increment the count of platforms at the time of arrival.
            ++platforms[at[i]];

            // Decrease the platform count just after the departure.
            --platforms[dt[i] + 1];
        }

        // We are running loop till 2361 because maximum time value in a day can be 23:60.
        for (int i = 1; i < 2361; i++) {

            // Taking cumulative sum of platforms.
            platforms[i] = platforms[i] + platforms[i - 1];

            // Update minNumOfPlatforms.
            minNumOfPlatforms = Math.max(minNumOfPlatforms, platforms[i]);
        }

        // Return the minimum number of platforms.
        return minNumOfPlatforms;
    }

}
