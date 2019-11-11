package Libraries;

import java.util.Calendar;
import java.util.Properties;
import java.util.Vector;

public class VideoGamesOnLoan extends ObjectsOnLoan{
	
	private String gameModes, lastVersion;
	private Vector<String> composers, developers, platforms;

	public VideoGamesOnLoan(String name, int publicationDay, String publicationMonth, int publicationYear, String genre, String gameModes, String lastVersion, Vector<String> composers, Vector<String> developers, Vector<String> platforms) {
		super(name,publicationDay,publicationMonth,publicationYear,genre,
				  Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
				  Calendar.getInstance().get(Calendar.MONTH) + 1,
				  Calendar.getInstance().get(Calendar.YEAR),
				  Calendar.getInstance().get(Calendar.HOUR),
				  Calendar.getInstance().get(Calendar.MINUTE));
		this.gameModes = gameModes;
		this.lastVersion = lastVersion;
		this.composers = composers;
		this.developers = developers;
		this.platforms = platforms;
	}
	
	public void printData(Properties prop) {
		System.out.println(prop.getProperty("Videogame_name") + super.getName());
		System.out.println(prop.getProperty("Videogame_publicationdate") + super.getPublicationDay() + " " + prop.getProperty("Videogame_publicationdate1") + super.getPublicationMonth() + " " + prop.getProperty("Videogame_publicationdate1") + super.getPublicationYear());
		System.out.println(prop.getProperty("Videogame_genre") + super.getGenre());
		System.out.println(prop.getProperty("Videogame_gameModes") + this.getGameModes());
		System.out.println(prop.getProperty("Videogame_lastversion") + this.getLastVersion());
		System.out.println(prop.getProperty("Videogame_composers"));
		for(String elem : composers) {
			System.out.println("  " + elem);
		}
		System.out.println(prop.getProperty("Videogame_developers"));
		for(String elem : developers) {
			System.out.println("  " + elem);
		}
		System.out.println(prop.getProperty("Videogame_platforms"));
		for(String elem : platforms) {
			System.out.println("  " + elem);
		}
		System.out.println(prop.getProperty("ObjectsOnLoan_date") + super.getDayOfLoan() + "/" + super.getMonthOfLoan() + "/" + super.getYearOfLoan() + " " + super.getHourOfLoan() + ":" + super.getMinuteOfLoan());
	}
	
	public void printAllData(Properties prop) {
		System.out.println(prop.getProperty("Videogame_name") + super.getName() + ", " + prop.getProperty("Videogame_lastversion1") + this.getLastVersion() + ", " + prop.getProperty("ObjectsOnLoan_date") + super.getDayOfLoan() + "/" + super.getMonthOfLoan() + "/" + super.getYearOfLoan() + " " + super.getHourOfLoan() + ":" + super.getMinuteOfLoan());
	}
	
	public String getGameModes() {
		return gameModes;
	}

	public void setGameModes(String gameModes) {
		this.gameModes = gameModes;
	}

	public String getLastVersion() {
		return lastVersion;
	}

	public void setLastVersion(String lastVersion) {
		this.lastVersion = lastVersion;
	}

	public Vector<String> getComposers() {
		return composers;
	}

	public void setComposers(Vector<String> composers) {
		this.composers = composers;
	}

	public Vector<String> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Vector<String> developers) {
		this.developers = developers;
	}

	public Vector<String> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(Vector<String> platforms) {
		this.platforms = platforms;
	}
}
