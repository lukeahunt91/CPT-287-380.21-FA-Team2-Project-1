package project_1;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Movie {
	
	// Data Fields
	private String title;
	private Date releaseDate;
	private String description;
	private Date receiveDate;
	private enum status { RELEASED, RECEIVED } 
	private status movieStatus;
	public SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	// Constructors
	public Movie() {} // Default Constructor
	
	public Movie(String title, Date releaseDate, String description, Date receiveDate, String releaseStatus) {
		this.setTitle(title);
		this.setReleaseDate(releaseDate);
		this.setDescription(description);
		this.setReceiveDate(receiveDate);
		this.movieStatus = status.valueOf(releaseStatus);
		
	}
	
	public Movie(Movie other) { // Copy Constructor
		this.setTitle(other.getTitle());
		this.setReleaseDate(other.getReleaseDate());
		this.setDescription(other.getDescription());
		this.setReceiveDate(other.getReceiveDate());
		this.movieStatus = status.valueOf(getStatus());
	}

	// Getters
	public String getTitle() {
		return title;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Date getReceiveDate() {
		return receiveDate;
	}
	
	public String getStatus() {
		return movieStatus.toString();
	}
	
	// Setters
	public void setTitle(String title) {
		this.title = title;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setReleaseDate(String stringReleaseDate) {
		try {
				this.releaseDate = format.parse(stringReleaseDate);
			} catch (ParseException e) {
				System.out.println("Invalid input"); // Provide error message
			}
		}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	
	public void setReceiveDate(String stringReceiveDate) {
		try {
			this.receiveDate = format.parse(stringReceiveDate);
		} catch (ParseException e) {
			System.out.println("Invalid input"); // Provide error message
		}
	}
	
	public void setStatus(String movieStatus) {
		this.movieStatus = status.valueOf(movieStatus);
	}
	
	@Override public String toString() {
		return getTitle() + " " + format.format(getReleaseDate()) + " " + getDescription() + " " + format.format(getReceiveDate()) + " " + getStatus();
	}

	public String insertCommas() {
		return getTitle() + ", " + format.format(getReleaseDate()) + ", " + getDescription() + ", " + format.format(getReceiveDate()) + ", " + getStatus();
	}
	
	
}
