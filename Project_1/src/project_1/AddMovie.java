package project_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddMovie {
	
	/**
	 * Uses scanner to prompt user for fields to create a new movie object.
	 * @return: movie object if no errors occur; {null} otherwise
	 */
	public static Movie addMovie(){

		try {
			Scanner mScanner = new Scanner(System.in); // Create scanner to read user inputs

			System.out.println("Please enter the movie title: "); // Prompt for movie title
			String movieTitle = mScanner.nextLine(); // Read title with scanner
			
			System.out.println("Please enter the movie release date in mm/dd/yyyy format: "); // Prompt for release date
			String movieRelease = mScanner.nextLine(); // Read release date with scanner
			Date movieRDate = new SimpleDateFormat("MM/dd/yyyy").parse(movieRelease); // Format input
			
			System.out.println("Please enter the movie description: "); // Prompt for description
			String movieDescription = mScanner.nextLine(); // Read description with scanner
			
			System.out.println("Please enter the movie receive date in mm/dd/yyyy format: "); // Prompt for receive date
			String movieReceive = mScanner.nextLine(); // Read receive date with scanner
			Date movieRcDate = new SimpleDateFormat("MM/dd/yyyy").parse(movieReceive); // Format input
			
			String movieStatus = "RECEIVED"; // Set movie status to RECEIVED

			Movie movie = new Movie(movieTitle, movieRDate, movieDescription, movieRcDate, movieStatus); // Create new movie object with input data
			mScanner.close(); // Close scanner
			return movie; // Return movie object
		}
		
		catch (Exception e) { // If error occurs
			System.out.println("Invalid input"); // Provide error message
		}
		
		return null; // Return null with error

	} // End of method
} // End of Class
