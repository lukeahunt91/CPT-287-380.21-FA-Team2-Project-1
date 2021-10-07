package project_1;

import java.util.Date;
import java.text.SimpleDateFormat;


public class Movie {
	
	private String title;
	private Date releaseDate;
	private String description;
	private Date recieveDate;
	private enum status { RELEASED, RECEIVED } 
	private status movieStatus;
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	
	public Movie() {} //Default
	
	public Movie(String title, Date releaseDate, String description, Date receiveDate, String releaseStatus) {
		this.setTitle(title);
		this.setReleaseDate(releaseDate);
		this.setDescription(description);
		this.setRecieveDate(receiveDate);
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
	
	public String getRecieveDate() {
		return format.format(recieveDate);
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

	public void setRecieveDate(Date recieveDate) {
		this.recieveDate = recieveDate;
	}
	public void setStatus(String movieStatus) {
		this.movieStatus = status.valueOf(movieStatus);
	}
	
	@Override public String toString() {
		return getTitle() + " " + getReleaseDate() + " " + getDescription() + " " + getRecieveDate() + " " + getStatus();
	}
	
	
}
