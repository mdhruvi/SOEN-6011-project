package GammaInteger;

import java.util.*;


public class PositiveInteger 
{
	public static void main(String[] args) {
		//int n, c, f = 1;

	    System.out.println("Enter an integer to calculate its factorial");
	    Scanner in = new Scanner(System.in);

	    int n1 = in.nextInt();
	    
	    System.out.println(fact(n1));
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
 
}
