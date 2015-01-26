public interface MovieInfoParserService {

	public String parseMovieName(String outputLine);

	public String parseMovieYear(String outputLine);

	public String parseMovieDuration(String outputLine);

	public String parseMovieRating(String outputLine);

	public String parseMovieVotes(String outputLine);

	public String parseMovieGenre(String outputLine);

}
