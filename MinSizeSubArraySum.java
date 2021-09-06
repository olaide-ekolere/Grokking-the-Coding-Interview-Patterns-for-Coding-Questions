public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
      int min = Integer.MAX_VALUE, maxSum = 0;
      int windowStart = 0;
      for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
          maxSum += arr[windowEnd];
          while(maxSum>=S){
              min = Math.min(min, (windowEnd-windowStart) + 1);
              maxSum -= arr[windowStart++];
          }
      }
      return min;
    }
}
