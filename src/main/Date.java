package main;
/** Class that stores a date
 * 
 * @author Dennis de Jong
 * @version 04-05-2015
 */
public class Date {
	private int day;
	private int month;
	private int year;
	/** Constructor
	 * 
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	/** Returns day.
	 * 
	 * @return int
	 */
	public int getDay() {
		return day;
	}
	/** Returns month.
	 * 
	 * @return int
	 */
	public int getMonth() {
		return month;
	}
	/** Returns year.
	 * 
	 * @return int
	 */
	public int getYear() {
		return year;
	}
	/** Returns a Date as a String.
	 * 
	 * @return String
	 */
	public String toString(){
		return day +"/"+month+"/"+year;
	}
	/** Checks if two Dates are equal.
	 * 
	 * @return boolean
	 */
	public boolean equals(Object obj){
		if(obj instanceof Date){
			Date d = (Date)obj;
			return this.day == d.getDay() && this.month == d.getMonth() && this.year == d.year;
		}
		return false;
	}
}
