package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/** Class that runs the menu of the program.
 * 
 * @author Dennis de Jong
 * @version 04-05-2015
 */
public class Menu {
	private static int p = 1;
	private static int minYear = 2013;
	private static int maxYear = 2015;
	static Scanner sc = new Scanner(System.in);
	/** Main of the program.
	 * 
	 * @param args 
	 * @throws IOException Gets the IOException from the menu method.
	 */
	public static void main(String[] args) throws IOException{
		while(p == 1){
			menu();
		}
	}
	/** Method that runs the menu.
	 * 
	 * @throws IOException Throws an IOException if there is a problem with one of the files in one of the methods it calls.
	 */
	public static void menu() throws IOException{
		System.out.println("Select an option:");
		System.out.println("1) Add a drawing.");
		System.out.println("2) Print the list of drawings.");
		System.out.println("3) Edit a drawing.");
		System.out.println("4) Delete a drawing.");
		System.out.println("5) Close the program.");
		int choice = sc.nextInt();
		if(choice == 1) {
			addDrawing();
		}
		if(choice == 2) {
			printList();
		}
		if(choice == 3) {
			editList();
		}
		if(choice == 4) {
			removeDrawing();
		}
		if(choice == 5) {
			closeProgram();
		}
		if(choice<1 || choice>5){
			System.out.println("Not a correct choice.");
		}
	}
	/** Method to close the program*/
	public static void closeProgram() {
		p = 0;
		System.out.println("Program is closed.");
	}
	
	/** Method that removes a Drawing according to the given Date.
	 * 
	 * @throws FileNotFoundException Throws a FileNotFoundException if the given file doesn't excist.
	 */
	public static void removeDrawing() throws FileNotFoundException{
		DrawingStorage ds = DrawingStorage.read("Input");
		Drawing d = null;
		System.out.println("Enter the date of the drawing you want to remove.");
		Date date = dateIn();
		for(Drawing dr : ds.getdList()) {
			if(dr.getDate().equals(date)) {
				d = dr;
			}
		}
		if(d == null) {
			System.out.println("Drawing not found.");
			return;
		}
		System.out.println("The drawing from "+date.toString()+" is removed.");
		ds.removeDrawing(d);
		ds.write("Input");
	}
	/** Method that prints the list of Drawings in the txt file.
	 * 
	 * @throws IOException Throws an IOException if the given file is not correct.
	 */
	public static void printList() throws IOException{
		DrawingStorage ds = DrawingStorage.read("input");
		System.out.println(ds.toString());
	}
	/** Method that lets the user edit a Drawing in the txt file
	 * 
	 * @throws FileNotFoundException Throws a FileNotFoundException if the given file doesn't excist.
	 */
	public static void editList() throws FileNotFoundException {
		DrawingStorage ds = DrawingStorage.read("input");
		int n = 0, o = 0;
		System.out.println("Please enter the date of the drawing you want to edit.");
		Date date = dateIn();
		Drawing dr = null;
		ArrayList<Drawing> dl = ds.getdList();
		for(Drawing d : dl){
			if(d.getDate().equals(date)){
				dr = d;
			}
		}
		if(dr == null){
			System.out.println("Drawing not found.");
			return;
		}
		int[] numbers = dr.getNumbers();
		String colour = dr.getColour();
		Date date2 = dr.getDate();
		while(o == 0){
			System.out.println("What do you want to edit?");
			System.out.println("1) Date");
			System.out.println("2) Numbers");
			System.out.println("3) Colour");
			n = sc.nextInt();
			if(n == 1){
				System.out.println("Enter the correct date:");
				date2 = dateIn();
				System.out.println("The date has been changed from "+date.toString()+" to "+ date2.toString()+".");
				o = 1;
			} else if(n == 2) {
				System.out.println("Enter the correct Numbers:");
				int[] numbersOld = numbers;
				numbers = numbersIn();
				System.out.println("The numbers has been changed from "+Arrays.toString(numbersOld)+" to "+Arrays.toString(numbers)+".");
				
				o = 1;
			} else if(n == 3) {
				System.out.println("Enter the correct Colour:");
				String colourOld = colour;
				colour = colourIn();
				System.out.println("The colour has been changed from "+colourOld+" to "+colour+".");
				o = 1;

			} else {
				System.out.println("Not a valid choice.");
			}	
		}
		dr = new Drawing(numbers, colour, date2);
		ds.editDrawing(date, dr);
		ds.write("Input");
	}

	/** Method that lets the user add a Drawing to the txt file.
	 * 
	 * @throws IOException Throws an IOException if the given file is not correct.
	 */
	public static void addDrawing() throws IOException {
		DrawingStorage ds = DrawingStorage.read("input");

		System.out.println("Please enter the date of this drawing");
		Date date = dateIn();
		System.out.println("Please enter the numbers of this drawing.");
		int[] i = numbersIn();

		System.out.println("Please enter the colour of this drawing");
		String s = colourIn();

		Drawing drawing = new Drawing(i,s,date);
		ds.addDrawing(drawing);
		ds.write("input");
	}

	public static int[] numbersIn(){
		System.out.println("First:");
		int[] i = {-1,-1,-1,-1,-1,-1};
		while(i[0] < 1 || i[0] > 45){
			i[0] = sc.nextInt();
			if(i[0] < 1 || i[0] > 45){
				System.out.println("You did not enter a correct number, please try again");
			}
		}

		System.out.println("Second:");

		while(i[1] < 1 || i[1] > 45){
			i[1] = sc.nextInt();
			if(i[1] < 1 || i[1] > 45){
				System.out.println("You did not enter a correct number, please try again");
			}
		}

		System.out.println("Third:");
		while(i[2] < 1 || i[2] > 45){
			i[2] = sc.nextInt();
			if(i[2] < 1 || i[2] > 45){
				System.out.println("You did not enter a correct number, please try again");
			}
		}

		System.out.println("Fourth:");
		while(i[3] < 1 || i[3] > 45){
			i[3] = sc.nextInt();
			if(i[3] < 1 || i[3] > 45){
				System.out.println("You did not enter a correct number, please try again");
			}
		}

		System.out.println("Fifth:");
		while(i[4] < 1 || i[4] > 45){
			i[4] = sc.nextInt();
			if(i[4] < 1 || i[4] > 45){
				System.out.println("You did not enter a correct number, please try again");
			}
		}
		System.out.println("Sixth:");
		while(i[5] < 1 || i[5] > 45){
			i[5] = sc.nextInt();
			if(i[5] < 1 || i[5] > 45){
				System.out.println("You did not enter a correct number, please try again");
			}
		}
		return i;
	}
	public static Date dateIn(){
		int day = 0;
		int month = 0;
		int year = 0;
		int k = 0, l = 0, m = 0;
		while(k == 0){
			System.out.println("Day:");
			day = sc.nextInt();
			if(day <= 31 && day >= 1){
				k = 1;
			} else {
				System.out.println("Not a valid day.");
			}
		}
		while(l == 0){
			System.out.println("Month:");
			month = sc.nextInt();
			if(month <= 12 && month >= 1){
				l = 1;
			} else {
				System.out.println("Not a valid month.");
			}
		}
		while(m == 0){
			System.out.println("Year:");
			year = sc.nextInt();
			if(year >=  minYear && year <= maxYear){
				m = 1;
			} else {
				System.out.println("Not a valid year");
			}
		}
		Date date = new Date(day, month, year);
		return date;
	}

	public static String colourIn(){
		String s = "";
		while(!s.equals("blauw") && !s.equals("rood") && !s.equals("groen") && !s.equals("geel") && !s.equals("paars") && !s.equals("oranje")){
			s = sc.next();
			s = s.toLowerCase();
			if(!s.equals("blauw") && !s.equals("rood") && !s.equals("groen") && !s.equals("geel") && !s.equals("paars") && !s.equals("oranje")){
				System.out.println("You did not enter a correct colour, please try again");
			}
		}
		return s;
	}
}
