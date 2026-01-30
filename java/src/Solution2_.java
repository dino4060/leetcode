import java.util.Set;

class Solution2_ {
  private static final Set<Character> digits = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
  private static final char connect = '-';

  public boolean solution(String S) {
    var failure = false;
    if (S == null || S.length() != 11)
      return failure;

    var localIndex = 0;

    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);

      var isEndSegment = localIndex != 0 && localIndex % 3 == 0;

      if (isEndSegment) {
        if (ch != connect)
          return failure;

        localIndex = 0;
      } else {
        if (!digits.contains(ch))
          return failure;

        localIndex++;
      }

    }

    return true;
  }
}
