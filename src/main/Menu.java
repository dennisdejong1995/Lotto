package main;



import java.io.IOException;
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
	public static void menu() throws IOException{
		System.out.println("Select an option:");
		System.out.println("1) Add a drawing.");
		System.out.println("2) Print the list of Drawings");
		System.out.println("3) Close the program");
		int choice = sc.nextInt();
		if(choice == 1) {
			addDrawing();
		}
		if(choice == 2) {
			printList();
		}
		if(choice == 3) {
			closeProgram();
		}
		if(choice<1 || choice>3){
			System.out.println("Not a correct choice.");
		}
	}

	public static void closeProgram() {
		p = 0;
	}
	public static void printList() throws IOException{
		DrawingStorage ds = DrawingStorage.read("input");
		System.out.println(ds.toString());
	}
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
		ds.AddDrawing(drawing);
		ds.write("input");
	}
}
