package Libraries;

import static org.junit.jupiter.api.Assertions.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.jupiter.api.Test;

class InternationalizationTest {

	@Test
	public void testLabels_en_UK_properties() {
		Properties prop = new Properties();
		InputStream labels = null;

		try {
			labels = new FileInputStream("Labels.properties");
			prop.load(labels);
		}catch(IOException e) {}
		
		assertEquals("Introduce your firstname: ", prop.getProperty("Introduce_firstname"));
	}
	
	@Test
	public void testLabels_es_ES_properties() {
		Properties prop = new Properties();
		InputStream labels = null;

		try {
			labels = new FileInputStream("Labels_es_ES.properties");
			prop.load(labels);
		}catch(IOException e) {}
		
		assertEquals("Introduce tu nombre: ", prop.getProperty("Introduce_firstname"));
	}
	
	@Test
	public void testLabels_ja_JP_properties() {
		Properties prop = new Properties();
		InputStream labels = null;

		try {
			labels = new FileInputStream("Labels_ja_JP.properties");
			prop.load(labels);
		}catch(IOException e) {}
		
		assertEquals("Anata no na o shokai shite kudasai: ", prop.getProperty("Introduce_firstname"));
	}
	
	@Test
	public void testLabels_de_DE_properties() {
		Properties prop = new Properties();
		InputStream labels = null;

		try {
			labels = new FileInputStream("Labels_de_DE.properties");
			prop.load(labels);
		}catch(IOException e) {}
		
		assertEquals("Geben Sie Ihren Vornamen ein: ", prop.getProperty("Introduce_firstname"));
	}
}
