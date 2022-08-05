package gammaCalculator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


/**
 * A class to test the methods for gamma function.
 *
 * @author dhruvimodi
 */
class gammaFunctionTest {
    gammaFunction gammaFunction = new gammaFunction();

	/**
	 *This Method tests squareRoot Method.
	 */

	@Test
	public void testForsquareRoot() {
		double userInput = 158;
		double expected = Math.sqrt(userInput);
		double actual = gammaFunction.squareRoot(userInput);
		double percentError = ((Math.abs((actual - expected)) / (expected)) * 100);
		Assert.assertTrue(percentError < 0.000001);
	}

	/**
	 * This method tests the power function
	 */
	@Test
	public void testPower() {
		double p = gammaFunction.power(3.0, 2.0);
		assertEquals(9.0, p, 0);
	}

    /**
	 * This method tests the fractionpower function.
	 */
	@Test
	public void testfractionPower() {
		double p = gammaFunction.fractionPower(4.0, 0.5);
		assertEquals(2.0, p, 0);
	}

    /**
	 * This method tests the Gamma function with real positive integers.
	 */
	@Test
	void testGammafunctionforPositiveInteger() {
		double db = gammaFunction.stirlingFormula(142);
		assertEquals(Double.POSITIVE_INFINITY, gammaFunction.stirlingFormula(234));
		assertThrows(StackOverflowError.class, () -> {
			gammaFunction.stirlingFormula(234567);
		});
		assertEquals(1.8981437590761713E243, db);
		assertThrows(StackOverflowError.class, () -> {
			gammaFunction.stirlingFormula(0);
		});
		assertThrows(StackOverflowError.class, () -> {
			gammaFunction.stirlingFormula(-12);
		});

	}
	
    /**
	 * This method tests the Gamma function for fraction number.
	 */
	@Test
	void testGammafunctionforDecimalNumber() {
		double db = gammaFunction.stirlingFormula(21.14);
		assertEquals(3.699869886541974E18, db);
    }
	
	

    /**
	 * This function tests the positive limit for Gamma function.
	 */
	@Test
	void testPositiveLimitForGammaFunction() {
		double userInput = 175.0;
		Double actual = gammaFunction.stirlingFormula(userInput);
		assertTrue(actual.isInfinite());
    }

    /**
	 * This function tests the negative limit for Gamma Function.
	 */
	@Test
	void testNegativeLimitForGammaFunction() {
		double userInput = -170.1;
		Double actual = gammaFunction.stirlingFormula(userInput);
		assertTrue(actual.isNaN());
    }
	
	/**
	 * Main class test case method
	 */
	@Test
	void testMainmethod() {
	    System.setIn(new ByteArrayInputStream("9 y ghjk 0 -4 200 67 y 150 0".getBytes()));
	    String[] args = new String[0];
	    gammaFunction.main(args);
	    ByteArrayOutputStream actual = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(actual));
	    String[] lines = actual.toString().split(System.lineSeparator());
	    assertNotNull(lines);
    }
	 
}
