import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarrayProductLessThanK {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> values = new ArrayList<>();
        Arrays.sort(arr);
        for(int left = 0; left < arr.length - 1; left++){
            if(arr[left]>target) break;
            values.add(Arrays.asList(arr[left]));
            for(int right = arr.length - 1; right>left; right--){
                if(arr[right]<target) values.add(Arrays.asList(arr[right]));
                int product = arr[left] * arr[right];
                if(product<target) {
                    values.add(Arrays.asList(arr[left], arr[right]));
                    right--;
                    while (right>left) {
                        values.add(Arrays.asList(arr[right]));
                        values.add(Arrays.asList(arr[left], arr[right]));
                        right--;
                    }
                }
                else {
                    right--;
                }
            }
        }
        return values;
    }

    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[]{2, 5, 3, 10}, 30));
        //[2], [5], [2, 5], [3], [5, 3], [10]
        System.out.println(findSubarrays(new int[]{8, 2, 6, 5}, 50));
        //[8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
    }
}
