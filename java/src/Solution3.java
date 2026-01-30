import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public int solution(int[] A) {
        if (A == null || A.length < 2) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for (int num : A) {
            int key = this.getFirstLastNum(num);
            
            if (map.containsKey(key)) {
                maxSum = Math.max(maxSum, num + map.get(key));
            }

            if (!map.containsKey(key) || num > map.get(key)) {
                map.put(key, num);
            }
        }
         
        return maxSum;
    }

    private int getFirstLastNum(int num) {
      int last = Math.abs(num) % 10;

      int first = Math.abs(num);
      while (first >= 10) {
        first /= 10;
      }

      return first * 10 + last;
    }
}

