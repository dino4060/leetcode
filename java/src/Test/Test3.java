package Test;

import java.util.function.Function;

// Maximize Pair Sum with Matching First and Last Digits:
// - Find two numbers in array A that have the same first and last digits.
// - Return the maximum sum of such a pair.
// - Return -1 if no such pair exists.
// Example:
// - A = [101, 202, 121] -> pair (101, 121) has same first and last (1 and 1). Sum = 222.
// - A = [13, 23, 33] -> no pairs with same first/last. Return -1.

public class Test3 extends BaseTest<int[], Integer> {

  @Override
  public void runTestCases(Function<int[], Integer> solutionFunc) {
    System.out.println("Starting Unit Tests for Solution3 (Functional Mode)...\n");

    test(solutionFunc.apply(null), -1, "Null input");
    test(solutionFunc.apply(new int[] {}), -1, "Empty array");
    test(solutionFunc.apply(new int[] { 101 }), -1, "Single element");

    // Khớp số đầu và cuối (1...1)
    test(solutionFunc.apply(new int[] { 101, 191 }), 292, "Standard match (101 + 191)");

    // Nhiều cặp, chọn tổng lớn nhất
    test(solutionFunc.apply(new int[] { 101, 121, 55, 505 }), 560, "Multiple pairs (55 + 505)");

    // Số âm (trị tuyệt đối)
    test(solutionFunc.apply(new int[] { -101, -121 }), -222, "Negative numbers match");

    // Không có cặp nào khớp
    test(solutionFunc.apply(new int[] { 12, 23, 34, 45 }), -1, "No matching pairs");

    // Khớp nhưng tổng không lớn hơn
    test(solutionFunc.apply(new int[] { 101, 121, 111 }), 232, "Three matching, return max pair sum");

    // Số có 1 chữ số (đầu và cuối là chính nó)
    test(solutionFunc.apply(new int[] { 7, 7, 8, 8 }), 16, "Single digit matches");

    printSummary();
  }
}