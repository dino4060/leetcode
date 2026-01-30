import java.util.HashMap;
import java.util.Map;

class Solution1_ {
  public int solution(int[] A) {
    if (A == null || A.length == 0)
      return 0;

    // Map to count times => loop array
    Map<Integer, Integer> timesMap = new HashMap<>();

    for (int num : A) {
      int times = timesMap.getOrDefault(num, 0) + 1;
      timesMap.put(num, times);
    }

    // Find max num + num same key: loop map
    int max = 0;

    for (var entry : timesMap.entrySet()) {
      int num = entry.getKey();
      int times = entry.getValue();

      if (num != times)
        continue;

      if (times <= max)
        continue;

      max = num;
    }

    return max;
  }

  public void test() {
    System.out.println("--- Starting Coverage Test ---");

    // Case 1: Null input
    assert testCase(null, 0, "Null Input");

    // Case 2: Empty array
    assert testCase(new int[] {}, 0, "Empty Array");

    // Case 3: No matches (num != times)
    assert testCase(new int[] { 1, 1, 2, 3, 3, 3, 3 }, 0, "No Matches");

    // Case 4: Multiple matches, return max (2=2, 3=3 -> return 3)
    assert testCase(new int[] { 2, 2, 3, 3, 3 }, 3, "Multiple Matches (Max)");

    // Case 5: Match but smaller than current max (2 < 4)
    assert testCase(new int[] { 4, 4, 4, 4, 2, 2 }, 4, "Match but smaller");

    // Case 6: Negative numbers (X can't appear -X times)
    assert testCase(new int[] { -2, -2, 5 }, 0, "Negative Numbers");

    // Case 7: Single element match
    assert testCase(new int[] { 1 }, 1, "Single Element Match");

    System.out.println("--- All Tests Passed Successfully! ---");
  }

  private boolean testCase(int[] input, int expected, String desc) {
    int result = solution(input);
    if (result == expected) {
      System.out.println("[PASS] " + desc);
      return true;
    } else {
      System.out.println("[FAIL] " + desc + " | Expected: " + expected + ", Got: " + result);
      return false;
    }
  }
}
