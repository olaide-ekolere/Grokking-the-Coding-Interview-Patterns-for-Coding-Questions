import java.util.Arrays;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        //[-1, 1, 2, 3, 4] target = 5, 4
        for(int current = 0; current < arr.length - 2; current++){
            int left = current + 1, right = arr.length-1,
            targetSum = target - arr[current];
            while(left<right){
                int sum = arr[left] + arr[right];
                if(sum<targetSum){
                    count+=right-left;
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-1, 0, 2, 3}, 3)); //2 [-1, 0, 3], [-1, 0, 2]
        System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5)); //4 [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
    }
}
