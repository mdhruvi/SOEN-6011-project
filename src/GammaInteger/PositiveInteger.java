package GammaInteger;

import java.util.*;


public class PositiveInteger 
{
	public static void main(String[] args) {
		//int n, c, f = 1;

	    System.out.println("Enter an integer to calculate its factorial");
	    Scanner in = new Scanner(System.in);
	    

	    int n1 = in.nextInt();
	    double s = in.nextDouble();
	    
	    System.out.println(fact(n1));
	    System.out.println(squareRoot(s));
	}
	static int factTR(int n, int a)
    {
        if (n == 0)
            return a;
     
        return factTR(n - 1, n * a);
    }
	static int fact(int n)
    {
        return factTR(n - 1, 1);
    }
	
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
 
}
