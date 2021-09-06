class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
      int max = Integer.MIN_VALUE;
      int windowStart = 0;
      int sum = 0;
      for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
          sum += arr[windowEnd];
          if(windowEnd-windowStart==k-1){
              max = Math.max(max, sum);
              sum -= arr[windowStart++];
          }
      }
      return max;
    }
  }