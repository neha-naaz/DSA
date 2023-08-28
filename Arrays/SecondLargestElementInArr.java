package Arrays;

import java.util.*;
public class SecondLargestElementInArr {
    public static int findSecondLargest(int n, int[] arr) {
        int first_max = Integer.MIN_VALUE, second_max = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i] > first_max){
                second_max = first_max;
                first_max = arr[i];
            }
            else if(arr[i] != first_max && arr[i] > second_max){
                second_max = arr[i];
            }
        }
        if(second_max == Integer.MIN_VALUE)return -1;
        return second_max;
    }
}
