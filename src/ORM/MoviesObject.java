package ORM;

public class MoviesObject {

	private int Movie_ID;
	private String MovieName;
	private  String Genre;
	private double RentalPrice;
	
	
	public MoviesObject() {
		// TODO Auto-generated constructor stub
	}


	public int getMovie_ID() {
		return Movie_ID;
	}


	public void setMovie_ID(int movie_ID) {
		Movie_ID = movie_ID;
	}


	public String getMovieName() {
		return MovieName;
	}


	public void setMovieName(String movieName) {
		MovieName = movieName;
	}


	public String getGenre() {
		return Genre;
	}


	public void setGenre(String genre) {
		Genre = genre;
	}


	public double getRentalPrice() {
		return RentalPrice;
	}


	public void setRentalPrice(double rentalPrice) {
		RentalPrice = rentalPrice;
	}

	
}
