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

	private int[] numbers = new int[5];
	private String colour;
	private Date date;
	
	/** Constructor of Drawing.
	 * 
	 * @param numbers
	 * @param colour
	 * @param date
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
		String s = date.toString() + " ";
		for(int c : this.numbers) {
			s += c + ", ";
		}
		s += this.colour;
		return s;
	}
	/** Returns true if two Drawings are the same.
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Drawing) {
			Drawing t = (Drawing)obj;
			return Arrays.equals(this.numbers, t.getNumbers()) && this.colour.equals(t.getColour()) && date.equals(t.getDate());
		}
		return false;
	}
	
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
		int[] i = new int[5];
		for(int j = 0; j < 5; j++){
			i[j] = sc.nextInt();
		}
		String color = sc.next();
		Drawing d = new Drawing(i,color, date);
		return d;
	}
	public String write() {
		return this.date.toString() + " " +this.numbers[0] + " " + this.numbers[1] + " " + this.numbers[2] + " " + this.numbers[3] + " " + this.numbers[4] + " " + this.colour + "\n";
	}
}
