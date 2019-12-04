package Libraries;

import java.util.Hashtable;
import java.util.Calendar;

public class MyException {
	
	private Hashtable<String,String> errors;
	private String [][] multidimensionalDatesArray;
	
	public MyException() {
		String [] days = new String[31];
		String [] months = new String[12];
		String [] years = new String[70];
		int j = 0;
		for(int i = 0; i < 31; i++) {
			days[i] = (String.valueOf(i+1));
		}
		for(int i = 0; i < 12; i++) {
			months[i] = (String.valueOf(i+1));
		}
		for(int i = (Calendar.getInstance().get(Calendar.YEAR) - 69); i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
			years[j] = (String.valueOf(i));
			j++;
		}
		this.multidimensionalDatesArray = new String[][]{days, months, years};
		this.errors = new Hashtable<String,String>();
		this.errors.put("ErrorLanguageCountry", "There are no languages or countrys with the codes: ");
		this.errors.put("ErrorIntegerOutOfBounds", "There are no options for your election.");
		this.errors.put("ErrorBirthDates", "Wrong parameters for the birth dates.");
		this.errors.put("ErrorObjectNotFound", "You dont have any item with that data.");
		this.errors.put("ErrorToMuchTime", "You have taken too long to return the item, you can no longer make loans in this library");
		this.errors.put("ErrorOverpassedTime","You overpassed the time of the loan, the item is removed");
		this.errors.put("ErrorTwoTimesLoan","You already extend the loan time of the item two times, you cant extend it more.");
		this.errors.put("ErrorWrongYearData","The years data are wrong, the operation can not be resolved.");
		this.errors.put("ErrorHaveSanctions","You cant borrow any object while having sanctions.");
		this.errors.put("ErrorHaveNoProducts","You dont have products on your shopping basket.");
	}
	
	public String getException(String error) {
		return this.errors.get(error);
	}

	public Hashtable<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Hashtable<String, String> errors) {
		this.errors = errors;
	}

	public String[][] getMultidimensionalDatesArray() {
		return multidimensionalDatesArray;
	}

	public void setMultidimensionalDatesArray(String[][] multidimensionalDatesArray) {
		this.multidimensionalDatesArray = multidimensionalDatesArray;
	}
}
