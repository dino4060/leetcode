package Test;

import java.util.function.Function;

// Given an array of integers A, 
// find the largest integer X within the array such that 
// the frequency of X (the number of times it appears in the array) is exactly equal to X. 
// If no such integer exists, return 0.

// Input: A = [3, 8, 2, 3, 3, 2]
// Số 3 xuất hiện 3 lần (Thỏa mãn).
// Số 2 xuất hiện 2 lần (Thỏa mãn).
// Số 8 xuất hiện 1 lần (Không thỏa mãn).
// Output: 3 (Vì 3 là số lớn nhất trong các số thỏa mãn {2, 3}).

public class Test1 extends BaseTest<int[], Integer> {

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