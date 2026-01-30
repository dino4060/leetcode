// Given an array of integers A, 
// find the largest integer X within the array such that 
// the frequency of X (the number of times it appears in the array) is exactly equal to X. 
// If no such integer exists, return 0.

// Input: A = [3, 8, 2, 3, 3, 2]
// Số 3 xuất hiện 3 lần (Thỏa mãn).
// Số 2 xuất hiện 2 lần (Thỏa mãn).
// Số 8 xuất hiện 1 lần (Không thỏa mãn).
// Output: 3 (Vì 3 là số lớn nhất trong các số thỏa mãn {2, 3}).

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
