public class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int count = 0, windowStart = 0, maxLength = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            if(arr[windowEnd]==1){
                count++;
            }
            if(windowEnd-windowStart-count+1>k){
                if(arr[windowStart++]==1){
                    count--;
                }
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }
}
