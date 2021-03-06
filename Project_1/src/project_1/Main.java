package project_1;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)throws Exception {

		// Data Fields
		LinkedList<Movie> releasedMovies = new LinkedList<Movie>(); // LinkedList to store released movie objects
		LinkedList<Movie> receivedMovies = new LinkedList<Movie>(); // LinkedList to store received movie objects
		
		//Open input and output files, create Movie object
		String inOutFileName = "Movies.txt";
		FileInputStream inputFile = new FileInputStream(inOutFileName);
		Scanner inputScanner = new Scanner(inputFile);	// Input file scanner
		Scanner scanner = new Scanner(System.in);		// User entry scanner

		Movie tempMovie;
		
		ListIterator<Movie> showingIterator = releasedMovies.listIterator();	// ListIterator for released movies (showing)
		ListIterator<Movie> comingIterator = receivedMovies.listIterator();		// ListIterator for received movies (coming)

		while (inputScanner.hasNext()) { // Loop through text file

			String stringReadFile = inputScanner.nextLine(); // Read line of text file
			String[] readFile = stringReadFile.split(", "); // Split text using comma (,)
			MovieListMethods.addMovie(readFile, releasedMovies, showingIterator, receivedMovies, comingIterator);
			showingIterator = releasedMovies.listIterator(); // Reset showing iterator
			comingIterator = receivedMovies.listIterator(); // Reset coming iterator

		} // End while loop
		
		inputScanner.close(); // close file scanner
		inputFile.close(); // close input file

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
			
			case (2):										// Edits movie with a given name
				MovieListMethods.editMovie(scanner, releasedMovies, showingIterator, receivedMovies, comingIterator);
				break;

			case (3):										// Adds movie to the "receivedMovies" list
				MovieListMethods.addMovie(MovieListMethods.userAddMovie(scanner),releasedMovies, showingIterator, receivedMovies, comingIterator);
				break;

			case(4):										// Moves movies from "receivedMovies" with a given release date into "releasedMovies
				MovieListMethods.showMovies(scanner, releasedMovies, showingIterator, receivedMovies, comingIterator);		
				break;
				
			case (5):										// Displays movies before a specific release date
				MovieListMethods.numMoviesComing(scanner, receivedMovies, comingIterator);
				break;
				
			case (6):										//Saves movies to text file
				MovieListMethods.saveMovies(inOutFileName, comingIterator, showingIterator);
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
		
		//Close input scanner
		scanner.close();
		
	}	
}
