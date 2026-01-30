package Test;

import java.util.function.Function;

public abstract class BaseTest<T, R> {
  protected int passed = 0;
  protected int total = 0;

  protected boolean test(R actual, R expected, String description) {
    total++;
    if ((actual == null && expected == null) || (actual != null && actual.equals(expected))) {
      System.out.println("[PASS] " + description);
      passed++;
      return true;
    } else {
      System.out.println("[FAIL] " + description + " (Expected " + expected + " but got " + actual + ")");
      return false;
    }
  }

  public abstract void runTestCases(Function<T, R> solutionFunc);

  protected void printSummary() {
    System.out.println("Passed: " + passed + "/" + total + " cases.");
  }
}