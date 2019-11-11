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
		String language = "en";
		String country = "UK";

		Properties prop = new Properties();
		InputStream labels = null;

		try {
			if(language.equals("en") && country.equals("UK")) {
				labels = new FileInputStream("Labels.properties");
			}else if(language.equals("es") && country.equals("ES")) {
				labels = new FileInputStream("Labels_es_ES.properties");
			}else if(language.equals("ja") && country.equals("JP")) {
				labels = new FileInputStream("Labels_ja_JP.properties");
			}
			prop.load(labels);
		}catch(IOException e) {
			System.out.println(e.toString());
		}
		
		String expectedResult = "Introduce your firstname: ";
		String realResult = prop.getProperty("Introduce_firstname");
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testLabels_es_ES_properties() {
		String language = "es";
		String country = "ES";

		Properties prop = new Properties();
		InputStream labels = null;

		try {
			if(language.equals("en") && country.equals("UK")) {
				labels = new FileInputStream("Labels.properties");
			}else if(language.equals("es") && country.equals("ES")) {
				labels = new FileInputStream("Labels_es_ES.properties");
			}else if(language.equals("ja") && country.equals("JP")) {
				labels = new FileInputStream("Labels_ja_JP.properties");
			}
			prop.load(labels);
		}catch(IOException e) {
			System.out.println(e.toString());
		}
		
		String expectedResult = "Introduce tu nombre: ";
		String realResult = prop.getProperty("Introduce_firstname");
		
		assertEquals(expectedResult, realResult);
	}
	
	@Test
	public void testLabels_ja_JP_properties() {
		String language = "ja";
		String country = "JP";

		Properties prop = new Properties();
		InputStream labels = null;

		try {
			if(language.equals("en") && country.equals("UK")) {
				labels = new FileInputStream("Labels.properties");
			}else if(language.equals("es") && country.equals("ES")) {
				labels = new FileInputStream("Labels_es_ES.properties");
			}else if(language.equals("ja") && country.equals("JP")) {
				labels = new FileInputStream("Labels_ja_JP.properties");
			}
			prop.load(labels);
		}catch(IOException e) {
			System.out.println(e.toString());
		}
		
		String expectedResult = "Anata no na o shokai shite kudasai: ";
		String realResult = prop.getProperty("Introduce_firstname");
		
		assertEquals(expectedResult, realResult);
	}
}
