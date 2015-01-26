import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileIOServiceImpl implements FileIOService {

	//private static final String HOME_DIRECTORY = "user.home";
	private static final String TITLE_FILE_NAME = "movie-title.txt";
	private static final String OUTPUT_FILE_NAME = "movie-info.txt";

	public ArrayList<String> readTitleId() {
		//String homeDirectory = System.getProperty(HOME_DIRECTORY);
		String fileName = TITLE_FILE_NAME;
		String movieTitle;
		BufferedReader fileReader;
		ArrayList<String> movieTitleList = new ArrayList<String>();

		try {
			fileReader = new BufferedReader(new FileReader(fileName));

			while ((movieTitle = fileReader.readLine()) != null) {
				movieTitleList.add(movieTitle);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return movieTitleList;
	}

	public void writeMovieInfo(Movie movieInfo) {

		try {

			//String homeDirectory = System.getProperty(HOME_DIRECTORY);
			String fileName = OUTPUT_FILE_NAME;
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(movieInfo.toString());
			bw.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("Done Writing Movie Info\n");

	}
	
	public void clearMovieInfo()
	{
		try {

			//String homeDirectory = System.getProperty(HOME_DIRECTORY);
			String fileName = OUTPUT_FILE_NAME;
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			bw.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * public void writeMovieInfo(ArrayList<Movie> movieInfo) {
	 * 
	 * for (Movie movie : movieInfo) { try {
	 * 
	 * String homeDirectory = System.getProperty(HOME_DIRECTORY); String
	 * fileName = OUTPUT_FILE_NAME; File file = new File(homeDirectory + "/" +
	 * fileName); FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
	 * BufferedWriter bw = new BufferedWriter(fw); bw.write(movie.toString());
	 * bw.close();
	 * 
	 * } catch (Exception ex) { ex.printStackTrace(); }
	 * 
	 * } System.out.println("Done Writing Movie Info");
	 * 
	 * }
	 */

}
