package GammaCalculator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GammaFunctionTest
{
GammaFunction gammaFunction = new GammaFunction();


	/**
	 * This Method tests squareRoot Method.
	 */
	
	@Test
	  public void testForsquareRoot() 
	{
	    double userInput = 158;
	    double expected = Math.sqrt(userInput);
	    double actual = GammaFunction.squareRoot(userInput);
	    double percentError = ((Math.abs((actual - expected)) / (expected)) * 100);
	    Assert.assertTrue(percentError < 0.000001);
	  }
	
	@Test
	public void testPower()
	{
		double p = gammaFunction.power(3.0, 2.0);
		assertEquals(9.0, p , 0);
	}
	@Test
	public void testfractionPower()
	{
		double p = gammaFunction.power(4.0, 0.5);
		assertEquals(2.0, p , 0);
	}
	
	@Test
	void testGammafunctionforPositiveInteger() {
		double db = gammaFunction.stirlingFormula(142);
		assertEquals(Double.POSITIVE_INFINITY, gammaFunction.stirlingFormula(234));
		assertThrows(StackOverflowError.class, () -> {gammaFunction.stirlingFormula(234567);});
		assertEquals(1.8981437590761713E243 , db);
		assertThrows(StackOverflowError.class, () -> {gammaFunction.stirlingFormula(0);});
		assertThrows(StackOverflowError.class, () -> {gammaFunction.stirlingFormula(-12);});
		//		assertNotEquals(719.22, 720.0);
	}
	
	@Test
	void testGammafunctionforDecimalNumber() {
		double db = gammaFunction.stirlingFormula(21.14);
		assertEquals(3.699869886541974E18,db);
	}
	
	//@Test
	//void testGammafunctionwithNegativeNumber

	@Test
	 void testPositiveLimitForGammaFunction() {
	    double userInput = 175.0;
	    Double actual = gammaFunction.stirlingFormula(userInput);
	    assertTrue(actual.isInfinite());	
	  }
	
	@Test
	  void testNegativeLimitForGammaFunction() {
	    double userInput = -170.1;
	    Double actual = gammaFunction.stirlingFormula(userInput);
	    assertTrue(actual.isNaN());
	  }

}
