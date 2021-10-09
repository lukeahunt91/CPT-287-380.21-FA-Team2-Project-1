package project_1;

import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args)throws Exception {

		// Data Fields
		LinkedList<Movie> releasedMovies = new LinkedList<Movie>(); // LinkedList to store released movie objects
		LinkedList<Movie> receivedMovies = new LinkedList<Movie>(); // LinkedList to store received movie objects
		
		//Open input and output files, create Movie object
		FileInputStream inputFile = new FileInputStream("Movies.txt");
		Scanner inputScanner = new Scanner(inputFile);	// Input file scanner
		Scanner scanner = new Scanner(System.in);		// User entry scanner
		FileOutputStream outputFile = new FileOutputStream("Movies1.txt");
		PrintWriter writer = new PrintWriter(outputFile);
		Movie tempMovie;
		
		ListIterator<Movie> showingIterator = releasedMovies.listIterator();	// ListIterator for released movies (showing)
		ListIterator<Movie> comingIterator = receivedMovies.listIterator();		// ListIterator for received movies (coming)

		while (inputScanner.hasNext()) { // Loop through text file

			String stringReadFile = inputScanner.nextLine(); // Read line of text file
			String[] readFile = stringReadFile.split(", "); // Split text using comma (,)
			addMovie(readFile, releasedMovies, receivedMovies, comingIterator);
			showingIterator = releasedMovies.listIterator(); // Reset showing iterator
			comingIterator = receivedMovies.listIterator(); // Reset coming iterator

		} // End while loop

		showingIterator = releasedMovies.listIterator(); // Reset showing iterator
		comingIterator = receivedMovies.listIterator(); // Reset coming iterator
		
		String menuText = "What would you like to do?\n" +
				"(1) Display movies, (2) Edit movie, (3) Add movie, (4) Start showing movies\n" +
				"(5) Display number of movies before release date, (6) Save, (7) Exit\n";
		
		System.out.println(menuText);
		int userInput = scanner.nextInt();

		while(userInput != 7) {

			switch (userInput) {

			case (1):										//Iterate and display movies in the two lists				
				
				System.out.println("\n********* Movies Now Showing *********\n");
				while (showingIterator.hasNext()) { // Iterate through all movies
					tempMovie = showingIterator.next();
					System.out.println(tempMovie);
				}

				System.out.println("\n********* Movies Coming Soon *********\n");
				while (comingIterator.hasNext()) { // Iterate through all movies
					tempMovie = comingIterator.next();
					System.out.println(tempMovie);
				}
				System.out.println("\n**************************************\n");
				break;
			
			case (2):							//TODO			// Edit the selected movie in the "receivedMovies" list
				editMovie(scanner, receivedMovies, comingIterator);
				break;

			case (3):										// Adds movie to the "receivedMovies" list
				addMovie(userAddMovie(scanner),releasedMovies, receivedMovies, comingIterator);
				break;

			case(4):							//TODO		// Moves movies from "receivedMovies" with a given release date into "releasedMovies
				ShowMovies.showMovies(receivedMovies);		
				break;
				
			case (5):							//TODO		// Displays movies before a specific release date
				System.out.println("\n TODO: FINSH METHOD \n");
				break;
				
			case (6):							//TODO		//Saves movies to text file
				System.out.println("\n TODO: FINSH METHOD \n");
				break;
				
			default:
				System.out.println("Invalid Input\n");
				break;
			} // End case/switch
			
			showingIterator = releasedMovies.listIterator(); // Reset showing iterator
			comingIterator = receivedMovies.listIterator(); // Reset coming iterator
			System.out.println(menuText); // Print menu
			userInput = scanner.nextInt(); // Read user input
			
		} // End while loop
		
		//Close files
		writer.close();
		outputFile.close();
		inputScanner.close();
		scanner.close();
		inputFile.close();
	}	

	/**
	 * Adds a movie to either the released or received movie list depending on their status. 
	 * @param inputString: string array containing movie fields.
	 * @param releasedMovies: LinkedList containing released movies.
	 * @param receivedMovies: LinkedList containing received movies.
	 * @param comingIterator: ListIterator for the coming (received) movie LinkedList.
	 */
	public static void addMovie(String[] inputString, LinkedList<Movie> releasedMovies, LinkedList<Movie> receivedMovies, ListIterator<Movie> comingIterator) {
		try {
			String title = inputString[0]; // Store title
			String stringReleaseDate = inputString[1]; // Store release date
			Date releaseDate = new SimpleDateFormat("MM/dd/yyyy").parse(stringReleaseDate); // Formatted released date
			String description = inputString[2]; // Description of movie
			String stringReceiveDate = inputString[3]; // Received date of movie
			Date receiveDate = new SimpleDateFormat("MM/dd/yyyy").parse(stringReceiveDate); // Formatted received date
			String movieStatus = inputString[4]; // Status of movie
			Movie movie = null;

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
	public static void editMovie(Scanner mScanner, LinkedList<Movie> receivedMovies, ListIterator<Movie> comingIterator) {
		
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
					System.out.printf("\nPlease enter the new title (or Enter to keep %s): ",q.getTitle()); // Prompt for movie title
					String input = mScanner.nextLine(); // Read title with scanner
					if(!input.equals("")) {q.setTitle(input);}
					
					System.out.printf("\nPlease enter the new release date in the form mm/dd/yyyy (or Enter to keep %s): ", q.format.format(q.getReleaseDate())); // Prompt for movie title
					input = mScanner.nextLine(); // Read title with scanner
					if(!input.equals("")) {q.setReleaseDate(input);}
					
					System.out.printf("\nPlease enter the new description (or Enter to keep %s): ",q.getDescription()); // Prompt for movie title
					input = mScanner.nextLine(); // Read title with scanner
					if(!input.equals("")) {q.setDescription(input);}
					
					System.out.printf("\nPlease enter the new received date in the form mm/dd/yyyy (or Enter to keep %s): ", q.format.format(q.getReceiveDate())); // Prompt for movie title
					input = mScanner.nextLine(); // Read title with scanner
					if(!input.equals("")) {q.setReceiveDate(input);}
					
				}
			}
			System.out.println("No movie matching that title.");
		}

	}
}
