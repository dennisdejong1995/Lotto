package tests;

import static org.junit.Assert.*;
import main.Date;

import org.junit.AfterClass;
import org.junit.Test;
/** Class that tests Date.
 * 
 * @author Dennis de Jong
 * @version 04-05-2015
 */
public class TestDate {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	/** Tests the constructor and the toString method.*/
	@Test
	public void testDateAndToString() {
		Date date = new Date(12,12,2012);
		assertEquals(date.toString(),"12/12/2012");
	}
	/** Tests the equals method.*/
	@Test
	public void testEquals() {
		Date date = new Date(12,12,2012);
		Date date2 = new Date(12,12,2012);
		Date date3 = null;
		Date date4 = new Date(13,12,2012);
		Date date5 = new Date(12,11,2012);
		Date date6 = new Date(12,12,2014);
		assertTrue(date.equals(date2));
		assertFalse(date.equals(date3));
		assertFalse(date.equals(date4));
		assertFalse(date.equals(date5));
		assertFalse(date.equals(date6));
	}

}
