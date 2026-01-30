import java.util.HashMap;
import java.util.Map;

class Solution1__ {
  public int solution(int[] A) {
    if (A == null || A.length == 0)
      return 0;

    // Map to count times: loop array
    Map<Integer, Integer> timesMap = new HashMap<>();

    for (int num : A) {
      int times = timesMap.getOrDefault(num, 0) + 1;
      timesMap.put(num, times);
    }

    // Find max num + num same key: loop map
    int max = timesMap.entrySet().stream()
        .filter(e -> e.getKey().equals(e.getValue()))
        .mapToInt(e -> e.getKey())
        .max()
        .orElse(0);

    return max;
  }
}
