package Test;

import java.util.function.Function;

public class Solution1Test extends BaseTest<int[], Integer> {

  @Override
  public void runTestCases(Function<int[], Integer> solutionFunc) {
    System.out.println("Starting Unit Tests for Solution1_ (Functional Mode)...\n");

    test(solutionFunc.apply(null), 0, "Null input");
    test(solutionFunc.apply(new int[] {}), 0, "Empty array");
    test(solutionFunc.apply(new int[] { 1, 1, 2, 3, 3 }), 0, "No matches");
    test(solutionFunc.apply(new int[] { 1, 2, 2, 3 }), 2, "Single match (2x2)");
    test(solutionFunc.apply(new int[] { 3, 2, 3, 2, 3 }), 3, "Multiple matches (Max 3)");
    test(solutionFunc.apply(new int[] { -2, -2, 1, 1000000 }), 1, "Negative and Large values");

    printSummary();
  }
}