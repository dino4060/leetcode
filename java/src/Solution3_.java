import java.util.HashMap;
import java.util.Map;

class Solution3_ {

  public int solution(int[] A) {
    int maxSum = -1;

    if (A == null || A.length == 0) {
      return maxSum;
    }

    Map<Integer, Integer> maxMap = new HashMap<>();
    for (int num : A) {
      int key = this.getFirstLast(num);

      Integer prevNum = maxMap.get(key);

      if (prevNum == null) {
        maxMap.put(key, num);
        continue;
      }

      if (prevNum + num > maxSum) {
        maxSum = prevNum + num;
      }

      maxMap.put(key, Math.max(prevNum, num));
    }

    return maxSum;
  }

  private int getFirstLast(int num) {
    int newNum = Math.abs(num);

    int lastDigit = newNum % 10;

    int firstDigit = newNum;
    while (firstDigit >= 10) {
      firstDigit = firstDigit / 10;
    }

    return firstDigit * 10 + lastDigit;
  }
}
