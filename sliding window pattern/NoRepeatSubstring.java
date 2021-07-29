import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> charIndexMap = new HashMap<>();
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (charIndexMap.containsKey(rightChar)) {
        windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
      }
      charIndexMap.put(rightChar, windowEnd);
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("smallest thing"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("biggest thing"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("king in the north"));
  }
}
