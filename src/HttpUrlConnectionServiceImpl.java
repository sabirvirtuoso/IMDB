import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpUrlConnectionServiceImpl implements HttpUrlConnectionService {

	private static final String MAIN_URL = "http://www.imdb.com/title/";
	MovieInfoParserServiceImpl parser = new MovieInfoParserServiceImpl();
	FileIOServiceImpl ioService = new FileIOServiceImpl();

	/*
	 * public String getHtmlFromUrl(String title) { String inputLine; String
	 * outputLine = ""; try { URL url = new URL(MAIN_URL + title); URLConnection
	 * conn = url.openConnection();
	 * 
	 * BufferedReader br = new BufferedReader(new InputStreamReader(
	 * conn.getInputStream()));
	 * 
	 * while ((inputLine = br.readLine()) != null) { // bw.write(inputLine);
	 * outputLine += inputLine; outputLine += "\n"; } } catch
	 * (MalformedURLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	 * return outputLine; }
	 */
	public final void getHtmlFromUrl(String title) {
		String inputLine;
		String outputLine = "";
		try {
			URL url = new URL(MAIN_URL + title);
			URLConnection conn = url.openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));

			while ((inputLine = br.readLine()) != null) {
				// bw.write(inputLine);
				outputLine += inputLine;
				outputLine += "\n";
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		createMovie(outputLine);

	}

	public void createMovie(String outputLine) {
		Movie movie = new Movie();

		movie.setMovieName(parser.parseMovieName(outputLine));
		movie.setMovieYear(parser.parseMovieYear(outputLine));
		movie.setMovieDuration(parser.parseMovieDuration(outputLine));
		movie.setMovieRating(parser.parseMovieRating(outputLine));
		movie.setMovieVotes(parser.parseMovieVotes(outputLine));
		movie.setMovieGenre(parser.parseMovieGenre(outputLine));
		System.out.println(movie.toString());
		ioService.writeMovieInfo(movie);
	}

}
