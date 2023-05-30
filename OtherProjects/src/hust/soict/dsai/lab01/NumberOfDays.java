package hust.soict.dsai.lab01;

import java.util.Scanner;

public class NumberOfDays{

	public static int search(String[] arr, String month){
		if(arr == null){
			return -1;
		}

		for(int i = 0; i < arr.length; i++){
			if(month.equalsIgnoreCase(arr[i])){
				return i;
			}
		}
		return -1;
	}

	public static boolean checkLeapYear(int year){
		boolean isLeapYear = false;
		if(year % 4 == 0){
			if(year % 100 == 0){
				if(year % 400 == 0)
					isLeapYear = true;
			}else
				isLeapYear = true;
		}

		return isLeapYear;
	}

	public static void main(String[] args){
		String month, year;
		int monthIndex = -1, yearInt, result;
		boolean isLeapYear;

		String[] fullNameMonths = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
		String [] abbrMonths = {"jan.", "feb.", "mar.", "apr.", "may.", "jun.", "jul.", "aug.", "sep.", "oct.", "nov.", "dec."};
		String[] shortMonths = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
		String[] numMonths = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		Scanner s = new Scanner(System.in);

		//Input month
		while(true){
			System.out.println("Input month: ");
			month = s.nextLine();
			monthIndex = search(fullNameMonths, month);
			if(monthIndex == -1)
				monthIndex = search(abbrMonths, month);
			if(monthIndex == -1)
				monthIndex = search(shortMonths, month);
			if(monthIndex == -1)
				monthIndex = search(numMonths, month);
			if(monthIndex != -1)
				break;
			System.out.println("Invalid month!");
		}

		//Input year
		while(true){
			System.out.println("Input year: ");
			year = s.nextLine();
			try{
				yearInt = Integer.parseInt(year);
				if(yearInt >= 0){
					break;
				}
			}catch(Exception e){
			}
			System.out.println("Invalid year!");
		}
		
		if(monthIndex == 1 && checkLeapYear(yearInt) == true){
			result = 29;
		}else{
			result = numberOfDays[monthIndex];
		}
		System.out.printf("Number of days: %d\n", result);
	}
}
