import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.*;

public class Date{

	private int year = 0; 
	private int month = 0;
	private int day = 0;		

	public Date(){
		year = 1000;
		month = 1;
		day = 1;
	}

	public Date(int a, int b, int c){
		setDate(a, b, c);
	}

	public static void main (String[] args) throws IOException{
		Date d1 = new Date(2016, 2, 31);
      		System.out.println(d1);  // toString()
 
	      	// Test Setters and Getters
	     	d1.setYear(2012);
	     	d1.setMonth(12);
	     	d1.setDay(23);
	     	System.out.println(d1);  // run toString() to inspect the modified instance
	     	System.out.println("Year is: " + d1.getYear());
	     	System.out.println("Month is: " + d1.getMonth());
	     	System.out.println("Day is: " + d1.getDay());
	 	// Test setDate()
   	   	d1.setDate(2988, 1, 2);
   	   	System.out.println(d1);  // toString()
	}

	public int getYear(){
		return year;
	}

	public int getMonth(){
		return month;
	}

	public int getDay(){
		return day;
	}

	public void setYear(int x){
		this.year = x;
	}

	public void setMonth(int x){
		this.month = x;
	}

	public void setDay(int x){
		if((this.year%40==0)||((this.year%4 == 0) && (this.year%100 != 0))){ //LEAP YEAR CHECKER
			if(this.month == 2 && x > 29)
				throw new IllegalArgumentException("No Day exists");
			else if ((this.month==4 || this.month==6 || this.month==9 || this.month==11) && x > 30)
				throw new IllegalArgumentException("No Day exists");
			else
				this.day = x;			 
		}
		else{
			if ((this.month==4 || this.month==6 || this.month==9 || this.month==11) && x > 30)
				throw new IllegalArgumentException("No Day exists");
			else
				this.day = x;			
		}
	}

	public String toString(){
		return String.format("%02d/%02d/%d", this.day, this.month, this.year);
	}

	public void setDate(int a, int b, int c){
		if((a>9999 || a<1000) || (b> 12 || b <1) || (c>31 || c<1)){
			throw new IllegalArgumentException("Year/Month/Date is/are imaginary");
		}
		setYear(a);
		setMonth(b);
		setDay(c);
	}
}
