package Test;

import java.util.function.Function;

// Validate string format :
// - The string must have a total length of exactly 11 characters.
// - It must consist of 3 segments of digits,separated by dashes(-).
// - Each segment must contain exactly 3 numeric digits(0-9).
// Return
// - True if valid
// - False if invalid
// Example
// - "123-456-789" return true
// - "123#a56 789" return false

public class Test2 extends BaseTest<String, Boolean> {

  @Override
  public void runTestCases(Function<String, Boolean> solutionFunc) {
    System.out.println("Starting Unit Tests for Solution1_ (Functional Mode)...\n");

    test(solutionFunc.apply(null), false, "Null input");
    test(solutionFunc.apply("123-456-789"), true, "Valid");

    // Sai độ dài
    test(solutionFunc.apply("123-456-78"), false, "Length too short");
    test(solutionFunc.apply("123-456-7890"), false, "Length too long");

    // Sai vị trí dấu gạch
    test(solutionFunc.apply("12-3456-789"), false, "Wrong dash position");

    // Có ký tự lạ
    test(solutionFunc.apply("123a456-789"), false, "Contains letter");
    test(solutionFunc.apply("123-45b-789"), false, "Contains letter");
    test(solutionFunc.apply("123 457 789"), false, "Contains letter");

    // Toàn số không có gạch
    test(solutionFunc.apply("12345678901"), false, "All digits no dash");

    printSummary();
  }
}