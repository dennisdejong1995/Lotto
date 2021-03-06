package main;


import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/** Class that stores a Lotto drawing.
 * 
 * @author Dennis de Jong
 * @version 04-05-2015
 */
public class Drawing {

	private int[] numbers = new int[6];
	private String colour;
	private Date date;
	
	/** Constructor of Drawing.
	 * 
	 * @param numbers The numbers of a Drawing.
	 * @param colour The colour of a Drawing.
	 * @param date	The date of the Drawing.
	 */
	public Drawing(int[] numbers, String colour, Date date) {
		this.numbers = numbers;
		this.colour = colour;
		this.date = date;
	}
	/** Returns numbers.
	 * 
	 * @return int[]
	 */
	public int[] getNumbers() {
		return numbers;
	}
	/** Returns date.
	 * 
	 * @return Date
	 */
	public Date getDate() {
		return date;
	}
	/** Returns colour.
	 * 
	 * @return String
	 */
	public String getColour() {
		return colour;
	}
	/** Returns a Drawing as a String.
	 * 
	 * @return String
	 */
	public String toString() {
		String s = date.toString() + ", ";
		for(int c : this.numbers) {
			s += c + ", ";
		}
		s += this.colour;
		return s;
	}
	/** Returns true if two Drawings are the same.
	 * 
	 * @param obj An Object that is compared with this Drawing if the Object is a Drawing
	 * @return boolean
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Drawing) {
			Drawing t = (Drawing)obj;
			return Arrays.equals(this.numbers, t.getNumbers()) && this.colour.equals(t.getColour()) && date.equals(t.getDate());
		}
		return false;
	}
	/** Reads a Drawing from a txt file and returns it.
	 * 
	 * @param sc Scanner scanning a string to read in the drawing.
	 * @return Drawing 
	 */
	public static Drawing read(Scanner sc){
		
		String sdate = sc.next();
		Scanner sca = new Scanner(sdate);
		Pattern p = sca.delimiter();
		sca.useDelimiter("/");
		int day = sca.nextInt();
		int month = sca.nextInt();
		int year = sca.nextInt();
		sca.useDelimiter(p);
		sca.close();
		Date date = new Date(day, month, year);
		int[] i = new int[6];
		for(int j = 0; j < 6; j++){
			i[j] = sc.nextInt();
		}
		String color = sc.next();
		Drawing d = new Drawing(i,color, date);
		return d;
	}
	/** Returns a Drawing as a String to be written.
	 * 
	 * @return String 
	 */
	public String write() {
		return this.date.toString() + " " +this.numbers[0] + " " + this.numbers[1] + " " + this.numbers[2] + " " + this.numbers[3] + " " + this.numbers[4] + " " + this.numbers[5] + " " + this.colour + "\n";
	}
}
