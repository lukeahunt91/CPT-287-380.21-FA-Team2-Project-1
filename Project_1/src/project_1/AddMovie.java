package project_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddMovie {
	
	public static Movie addMovie(){

		try {
			Scanner mScanner = new Scanner(System.in);

			System.out.println("Please enter the movie title: ");

			String movieTitle = mScanner.nextLine();
			System.out.println("Please enter the movie release date in mm/dd/yyyy format: ");
			String movieRelease = mScanner.nextLine();
			Date movieRDate = new SimpleDateFormat("MM/dd/yyyy").parse(movieRelease);
			System.out.println("Please enter the movie description: ");
			String movieDescription = mScanner.nextLine();
			System.out.println("Please enter the movie recieve date in mm/dd/yyyy format: ");
			String movieReceive = mScanner.nextLine();
			Date movieRcDate = new SimpleDateFormat("MM/dd/yyyy").parse(movieReceive);
			String movieStatus = "RECEIVED";

			Movie movie = new Movie(movieTitle, movieRDate, movieDescription, movieRcDate, movieStatus); 
			return movie; 
		} catch (Exception e) {
			System.out.println("Invalid input");
		}

		return null;
	}
	
	

}
