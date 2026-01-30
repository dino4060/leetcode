import java.util.HashMap;
import java.util.Map;

class Solution1___ {
  public int solution(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    Map<Integer, Integer> timesMap = new HashMap<>();

    for (int num : A) {
      int times = timesMap.getOrDefault(num, 0) + 1;
      timesMap.put(num, times);
    }

    int maxTimes = 0;
    for (var timesEntry : timesMap.entrySet()) {
      int num = timesEntry.getKey();
      int times = timesEntry.getValue();

      if (num == times) {
        maxTimes = Math.max(maxTimes, times);
      }
    }

    return maxTimes;
  }
}
