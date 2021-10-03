package project_1;

import java.sql.Date;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * TODO: add method, displayAfter method, numComing method, startShowing method, orderByRelDate method, editMovie method
 */

/** A doubly-linked list*/
public class Movie_DList<Movie> extends LinkedList{
	
	// Data fields
	private Movie head, tail;
	
	//Constructors
	public Movie_DList() {} //Default Constructor
	
	// Methods
	/**
	 * Adds a movie to the list
	 * @param movie
	 */
	public void add(Movie movie) {
		//TODO: FINISH METHOD
	}
	
	/**
	 * Displays all movies that equal a given release date.
	 * @param relDate: release date of movies to display.
	 */
	public void displayAfter(Date relDate) {
		//TODO: FINISH METHOD
	}
	
	/**
	 * Returns the number of movies with a release date earlier than a given date.
	 * @param relDate: release date of movies to display.
	 * @return number of movies with a release date earlier than a given date.
	 */
	public int numComing(Date relDate) {
		//TODO: FINISH METHOD
	}
	
	/**
	 * Remove an item from this list and add to the showing list.
	 * @param showingList: list to add movie.
	 */
	public void startShowing(Movie_DList showingList) {
		//TODO: FINISH METHOD
	}
	
	/**
	 * Orders list by release date.
	 */
	private void orderByRelDate() {
		//TODO: FINISH METHOD
	}
	
	/**
	 * Edits release date or the description a movie with specified name.
	 * @param nameToEdit: name of movie to edit.
	 * @param newRelDate: date to replace existing released date of movie.
	 * @param description: description to replace existing description.
	 * @param choice: integer representing menu choice.
	 */
	public void editMovie(String nameToEdit, Date newRelDate, String description /**TODO:, int choice*/) {
		//TODO: FINISH METHOD
		// Find the movie using name
		// set release date
	}
}
