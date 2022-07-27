package GammaInteger;

import java.util.Scanner;

public class GammaFunction 
{
	
	static final double PIE_VALUE = 3.141592653589793;
	static final double E_VALUE = 2.718281828459045;
	
	public double st_gamma(double x){
		return squareRoot(2*PIE_VALUE/x)*Math.pow((x/E_VALUE), x);
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
	
	public static void main(String[] args) {
		System.out.println("Enter an integer to calculate its factorial");
	    Scanner in = new Scanner(System.in);

	    double n1 = in.nextDouble();
	    
	    GammaFunction test = new GammaFunction();
	    
	    System.out.println(test.st_gamma(n1));
	}
}
