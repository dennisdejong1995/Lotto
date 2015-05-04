package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/** Class that stores Drawings.
 * 
 * @author Dennis de jong
 * @version 04-05-2015
 */
public class DrawingStorage {
	private ArrayList<Drawing> dList = new ArrayList<Drawing>();
	
	/** Constructor of DrawingStorage.*/
	public DrawingStorage(){	
		
	}
	/** Returns the list with Drawings
	 * 
	 * @return ArrayList<Drawing>
	 */
	public ArrayList<Drawing> getdList() {
		return dList;
	}
	/** Adds a Drawing to dList
	 * 
	 * @param drawing
	 */
	public void AddDrawing(Drawing drawing){
		dList.add(drawing);
	}
	/** Returns a DrawingStorage as String.
	 * 
	 * @return String
	 */
	public String toString(){
		String s = "";
		for(Drawing d : this.dList){
			s += d.toString() + "\n";
		}
		return s;
	}
	/** Reads a DrawingStorage from a txt file.
	 * 
	 * @param infile
	 * @return DrawingStorage
	 * @throws FileNotFoundException
	 */
	public static DrawingStorage read(String infile) throws FileNotFoundException {
		DrawingStorage drawingStorage = new DrawingStorage();
		try{

			File f = new File(infile);
			Scanner sc = new Scanner(f);
			int i = sc.nextInt();
			for(int j=0; j < i; j++){
				Drawing drawing = Drawing.read(sc);
				drawingStorage.AddDrawing(drawing);
			}
			sc.close();
		} 
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error 404: File not found");
		}
		
		return drawingStorage;
	}
	/** Writes a DrawingStorage to a txt file.
	 * 
	 * @param infile
	 */
	public void write(String infile){
		try{
			FileWriter fw = new FileWriter(infile);
			int i = this.dList.size();
			String j = Integer.toString(i);
			fw.write(j + "\n");
			for(Drawing d : this.dList){
				fw.write(d.write());
			}
			fw.close();
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Error 404: File not found");
		}
	}
}
