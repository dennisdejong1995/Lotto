package tests;

import static org.junit.Assert.*;

import java.util.Scanner;

import main.Date;
import main.Drawing;

import org.junit.AfterClass;
import org.junit.Test;
/** Class that tests Drawing.
 * 
 * @author Dennis de Jong
 * @version 04-05-2015
 */
public class TestDrawing {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/**Tests the constructor.*/
	@Test
	public void testDrawingAndToString() {
		int[] i = new int[]{1,2,3,4,5};
		Date d = new Date(21,12,2012);
		Drawing t = new Drawing(i,"blauw", d);
		assertEquals(t.toString(),"21/12/2012 1, 2, 3, 4, 5, blauw");
	}
	
	/**Tests the equals method.*/
	@Test
	public void testEquals() {
		int[] i = {1,2,3,4,5};
		int[] j = {1,2,3,4,5};
		Date d = new Date(21,12,2012);
		Drawing t = new Drawing(i,"blauw",d);
		Drawing t2 = new Drawing(j,"blauw",d);
		Drawing t3 = new Drawing(i,"rood",d);
		Drawing t4 = new Drawing(null,"blauw",d);
		assertTrue(t.equals(t2));
		assertFalse(t.equals(t3));
		assertFalse(t.equals(t4));
	}
	/**Tests the read method.*/
	@Test
	public void testRead() {
		int[] i = new int[]{1,2,3,4,5};
		Date date = new Date(12,12,2012);
		String s = "12/12/2012 1 2 3 4 5 blauw";
		Scanner sc = new Scanner(s);
		Drawing d = Drawing.read(sc);
		Drawing d2 = new Drawing(i,"blauw",date);
		assertTrue(d.equals(d2));
	}
	/**Tests the write method.*/
	@Test
	public void testWrite() {
		int[] i = new int[]{1,2,3,4,5};
		Date d = new Date(21,12,2012);
		Drawing t = new Drawing(i,"blauw", d);
		assertEquals(t.write(),"21/12/2012 1 2 3 4 5 blauw\n");
	}

}
