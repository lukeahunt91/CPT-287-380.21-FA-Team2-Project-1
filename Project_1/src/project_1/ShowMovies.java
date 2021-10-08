package project_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class ShowMovies {
	
	public static Movie showMovies(LinkedList<Movie> linkedtest)throws Exception {
		Scanner mScanner = new Scanner(System.in);

		System.out.println("Show movies with a given release date (mm/dd/yyyy): ");
		String movieRelease = mScanner.nextLine();
		Date movieRDate = new SimpleDateFormat("MM/dd/yyyy").parse(movieRelease);


		return null;

	}





	

}
