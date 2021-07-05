import java.util.*;

public class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int windowSum = 0;
    int windowStart = 0;
    int total = Integer.MIN_VALUE;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];
      if (windowEnd >= k - 1) {
        if (windowSum > total) {
          total = windowSum;
        }
        windowSum -= arr[windowStart]; 
        windowStart++;
      }
    }

    return total;
  }

  public static void main(String[] args) {
    int result = findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2});
    System.out.println("Maximum sum of a subarray of size K : " + result);
    result = findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5});
    System.out.println("Maximum sum of a subarray of size K : " + result);
  }
}