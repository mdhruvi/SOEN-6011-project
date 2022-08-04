package gammaCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class calculates the Gamma Function.
 *
 * @author dhruvimodi
 */
public class gammaFunction {

  static final double PIE_VALUE = 3.141592653589793;
  static final double E_VALUE = 2.718281828459045;
  
  /**
   * Stirling's formula implementation to calculate gamma function for both
   * integer and decimal numbers.
   *
   * @param x is a input variable.
   * @return the value of Gamma Function
   */
  public double stirlingFormula(double x) {
    if (checkWholeNumber(x)) {
      return fact(x - 1);
    }
    x = x - 1;
    return squareRoot(2 * PIE_VALUE * x) * power((x / E_VALUE), x);
  }

  /**
   * This function calculates square root of the given number.
   *
   * @param input parameter to calculate square root
   * @return the answer after calculation
   */
  public static double squareRoot(double input) {
    double error = 0.00001;
    double errorPrecision = 1;
    double duplicate = input;
  
    while ((errorPrecision) > error) {
      input = (input + duplicate / input) / 2;
      errorPrecision = input - duplicate / input;
    }
    return input;
  }

  /**
   * This function calculates the value of power n to a.
   *
   * @param a is base for power function
   * @param n is exponent for power function
   * @return the value of power
   */
  static double power(double a, double n) {
    String numberstring = Double.toString(n);
    String[] numberArray = numberstring.split("\\.");
    if (Integer.parseInt(numberArray[1]) > 0) {
      return fractionPower(a, n);
    }
    if (n < 0.0) {
      a = 1.0 / a;
      n = n * -1;
      return power(a, n);
    } else if (n == 0.0) {
      return 1.0;
    } else if ((n % 2) == 0.0) {
      a = a * a;
      n = n / 2;
      return power(a, n);
    }  else {
      n = (n - 1) / 2;
      return a * power(a * a, n);
    }
  }

  /**
   * This function calculates the power function for the fraction number.
   *
   * @param a is a base for fractionPower function
   * @param n is an exponent for fractionPower function 
   * @return the calculation of the power of decimal numbers
   */
  static double fractionPower(double a, double n) {
    double answer = 0;
    double logvalue = 0;
    if (n == 0) {
      return 1;
    } 
    if (a < 0) {
      logvalue = ln(a * (-1));
    }  else  {
      logvalue = ln(a);
    } 
    if (a == 0 && n > 0) {
      return answer;
    }
    for (int i = 0; i <= 125; i++) {
      double numerator = power((n * logvalue), i);
      double denominator = fact(i);
      answer = answer + (numerator / denominator);
    }
    if (a < 0 && n % 2 != 0) {
      return answer * (-1);
    } else {
      return answer;
    }
  }

  /**
   * This function calculates the factorial of number using Tail Recursion.
   *
   * @param n is first input parameter
   * @param a is second input parameter
   * @return the calculation of recursion
   */
  static double factTailRecursion(double n, double a) {
    if (n == 0) {
      return a;
    }
    return factTailRecursion(n - 1, n * a);
  }

  /**
   * This function returns the factorial value using Tail Recursion.
   *
   * @param n is input parameter
   * @return the calculation of factorial using Tail recursion function
   */
  static double fact(double n) {
    return factTailRecursion(n, 1);
  }

  /**
   * This function returns the log value for base e.
   *
   * @param nis input parameter 
   * @return the calculation of log
   */
  static double ln(double n) {
    double answer = 0;
    double base = (n - 1) / (n + 1);
    for (int i = 1; i <= 125; i++) {
      double exponent = 2 * i - 1;
      answer += (1 / exponent) * (power(base, exponent));
    }
    return 2 * answer;
  }

  /**
   * This function returns true if the given number is whole number(Z+) otherwise
   * returns false.
   *
   * @param n is input parameter
   * @return boolean value whether the number is whole number or not
   */
  static boolean checkWholeNumber(double n) {
    if (n % 1 == 0) {
      return true;
    }
    return false;
  }

  /**
   * Driver function to take user input and returns the gamma value.
   *
   * @param args is a parameter provided by command line
   */
  public static void main(String[] args) {
  
    Scanner sc = new Scanner(System.in);
    gammaFunction gammaFunction = new gammaFunction();
    String s = " ";
    while (true) {
      try {
        double n;
        System.out.println("Calculator for Gamma Function");
        System.out.println("Enter the value of n (n>0) : ");
        n = sc.nextDouble();
  
      if (n == 0 || n < 0 || n > 171) {
        System.out.println("Infinty, please enter correct input");
        continue;
      }
      System.out.println("Gamma(n) : " + gammaFunction.stirlingFormula(n));
      System.out.println("Press 'Y' to continue\nPress 0 to exit ------");
      s = sc.next();
      if (s.equals("0")) {
      	
          break;
      }
    } catch(InputMismatchException e) {
      s = sc.next();
      System.out.println("Please enter valid input!");
     }
    }
    sc.close();
  }
}

