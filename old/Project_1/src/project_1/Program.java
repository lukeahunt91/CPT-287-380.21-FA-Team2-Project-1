package project_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @Chris Anderson: Complete IMPORT/EXPORT
 * TODO: MENU, IO SCANNER FOR USER INPUT
 */

public class Program {

	public static void main(String[] args) {
		
		Movie_DList<Movie> showing = new Movie_DList<>();
		Movie_DList<Movie> coming = new Movie_DList<>();
		String fileName = "movies.txt";
		
		//TODO: CREATE IMPORT LOOP
		importFile(fileName, showing, coming);
		
		//TODO: CREATE MENU LOOP
		
		//TODO: CREATE TEXT OUTPUT LOOP
		save(fileName);

	}
	
	/**
	 * Creates lists from input file
	 * @param inputFile
	 */
	public void importFile(String fileName, Movie_DList<Movie> showing, Movie_DList<Movie> coming) {
		FileInputStream inputFile = new FileInputStream(fileName); // opens file colorImage.ppm as input stream
		Scanner scanner = new Scanner(inputFile); // creates new scanner to read input file
		
		scanner.close();
		//TODO 
		
	}
	
	/**
	 * Saves movie lists to output text file
	 * @param outputFile
	 */
	public void save(String fileName) {
		FileOutputStream outputFile = new FileOutputStream(fileName); // creates new file grayscaleImage.ppm as output stream
		PrintWriter writer = new PrintWriter(outputFile); // creates new print writer to write to output file
		//TODO save lists to output file
	}

}
