package project_1;

import java.util.Date;
import java.text.SimpleDateFormat;


public class Movie {
	
	private String title;
	private Date releaseDate;
	private String description;
	private Date receiveDate;
	private enum status { RELEASED, RECEIVED } 
	private status movieStatus;
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	public Movie next, prev;
	
	public Movie() {} //Default
	
	public Movie(String title, Date releaseDate, String description, Date receiveDate, String releaseStatus) {
		this.setTitle(title);
		this.setReleaseDate(releaseDate);
		this.setDescription(description);
		this.setReceiveDate(receiveDate);
		this.movieStatus = status.valueOf(releaseStatus);
		
	}

	public String getTitle() {
		return title;
	}
	
	public String getReleaseDate() {
		return format.format(releaseDate);
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getReceiveDate() {
		return format.format(receiveDate);
	}
	
	public String getStatus() {
		return movieStatus.toString();
	}
	

	public void setTitle(String title) {
		this.title = title;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	public void setStatus(String movieStatus) {
		this.movieStatus = status.valueOf(movieStatus);
	}
	
	@Override public String toString() {
		return getTitle() + " " + getReleaseDate() + " " + getDescription() + " " + getReceiveDate() + " " + getStatus();
	}
	
	
}
