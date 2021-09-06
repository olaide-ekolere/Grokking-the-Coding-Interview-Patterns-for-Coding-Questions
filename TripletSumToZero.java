import java.util.ArrayList;
import java.util.*;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> pList = new ArrayList<>();
        Arrays.sort(arr);
        for(int current = 0; current < arr.length - 2; current++){
            int left = current + 1;
            int right = arr.length - 1;
            int sum = 0 - arr[current];
            while(left<right){
                int counterSum = (arr[left] + arr[right]);
                if(sum==counterSum){
                    pList.add(Arrays.asList(arr[current], arr[left], arr[right]));
                    left++;
                    right--;
                    while(left<right&&arr[left]==arr[left-1]) left++;
                    while(left<right&&arr[right]==arr[right-1]) right++;
                }
                else if(counterSum>sum){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return pList;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2});
        //[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        System.out.println(result);

        result = searchTriplets(new int[]{-5, 2, -1, -2, 3});
        //[[-5, 2, 3], [-2, -1, 3]]
        System.out.println(result);

    }
}
