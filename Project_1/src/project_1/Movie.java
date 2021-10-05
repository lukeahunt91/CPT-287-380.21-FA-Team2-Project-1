package project_1;

import java.sql.Date;

/**
 * @Steven Shackleford: Determine syntax for ENUM values & complete toString() override
 * TODO: Create getters/setters to be in this class or Movie_DList class
 */

/** A doubly-linked-list movie object (modified node)*/
public class Movie {
	//Data fields
	private String title;
	private Date releaseDate;
	private String description;
	private Date recieveDate;
	private enum status { RELEASED, RECEIVED } 
	private status movieStatus;
	
	public Movie() {} //Default
	
	public Movie(String title, Date releaseDate, String description, Date receiveDate, status releaseStatus) {
		this.setTitle(title);
		this.setReleaseDate(releaseDate);
		this.setDescription(description);
		this.setRecieveDate(receiveDate);
		this.movieStatus = releaseStatus;
	}
	
	//Getters
	public String getTitle() {
		return title;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Date getRecieveDate() {
		return recieveDate;
	}
	
	public String getStatus() {
		return movieStatus.toString();
	}
	
	//Setters
	public void setTitle(String title) {
		this.title = title;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRecieveDate(Date recieveDate) {
		this.recieveDate = recieveDate;
	}
	public void setStatus(status movieStatus) {
		this.movieStatus = movieStatus;
	}


	//Methods
	@Override public String toString(){
		//TODO: FINISH METHOD
	}
}
