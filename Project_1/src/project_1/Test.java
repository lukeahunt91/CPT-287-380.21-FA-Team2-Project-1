package project_1;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class Test {

	public static void main(String[] args)throws Exception {
		LinkedList<Movie> linkedtest = new LinkedList<Movie>();
		Scanner scanner = new Scanner(System.in);



		String sDate1 = "01/12/2021";
		Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);

		Movie movie1 = new Movie("title", date1, "description", date1, "RELEASED");
		Movie movie12 = new Movie("title2", date1, "description2", date1, "RELEASED");
		Movie movie13 = new Movie("title3", date1, "description3", date1, "RELEASED");


		linkedtest.add(movie1);
		linkedtest.add(movie12);
		linkedtest.add(movie13);

		//Iterator<Movie> itt = linkedtest.iterator();

		ListIterator<Movie> it = linkedtest.listIterator();

		System.out.println("What would you like to do?");
		System.out.println("display movies, add movies, start showing movies, number of movies before release date, save, exit\n");
		String userInput = scanner.nextLine();


		while(it.hasNext()) {
			switch (userInput) {

			case ("display"):
				Movie tempMovie = it.next();
			System.out.println(tempMovie);
			System.out.println("display next, edit movie");
			userInput = scanner.nextLine();
			break;			

			case ("add"):
				linkedtest.add(addMovie(linkedtest));
			System.out.println("display movies, add movies, start showing movies, number of movies before release date, save, exit\n");

			userInput = scanner.nextLine();
			break;

			case("exit"):
				return;

			}
		}



	}	



	public static Movie addMovie(LinkedList linkedtest)throws Exception {
		Scanner mScanner = new Scanner(System.in);

		System.out.println("Please enter the movie title: ");

		String movieTitle = mScanner.nextLine();
		System.out.println("Please enter the movie release date in mm/dd/yyyy format: ");
		String movieRelease = mScanner.nextLine();
		Date movieRDate = new SimpleDateFormat("MM/dd/yyyy").parse(movieRelease);
		System.out.println("Please enter the movie description: ");
		String movieDescription = mScanner.nextLine();
		System.out.println("Please enter the movie recieve date in mm/dd/yyyy format: ");
		String movieRecieve = mScanner.nextLine();
		Date movieRcDate = new SimpleDateFormat("MM/dd/yyyy").parse(movieRecieve);
		String movieStatus = "RECIEVED";

		Movie movie = new Movie(movieTitle, movieRDate, movieDescription, movieRcDate, movieStatus);
		return movie;
	}




}
