package Libraries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class VideoGamesTest {
	
	@Test
	public void testGetGameModes() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		
		assertEquals("Massively multiplayer online", videogame.getGameModes());
	}
	
	@Test
	public void testSetGameModes() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		
		assertEquals("Massively multiplayer online", videogame.getGameModes());
		
		videogame.setGameModes("single player");
		
		assertEquals("single player", videogame.getGameModes());
	}

	@Test
	public void testGetLastVersion() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		
		assertEquals("8.2.4", videogame.getLastVersion());
	}
	
	@Test
	public void testSetLastVersion() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		
		assertEquals("8.2.4", videogame.getLastVersion());
		
		videogame.setLastVersion("8.9.0");
		
		assertEquals("8.9.0", videogame.getLastVersion());
	}

	@Test
	public void testGetComposers() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		
		assertEquals(composers, videogame.getComposers());
	}
	
	@Test
	public void testSetComposers() {
		Vector<String> composers = new Vector<String>(), composers1 = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		composers1.add("Tracy B. Wush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		
		assertEquals(composers, videogame.getComposers());
		
		videogame.setComposers(composers1);
		
		assertEquals(composers1, videogame.getComposers());
	}

	@Test
	public void testGetDevelopers() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		
		assertEquals(developers, videogame.getDevelopers());
	}
	
	@Test
	public void testSetDevelopers() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), developers1 = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		developers1.add("Blizzard");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		
		assertEquals(developers, videogame.getDevelopers());
		
		videogame.setDevelopers(developers1);
		
		assertEquals(developers1, videogame.getDevelopers());
	}

	@Test
	public void testGetPlatforms() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		
		assertEquals(platforms, videogame.getPlatforms());
	}
	
	@Test
	public void testSetPlatforms() {
		Vector<String> composers = new Vector<String>(), developers = new Vector<String>(), platforms = new Vector<String>(), platforms1 = new Vector<String>();
		composers.add("Tracy W. Bush");
		developers.add("Blizzard Entertainment");
		platforms.add("Windows");
		platforms.add("Mac OS X");
		platforms1.add("Xbox 360");
		VideoGames videogame = new VideoGames("World of Warcraft", 23, "November", 2004, "Rol", 14, 5, "Massively multiplayer online", composers, developers, "8.2.4", platforms);
		
		assertEquals(platforms, videogame.getPlatforms());
		
		videogame.setPlatforms(platforms1);
		
		assertEquals(platforms1, videogame.getPlatforms());
	}
}
