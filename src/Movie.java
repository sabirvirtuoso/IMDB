public class Movie {

	private String movieName;
	private String movieYear;
	private String movieDuration;
	private String movieRating;
	private String movieVotes;
	private String movieGenre;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(String movieYear) {
		this.movieYear = movieYear;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieVotes() {
		return movieVotes;
	}

	public void setMovieVotes(String movieVotes) {
		this.movieVotes = movieVotes;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String toString() {
		String returnString = "Movie Name : " + movieName + "\n" + "Year : "
				+ movieYear + "\n" + "Duration : " + movieDuration + "\n"
				+ "Rating : " + movieRating + "\n" + "Total Votes : "
				+ movieVotes + "\n" + "Genre : " + movieGenre + "\n\n";
		return returnString;
	}

}