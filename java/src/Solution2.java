import java.util.HashSet;
import java.util.Set;

class Solution2 {
  public boolean solution(String S) {
    if (S == null || S.length() != 11) {
      return false;
    }

    Set<Character> digits = new HashSet<>();
    for (char c = '0'; c <= '9'; c++) {
      digits.add(c);
    }

    for (int i = 0; i < S.length(); i++) {
      char currentChar = S.charAt(i);

      if (i == 3 || i == 7) {
        if (currentChar != '-') {
          return false;
        }
      } else {
        if (!digits.contains(currentChar)) {
          return false;
        }
      }
    }

    return true;
  }
}
