import java.util.*;

public class MaxFruitCountOfNTypes {
  public static int findLength(char[] arr, int N) {
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
      while (fruitFrequencyMap.size() > N) {
        fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
        if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
          fruitFrequencyMap.remove(arr[windowStart]);
        }
        windowStart++; 
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println("Maximum number of fruits: " + findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }, 2));
    System.out.println("Maximum number of fruits: " + findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }, 2));
  }
}

