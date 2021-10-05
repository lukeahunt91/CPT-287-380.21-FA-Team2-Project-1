package project_1;

import java.util.Date;

/**
 * TODO: Complete toSTring() override
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
	

	//Make Movie class a node? - LAH 10/04/21
	Movie next, prev;
	
	public Movie() {} //Default
	
	public Movie(String title, Date releaseDate, String description, Date receiveDate, String releaseStatus) {

		this.setTitle(title);
		this.setReleaseDate(releaseDate);
		this.setDescription(description);
		this.setRecieveDate(receiveDate);
		this.movieStatus = status.valueOf(releaseStatus);

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
	
	public status getMovieStatus() {
		return movieStatus;
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

	public void setMovieStatus(String newStatus) {
		this.movieStatus = status.valueOf(newStatus);
	}


	//Methods
	/**
	 * @Override public String toString(){
		//TODO: FINISH METHOD
	}

	*/

}
