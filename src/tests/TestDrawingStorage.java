package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import main.*;

import org.junit.AfterClass;
import org.junit.Test;
/** Class that tests DrawingStorage
 * 
 * @author Dennis de Jong
 * @version 04-05-2014
 */
public class TestDrawingStorage {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	/** Tests if the add method correctly adds a Drawing to the Drawing ArrayList*/
	@Test
	public void testAdd() {
		DrawingStorage ds = new DrawingStorage();
		int[] i = new int[]{1,2,3,4,5};
		Date d = new Date(21,12,2012);
		Drawing t = new Drawing(i,"blauw", d);
		assertFalse(ds.getdList().contains(t));
		ds.AddDrawing(t);
		assertTrue(ds.getdList().contains(t));
	}
	/** Tests if the toString method outputs the String in the right format*/
	@Test
	public void testToString() {
		DrawingStorage ds = new DrawingStorage();
		int[] i = new int[]{1,2,3,4,5};
		Date d = new Date(21,12,2012);
		Date d2 = new Date(21,12,2014);
		Drawing t = new Drawing(i,"blauw", d);
		Drawing t2 = new Drawing(i,"blauw", d2);
		ds.AddDrawing(t);
		ds.AddDrawing(t2);
		assertEquals(ds.toString(),"21/12/2012, 1, 2, 3, 4, 5, blauw\n21/12/2014, 1, 2, 3, 4, 5, blauw\n");
		
	}
	/** Tests if the read method, reads a txt file correctly.
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testRead() throws FileNotFoundException {
		DrawingStorage ds = DrawingStorage.read("TestFile");
		int[] i = new int[]{1,3,5,6,8};
		int[] i2 = new int[]{34,34,23,1,38};
		int[] i3 = new int[]{1,2,3,4,5};
		Date d3 = new Date(21,12,2012);
		Drawing t3 = new Drawing(i3,"blauw", d3);
		Date d = new Date(12,9,2012);
		Date d2 = new Date(12,12,2012);
		Drawing t = new Drawing(i,"blauw", d);
		Drawing t2 = new Drawing(i2,"rood", d2);
		assertTrue(ds.getdList().contains(t));
		assertTrue(ds.getdList().contains(t2));
		assertFalse(ds.getdList().contains(t3));
	}

}
