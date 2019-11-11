package Libraries;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Calendar;

public class MyException {
	
	private Hashtable<String,String> errors;
	private Vector<String> days = new Vector<String>(), months = new Vector<String>(), years = new Vector<String>();
	
	public MyException() {
		for(int i = 1; i <= 31; i++) {
			this.days.add(String.valueOf(i));
		}
		for(int i = 1; i <= 12; i++) {
			this.months.add(String.valueOf(i));
		}
		for(int i = (Calendar.getInstance().get(Calendar.YEAR) - 69); i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
			this.years.add(String.valueOf(i));
		}
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
	}
	
	public String getException(String error) {
		return this.errors.get(error);
	}
	
	public Vector<String> getDays(){
		return this.days;
	}
	
	public Vector<String> getMonths(){
		return this.months;
	}
	
	public Vector<String> getYears(){
		return this.years;
	}
}
