package Libraries;
import java.util.Calendar;

public class User {
	
	private String firstName, lastName, ID, sex, email, password;
	private int birthDay, birthMonth, birthYear;
	boolean loggedIn;
	
	public User(String firstName, String lastName, String ID, int birthDay, int birthMonth,
			    int birthYear, String sex, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.sex = sex;
		this.email = email;
		this.password = password;
		this.loggedIn = false;
	}
	
	public int userAge() {
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		int totalYear = year - birthYear;
		
		if(month < birthMonth) {
			totalYear -= 1;
		}else if(month == birthMonth){
			if(day < birthDay) {
				totalYear -= 1;
			}
		}
		
		return totalYear;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public int getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}

	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String _ID) {
		ID = _ID;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
