package project_1;

import java.sql.Date;

/**
 * @Steven Shackleford: Determine syntax for ENUM values & complete toString() override
 * TODO: Create getters/setters to be in this class or Movie_DList class
 */

/** A doubly-linked-list movie object (modified node)*/
public class Movie {
	//Data fields
	String name; // Title of movie
	Date releaseDate;
	String description;
	Date receiveDate;
	Movie next, prev;
	enum status {RELEASED, RECEIVED}; //TODO: FIXME!!! Is this correct syntax?
	
	//Constructor
	Movie(String newName, Date newRelDate, String newDesc, Date newRecDate/**TODO FIXME:, status NewStatus*/){
		name = newName;
		this.releaseDate = newRelDate;
		this.description = newDesc;
		this.receiveDate = newRecDate;
		// TODO: FIXME!!! How to set status enum value for Movie?
	}
	
	//Methods
	@Override public String toString(){
		//TODO: FINISH METHOD
	}
}