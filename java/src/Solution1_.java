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
}
