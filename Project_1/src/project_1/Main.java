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

		//Data Fields

		String stringReadFile;
		LinkedList<Movie> releasedMovies = new LinkedList<Movie>();
		LinkedList<Movie> receivedMovies = new LinkedList<Movie>();
		String title;
		String stringReleaseDate;
		Date releaseDate;
		String description;
		String stringReceiveDate;
		Date receiveDate;
		String movieStatus;



		//Open input and output files, create Movie object
		FileInputStream inputFile = new FileInputStream("Movies.txt");
		Scanner inputScanner = new Scanner(inputFile);	//Inputfile scanner
		Scanner scanner = new Scanner(System.in);		//User entry scanner
		FileOutputStream outputFile = new FileOutputStream("Movies1.txt");
		PrintWriter writer = new PrintWriter(outputFile);
		Movie movie = null;
		Movie tempMovie;


		while (inputScanner.hasNext()) {

			stringReadFile = inputScanner.nextLine();
			String[] readFile  = stringReadFile.split(", ");
			title = readFile[0];
			stringReleaseDate = readFile[1];
			releaseDate = new SimpleDateFormat("MM/dd/yyyy").parse(stringReleaseDate);
			description = readFile[2];
			stringReceiveDate = readFile[3];
			receiveDate = new SimpleDateFormat("MM/dd/yyyy").parse(stringReceiveDate);
			movieStatus = readFile[4];

			switch (movieStatus) {
			case ("RELEASED"):
				movie = new Movie(title, releaseDate, description, receiveDate, movieStatus);
			releasedMovies.add(movie);
			break;
			case ("RECEIVED"):
				movie = new Movie(title, releaseDate, description, receiveDate, movieStatus);
			receivedMovies.add(movie);
			break;
			}

		}




		ListIterator<Movie> it = releasedMovies.listIterator();	//ListIterator for released movies
		ListIterator<Movie> itt = receivedMovies.listIterator();

		System.out.println("What would you like to do?");
		System.out.println("(1) display showing movies, (3) display coming movies, (4) add movies, "
				+ "\n(5) start showing movies, (6) number of movies before release date, (7) save, (8) exit\n");
		int userInput = scanner.nextInt();


		while(it.hasNext()) {

			switch (userInput) {

			case (1):										//Iterate and display movies in the "releasedMovies" list				

				tempMovie = it.next();
			if (it.hasNext() == false) { it = releasedMovies.listIterator(); }
			System.out.println("\n" + tempMovie + "\n");			
			System.out.println("(1) display showing movies, (3) display coming movies, (4) add movies, "
					+ "\n(5) start showing movies, (6) number of movies before release date, (7) save, (8) exit\n");
			userInput = scanner.nextInt();
			break;
			
			
			case (2):							//TODO			//edit the selected movie in the "receivedMovied" list
				
				
				break;
			

			case (3):										//Iterate and display movies in the "receivedMoves" list		

				tempMovie = itt.next();
			if (itt.hasNext() == false) { itt = receivedMovies.listIterator(); }
			System.out.println("\n" + tempMovie + "\n");
			System.out.println("(1) display showing movies, (2) edit movie, (3) display coming movies, (4) add movies, "
					+ "\n(5) start showing movies, (6) number of movies before release date, (7) save, (8) exit\n");
			userInput = scanner.nextInt();
			break;	

			case (4):										//Adds movie to the "receivedMovies" list
				receivedMovies.add(AddMovie.addMovie());
			System.out.println("(1) display movies, (3) add movies, (4) start showing movies, "
					+ "\n(5) number of movies before release date, (6) save, (7) exit\n");
			it = releasedMovies.listIterator();
			userInput = scanner.nextInt();
			break;

			case(5):										//Moves movies from "receivedMovies" with a given release date into "releasedMovies
				ShowMovies.showMovies(receivedMovies);		
			System.out.println("(1) display movies, (3) add movies, (4) start showing movies, "
					+ "\n(5) number of movies before release date, (6) save, (7) exit\n");
			it = releasedMovies.listIterator();
			userInput = scanner.nextInt();
			break;

			case(7):

				return;

			}
		}
		//Close files
		writer.close();
		outputFile.close();
		inputScanner.close();
		scanner.close();
		inputFile.close();


	}	




}
