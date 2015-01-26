import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MovieInfoHelper extends MovieStore {

	@Override
	public void createMovieInfo() {

		final HttpUrlConnectionServiceImpl urlConnect = new HttpUrlConnectionServiceImpl();
		FileIOServiceImpl ioService = new FileIOServiceImpl();
		// MovieInfoParserServiceImpl parser = new MovieInfoParserServiceImpl();

		// ArrayList<Movie> movieInfo = new ArrayList<Movie>();
		ArrayList<String> movieTitleList = ioService.readTitleId();
		ioService.clearMovieInfo();
		// System.out.println(movieTitleList.size());
		final ExecutorService executorService = Executors
				.newFixedThreadPool(10);

		for (final String title : movieTitleList) {

			executorService.execute(new Runnable() {
				public void run() {
					// urlConnect.getHtmlFromUrl(title);
					urlConnect.getHtmlFromUrl(title);
				}
			});

			/*
			 * Future future = executorService.submit(new Runnable() { public
			 * void run() { System.out.println("Asynchronous task"); } });
			 * 
			 * try { System.out.println(future.get()); } catch
			 * (InterruptedException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } catch (ExecutionException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */

			/*
			 * if(executor.isShutdown()) {
			 * System.out.println("now i m shutdown"); } /*Movie movie = new
			 * Movie();
			 * 
			 * movie.setMovieName(parser.parseMovieName(rawHtml));
			 * movie.setMovieYear(parser.parseMovieYear(rawHtml));
			 * movie.setMovieDuration(parser.parseMovieDuration(rawHtml));
			 * movie.setMovieRating(parser.parseMovieRating(rawHtml));
			 * movie.setMovieVotes(parser.parseMovieVotes(rawHtml));
			 * movie.setMovieGenre(parser.parseMovieGenre(rawHtml));
			 */

			// movieInfo.add(movie);
		}
		executorService.shutdown();
		try {
			executorService.awaitTermination(30, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// do anything you want after executor has finished
		// ioService.writeMovieInfo(movieInfo);
		// TODO Auto-generated method stub

	}
}
