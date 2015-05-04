package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/** Class that runs the menu of the program.
 * 
 * @author Dennis de Jong
 * @version 03-05-2015
 */
public class Menu {
	private static int p = 1;
	private static int minYear = 2013;
	private static int maxYear = 2015;
	static Scanner sc = new Scanner(System.in);
	/** Main of the program.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		while(p == 1){
			menu();
		}
	}
	/** Method that runs the menu.
	 * 
	 * @throws IOException
	 */
	public static void menu() throws IOException{
		System.out.println("Select an option:");
		System.out.println("1) Add a drawing.");
		System.out.println("2) Print the list of Drawings");
		System.out.println("3) Edit a drawing");
		System.out.println("4) Close the program");
		int choice = sc.nextInt();
		if(choice == 1) {
			addDrawing();
		}
		if(choice == 2) {
			printList();
		}
		if(choice == 3){
			editList();
		}
		if(choice == 4) {
			closeProgram();
		}
		if(choice<1 || choice>4){
			System.out.println("Not a correct choice.");
		}
	}
	/** Method to close the program*/
	public static void closeProgram() {
		p = 0;
		System.out.println("Program is closed.");
	}

	/** Method that prints the list of Drawings in the txt file.
	 * 
	 * @throws IOException
	 */
	public static void printList() throws IOException{
		DrawingStorage ds = DrawingStorage.read("input");
		System.out.println(ds.toString());
	}
	/** Method that lets the user edit a Drawing in the txt file
	 * 
	 * @throws FileNotFoundException
	 */
	public static void editList() throws FileNotFoundException {
		DrawingStorage ds = DrawingStorage.read("input");
		int k = 0, l = 0, m = 0, n = 0, o = 0, day = 0, month = 0, year = 0;
		System.out.println("Please enter the date of the drawing you want to edit.");
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
		k = 0;
		l = 0;
		m = 0;
		while(o == 0){
			System.out.println("What do you want to edit?");
			System.out.println("1) Date");
			System.out.println("2) Numbers");
			System.out.println("3) Colour");
			n = sc.nextInt();
			if(n == 1){
				System.out.println("Enter the correct date:");
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
				
				date2 = new Date(day, month, year);
				o = 1;
			} else if(n == 2) {
				System.out.println("Enter the correct Numbers:");
				int[] i = new int[5];
				System.out.println("First:");
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
				numbers = i;
				o = 1;
			} else if(n == 3) {
				System.out.println("Enter the correct Colour:");
				String s = "";
				while(!s.equals("blauw") && !s.equals("rood") && !s.equals("groen") && !s.equals("geel") && !s.equals("paars")){
					s = sc.next();
					s = s.toLowerCase();
					if(!s.equals("blauw") && !s.equals("rood") && !s.equals("groen") && !s.equals("geel") && !s.equals("paars")){
						System.out.println("You did not enter a correct colour, please try again");
					}
				}
				colour = s;
				o = 1;
				
			} else {
				System.out.println("Not a valid choice.");
			}
			dr = new Drawing(numbers, colour, date2);
			ds.editDrawing(date, dr);
			ds.write("Input");
		}
	}

	/** Method that lets the user add a Drawing to the txt file.
	 * 
	 * @throws IOException
	 */
	public static void addDrawing() throws IOException {
		DrawingStorage ds = DrawingStorage.read("input");
		int[] i = {-1,-1,-1,-1,-1};
		String s = "false";
		int day = 0;
		int month = 0;
		int year = 0;
		int k = 0, l = 0, m = 0;
		System.out.println("Please enter the date of this drawing");
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
		System.out.println("Please enter the numbers of this drawing.");

		System.out.println("First:");
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
		System.out.println("Please enter the colour of this drawing");
		while(!s.equals("blauw") && !s.equals("rood") && !s.equals("groen") && !s.equals("geel") && !s.equals("paars")){
			s = sc.next();
			s = s.toLowerCase();
			if(!s.equals("blauw") && !s.equals("rood") && !s.equals("groen") && !s.equals("geel") && !s.equals("paars")){
				System.out.println("You did not enter a correct colour, please try again");
			}
		}
		Date date = new Date(day, month, year);
		Drawing drawing = new Drawing(i,s,date);
		ds.addDrawing(drawing);
		ds.write("input");
	}

}
