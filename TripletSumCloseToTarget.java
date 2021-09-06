import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int closestGap = Integer.MAX_VALUE;
        int closest = 0;
        for(int current = 0; current < arr.length-2; current++){
            int left = current + 1;
            int right = arr.length - 1;
            while(left<right){
                int sum = arr[current] + arr[left] + arr[right];
                if(sum==targetSum){
                    return sum;
                }
                int difference = targetSum - sum;
                if(Math.abs(difference)<Math.abs(closestGap)){
                    closestGap = difference;
                    closest = sum;
                }
                if(difference>0){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[] {-2, 0, 1, 2}, 2));//1
        System.out.println(searchTriplet(new int[] {-3, -1, 1, 2}, 1));//0
        System.out.println(searchTriplet(new int[] {1, 0, 1, 1}, 100));//3
    }
}
