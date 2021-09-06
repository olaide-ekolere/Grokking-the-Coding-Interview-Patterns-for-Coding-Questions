public class RemoveDuplicates {
    public static int remove(int[] arr) {
        int left = 0,  right = 0;
        while(right<arr.length){
            if(arr[left]!=arr[right]){
                arr[++left] = arr[right];
            }
            right++;
        }
        return left + 1;
    }
}
