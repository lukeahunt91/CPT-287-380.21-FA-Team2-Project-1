package project_1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MovieListMethods {
	
	/*
	 * Adds a movie to either the released or received movie list depending on their status. 
	 * @param inputString: string array containing movie fields.
	 * @param releasedMovies: LinkedList containing released movies.
	 * @param receivedMovies: LinkedList containing received movies.
	 * @param comingIterator: ListIterator for the coming (received) movie LinkedList.
	 */
	public static void addMovie(String[] inputString, LinkedList<Movie> releasedMovies, ListIterator<Movie> showingIterator, LinkedList<Movie> receivedMovies, ListIterator<Movie> comingIterator) {
		try {
			String title = inputString[0]; // Store title
			String stringReleaseDate = inputString[1]; // Store release date
			Date releaseDate = new SimpleDateFormat("MM/dd/yyyy").parse(stringReleaseDate); // Formatted released date
			String description = inputString[2]; // Description of movie
			String stringReceiveDate = inputString[3]; // Received date of movie
			Date receiveDate = new SimpleDateFormat("MM/dd/yyyy").parse(stringReceiveDate); // Formatted received date
			String movieStatus = inputString[4]; // Status of movie
			Movie movie = null;
			
			//check if title already exists in lists
			while(showingIterator.hasNext()) {
				movie = showingIterator.next();
				if(title.equals(movie.getTitle())) {
					System.out.println("\nERROR: Title already exists in showing list.\n");
					return;
				}
			}
			
			while(comingIterator.hasNext()) {
				movie = comingIterator.next();
				if(title.equals(movie.getTitle())) {
					System.out.println("\nERROR: Title already exists in coming list.\n");
					return;
				}
			}
			
			//reset iterators
			showingIterator = releasedMovies.listIterator();
			comingIterator = receivedMovies.listIterator();

			if (movieStatus.equals("RELEASED")) {
				
				movie = new Movie(title, releaseDate, description, receiveDate, movieStatus);
				releasedMovies.add(movie);
				return;
				
			} else if (movieStatus.equals("RECEIVED")){
				
				movie = new Movie(title, releaseDate, description, receiveDate, movieStatus); // Create new movie object
				
				if(receivedMovies.isEmpty()) { // if empty, add to end of list
					receivedMovies.add(movie);
					return;
					
				} else { // if not empty
					while (comingIterator.hasNext()) { // loop through all in list
						Movie q = comingIterator.next(); // store current movie as a temp object
						if (movie.getReceiveDate().compareTo(q.getReceiveDate()) < 0) { // if date of new movie is less than or equal to date of current object
							comingIterator.previous(); // move iterator back one position
							comingIterator.add(movie); // add before current item
							return;
						}
					} // End while loop
					receivedMovies.add(movie);
					return;
				}
				
			} 

		}

		catch (Exception e) { // If error occurs
			System.out.println("Invalid input"); // Provide error message
		}
				
	}
	
	/**
	 * Uses scanner to prompt user for data to create string array.
	 * @param mScanner: scanner object for user input
	 * @return: string array to be used in addMovie method
	 */
	public static String[] userAddMovie(Scanner mScanner){
		
		String movieTitle = mScanner.nextLine(); // Read title with scanner
		while(movieTitle.equals("")){
			System.out.println("Please enter the movie title: "); // Prompt for movie title
			movieTitle = mScanner.nextLine(); // Read title with scanner
		}

		System.out.println("Please enter the movie release date in mm/dd/yyyy format: "); // Prompt for release date
		String movieRelease = mScanner.nextLine(); // Read release date with scanner

		System.out.println("Please enter the movie description: "); // Prompt for description
		String movieDescription = mScanner.nextLine(); // Read description with scanner

		System.out.println("Please enter the movie receive date in mm/dd/yyyy format: "); // Prompt for receive date
		String movieReceive = mScanner.nextLine(); // Read receive date with scanner

		String movieStatus = "RECEIVED"; // Set movie status to RECEIVED

		String[] output = { movieTitle, movieRelease, movieDescription, movieReceive, movieStatus };

		return output; // Return string array

	} // End of method
	
	/**
	 * Uses scanner to prompt user for data to edit movie object.
	 * @param mScanner: scanner object for user input
	 */
	public static void editMovie(Scanner mScanner, LinkedList<Movie> releasedMovies, ListIterator<Movie> showingIterator, LinkedList<Movie> receivedMovies, ListIterator<Movie> comingIterator) {
		
		String movieTitle = mScanner.nextLine(); // Read title with scanner
		while(movieTitle.equals("")){
			System.out.println("Please enter the movie title to edit: "); // Prompt for movie title
			movieTitle = mScanner.nextLine(); // Read title with scanner
		}
		
		if(receivedMovies.isEmpty()) {
			System.out.println("Received movie list is empty!");
			return;
		} else {
			
			while(comingIterator.hasNext()) {
				Movie q = comingIterator.next();
				if(movieTitle.equals(q.getTitle())) {
					
					System.out.println("Editing: " +q);
					System.out.printf("\nPlease enter the new title (or Enter to keep %s): ", q.getTitle()); // Prompt for movie title
					movieTitle = mScanner.nextLine(); // Read title with scanner
					if(movieTitle.equals("")) {movieTitle = q.getTitle();}
					
					System.out.printf("\nPlease enter the new release date in the form mm/dd/yyyy (or Enter to keep %s): ", q.format.format(q.getReleaseDate())); // Prompt for movie title
					String stringMovieRelease = mScanner.nextLine(); // Read title with scanner
					if(stringMovieRelease.equals("")) {stringMovieRelease = q.format.format(q.getReleaseDate());}
					
					System.out.printf("\nPlease enter the new description (or Enter to keep %s): ",q.getDescription()); // Prompt for movie title
					String description = mScanner.nextLine(); // Read title with scanner
					if(description.equals("")) {description = q.getDescription();}
					
					System.out.printf("\nPlease enter the new received date in the form mm/dd/yyyy (or Enter to keep %s): ", q.format.format(q.getReceiveDate())); // Prompt for movie title
					String stringMovieReceive = mScanner.nextLine(); // Read title with scanner
					if(stringMovieReceive.equals("")) {stringMovieReceive = q.format.format(q.getReceiveDate());}
					
					String[] input = { movieTitle, stringMovieRelease, description, stringMovieReceive, "RECEIVED" };
				
					comingIterator.remove();
					comingIterator = receivedMovies.listIterator();
					addMovie(input, releasedMovies, showingIterator, receivedMovies, comingIterator);
					System.out.println();
					return;
					
				}
			}
			System.out.println("No movie matching that title.");
		}

	}

	/**
	 * 
	 * @param mScanner
	 * @param releasedMovies
	 * @param showingIterator
	 * @param receivedMovies
	 * @param comingIterator
	 */
	public static void showMovies(Scanner mScanner, LinkedList<Movie> releasedMovies,
			ListIterator<Movie> showingIterator, LinkedList<Movie> receivedMovies, ListIterator<Movie> comingIterator) {
		
		String stringReleaseDate = mScanner.nextLine();
		
		while(stringReleaseDate.equals("")) {
			System.out.println("\nEnter date for movies to be moved to released in the form mm/dd/yyyy: ");
			stringReleaseDate = mScanner.nextLine();
		}
		
		
		while (comingIterator.hasNext()) {
			Movie q = comingIterator.next();
			if (stringReleaseDate.compareTo(q.format.format(q.getReleaseDate()))==0) {
				q.setStatus("RELEASED");
				showingIterator.add(q);
			}
		}
		
		comingIterator = receivedMovies.listIterator();
		
		while (comingIterator.hasNext()) {
			Movie q = comingIterator.next();
			if (q.getStatus().equals("RELEASED")) {
				comingIterator.remove();
			}
		}
	}
	
	/**
	 * 
	 * @param mScanner
	 * @param receivedMovies
	 * @param comingIterator
	 */
	public static void numMoviesComing(Scanner mScanner, LinkedList<Movie> receivedMovies, ListIterator<Movie> comingIterator) {
		String stringReleaseDate = mScanner.nextLine();
		int count = 0;
		
		while(stringReleaseDate.equals("")) {
			System.out.println("\nEnter date to display coming movies released before the form mm/dd/yyyy: ");
			stringReleaseDate = mScanner.nextLine();
		}
		
		try {
			Date releaseDate = new SimpleDateFormat("MM/dd/yyyy").parse(stringReleaseDate);
			
			while (comingIterator.hasNext()) {
				Movie q = comingIterator.next();
				if (releaseDate.compareTo(q.getReleaseDate())>0) {
					count++;
				}
			}
			
		} catch (ParseException e) {
			System.out.println("Invalid date.");
		} // Formatted released date
		
		System.out.printf("\n%d coming movies to be released before %s\n\n", count, stringReleaseDate);
	}
	
	public static void saveMovies(String fileName, ListIterator<Movie> comingIterator, ListIterator<Movie> showingIterator) throws IOException {
		
		FileOutputStream outputFile = new FileOutputStream(fileName);
		PrintWriter writer = new PrintWriter(outputFile);
		Movie tempMovie;
		
		while (showingIterator.hasNext()) { 
			tempMovie = showingIterator.next();
			writer.println(tempMovie.insertCommas());
			
		}
		while (comingIterator.hasNext()) { 
			tempMovie = comingIterator.next();
			writer.println(tempMovie.insertCommas());
		}
		
		writer.close();
		outputFile.close();	
	}
}
