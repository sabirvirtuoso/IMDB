import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieInfoParserServiceImpl implements MovieInfoParserService {

	private static final String MOVIE_NAME_PATTERN = "<title>(.*)</title>";
	private static final String MOVIE_YEAR_PATTERN = "<title>(.*)</title>";
	private static final String MOVIE_DURATION_PATTERN = "<time itemprop=\"duration\".*>(.*)</time>";
	private static final String MOVIE_RATING_PATTERN = "<span itemprop=\"ratingValue\">(.*?)</span>";
	private static final String MOVIE_VOTES_PATTERN = "<span itemprop=\"ratingCount\".*>(.*)</span>";
	private static final String MOVIE_GENRE_PATTERN = "<span class=\"itemprop\" itemprop=\"genre\">(.*)</span>";

	public String parseMovieName(String outputLine) {
		Pattern p = Pattern.compile(MOVIE_NAME_PATTERN);
		// Pattern p = Pattern.compile("</.*?>");
		Matcher m = p.matcher(outputLine);

		if (m.find()) {
			// String name = m.group(1).split("(")[0];
			// String year = m.group(1).split("(")[1].split(")")[0];
			// /return "movie name is :" + name + "year is :" + year;
			return m.group(1).split("\\(")[0].toString();
		}

		else
			return null;
	}

	public String parseMovieYear(String outputLine) {
		Pattern p = Pattern.compile(MOVIE_YEAR_PATTERN);
		// Pattern p = Pattern.compile("</.*?>");
		Matcher m = p.matcher(outputLine);

		if (m.find()) {
			// String name = m.group(1).split("(")[0];
			// String year = m.group(1).split("(")[1].split(")")[0];
			// /return "movie name is :" + name + "year is :" + year;
			return m.group(1).split("\\(")[1].toString().split("\\)")[0];
		}

		else
			return null;
	}

	public String parseMovieDuration(String outputLine) {
		Pattern p = Pattern.compile(MOVIE_DURATION_PATTERN);
		// Pattern p = Pattern.compile("</.*?>");
		Matcher m = p.matcher(outputLine);

		if (m.find()) {
			return m.group(1);
		}

		else
			return null;
	}

	public String parseMovieRating(String outputLine) {
		Pattern p = Pattern.compile(MOVIE_RATING_PATTERN);
		// Pattern p = Pattern.compile("</.*?>");
		Matcher m = p.matcher(outputLine);

		if (m.find()) {
			return m.group(1);
		}

		else
			return null;
	}

	public String parseMovieVotes(String outputLine) {
		Pattern p = Pattern.compile(MOVIE_VOTES_PATTERN);
		// Pattern p = Pattern.compile("</.*?>");
		Matcher m = p.matcher(outputLine);

		if (m.find()) {
			return m.group(1);
		}

		else
			return null;
	}

	public String parseMovieGenre(String outputLine) {
		Pattern p = Pattern.compile(MOVIE_GENRE_PATTERN);
		// Pattern p = Pattern.compile("</.*?>");
		Matcher m = p.matcher(outputLine);
		String movieGenre = "";

		while (m.find()) {
			movieGenre += m.group(1) + ", ";
		}

		return movieGenre.substring(0, movieGenre.length() - 2);
	}

}
