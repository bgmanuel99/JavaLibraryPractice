package Libraries;

import java.util.Calendar;
import java.util.Properties;

public abstract class ObjectsOnLoan implements ObjectsInterface{

	private int dayOfLoan, monthOfLoan, yearOfLoan, hourOfLoan, minuteOfLoan;
	private String name, genre, publicationMonth;
	private int publicationDay, publicationYear;
	private int dayOfDeliver;
	private final int hourOfDeliver, minuteOfDeliver;

	public ObjectsOnLoan(String name, int publicationDay, String publicationMonth, int publicationYear, String genre, int dayOfLoan, int monthOfLoan, int yearOfLoan, int hourOfLoan, int minuteOfLoan) {
		this.name = name;
		this.publicationDay = publicationDay;
		this.publicationMonth = publicationMonth;
		this.publicationYear = publicationYear;
		this.genre = genre;
		this.dayOfLoan = dayOfLoan;
		this.monthOfLoan = monthOfLoan;
		this.yearOfLoan = yearOfLoan;
		this.hourOfLoan = hourOfLoan;
		this.minuteOfLoan = minuteOfLoan;
		this.dayOfDeliver = 14;
		this.hourOfDeliver = 23;
		this.minuteOfDeliver = 59;
	}

	public int[] getTimeOnLoan() {
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int thisMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int thisDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

		int totalMonths = 0, months = 0;
		int totalDays = 0, days = 0;

		int [] time = new int[4];
		if(thisYear >= this.yearOfLoan) {
			int totalYear = thisYear - this.yearOfLoan;
			if(thisMonth < this.monthOfLoan) {
				totalYear -= 1;
				totalMonths = Math.abs(thisMonth - this.monthOfLoan);
				months = 12 - totalMonths;
				if(thisDay < this.dayOfLoan) {
					months -= 1;
					totalDays = Math.abs(totalDays - this.dayOfLoan);
					days = 31 - totalDays;
				}else if(thisDay >= this.dayOfLoan) {
					days = thisDay - this.dayOfLoan;
				}
			}else if(thisMonth >= this.monthOfLoan) {
				months = thisMonth - this.monthOfLoan;
				if(thisDay < this.dayOfLoan) {
					months -= 1;
					totalDays = Math.abs(totalDays - this.dayOfLoan);
					days = 31 - totalDays;
				}else if(thisDay >= this.dayOfLoan) {
					days = thisDay - this.dayOfLoan;
				}
			}

			time[0] = days;
			time[1] = months;
			time[2] = totalYear;
			time[3] = 1;
		}else {
			time[0] = 0;
			time[1] = 0;
			time[2] = 0;
			time[3] = 0;
		}

		return time;
	}

	public boolean[] overPassedTime(int [] time) {
		boolean[] overPassedTime = new boolean[2];
		if(time[3] == 0 && time[2] == 0 && time[1] == 0 && time[0] == 0) {
			overPassedTime[0] = false;
			overPassedTime[1] = true;
		}else {
			if(time[2] > 0) {
				overPassedTime[0] = true;
				overPassedTime[1] = false;
			}else if((time[1] > 0) && (time[0] > 11)) {
				overPassedTime[0] = true;
				overPassedTime[1] = false;
			}else if(time[0] > this.dayOfDeliver) {
				overPassedTime[0] = true;
				overPassedTime[1] = false;
			}else {
				overPassedTime[0] = false;
				overPassedTime[1] = false;
			}
		}

		return overPassedTime;
	}

	public int sanctions(int [] time) {
		int timeOfSanction = 0;
		if((time[2] == 0) && (time[1] == 0) && (time[0] == 0)) {
			timeOfSanction = 1000;
		}else if(time[2] >= 1) timeOfSanction = 0;
		else {
			if(time[1] >= 8) timeOfSanction = 12;
			else if(time[1] >= 6) timeOfSanction = 8;
			else if(time[1] >= 3) timeOfSanction = 5;
			else if(time[1] >= 1) timeOfSanction = 3;
			else {
				if(time[0] > 25) timeOfSanction = 2;
				else if(time[0] > 20) timeOfSanction = 1;
				else if(time[0] >= 14) timeOfSanction = 14;
			}
		}
		return timeOfSanction;
	}

	public int[] dateOfDeliver() {
		int [] time = new int[3];
		int maxTime = this.dayOfDeliver;

		int years = this.yearOfLoan;
		int month = this.monthOfLoan;
		int day = this.dayOfLoan + maxTime;
		
		int totalDays = 0, totalMonths = 0, totalYears = 0;
		
		if(day > 31) {
			totalDays = day - 31;
			totalMonths += 1;
		}else {
			totalDays = day;
		}
		
		if((month + totalMonths) > 12) {
			totalYears += 1;
			totalMonths = 1;
		}else {
			totalMonths += month;
		}
		
		years = years + totalYears;

		time[0] = totalDays;
		time[1] = totalMonths;
		time[2] = years;

		return time;
	}

	public int[] timeToDeliver(int [] time) {
		int yearOfWithdrawn = time[2];
		int monthOfWithdrawn = time[1];
		int dayOfWithdrawn = time[0];

		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int thisMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int thisDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

		int months = 0, days = 0;
		int totalMonths = 0, totalDays = 0;

		int [] timeToWithdrawn = new int[3];
		if(thisYear <= yearOfWithdrawn) {
			int totalYear = yearOfWithdrawn - thisYear;
			if(thisMonth <= monthOfWithdrawn) {
				months = monthOfWithdrawn - thisMonth;
				if(thisDay <= dayOfWithdrawn) {
					days = dayOfWithdrawn - thisDay;
				}else if(thisDay > dayOfWithdrawn) {
					totalDays = Math.abs(dayOfWithdrawn - thisDay);
					days = 31 - totalDays;
				}
			}else if(thisMonth > monthOfWithdrawn) {
				totalMonths = Math.abs(monthOfWithdrawn - thisMonth);
				months = 12 - totalMonths;
				if(thisDay <= dayOfWithdrawn) {
					days = dayOfWithdrawn - thisDay;
				}else if(thisDay > dayOfWithdrawn) {
					totalDays = Math.abs(dayOfWithdrawn - thisDay);
					days = 31 - totalDays;
				}
			}

			timeToWithdrawn[0] = days;
			timeToWithdrawn[1] = months - 1;
			timeToWithdrawn[2] = totalYear;
		}

		return timeToWithdrawn;
	}

	abstract public void printAllData(Properties prop);

	abstract public void printData(Properties prop);

	public void extendLoanTime() {
		this.dayOfDeliver += 14;
	}

	public int getDayOfDeliver() {
		return dayOfDeliver;
	}

	public void setDayOfDeliver(int dayOfDeliver) {
		this.dayOfDeliver = dayOfDeliver;
	}

	public int getHourOfDeliver() {
		return hourOfDeliver;
	}

	public int getMinuteOfDeliver() {
		return minuteOfDeliver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublicationMonth() {
		return publicationMonth;
	}

	public void setPublicationMonth(String publicationMonth) {
		this.publicationMonth = publicationMonth;
	}

	public int getPublicationDay() {
		return publicationDay;
	}

	public void setPublicationDay(int publicationDay) {
		this.publicationDay = publicationDay;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public int getDayOfLoan() {
		return dayOfLoan;
	}

	public void setDayOfLoan(int dayOfLoan) {
		this.dayOfLoan = dayOfLoan;
	}

	public int getMonthOfLoan() {
		return monthOfLoan;
	}

	public void setMonthOfLoan(int monthOfLoan) {
		this.monthOfLoan = monthOfLoan;
	}

	public int getYearOfLoan() {
		return yearOfLoan;
	}

	public void setYearOfLoan(int yearOfLoan) {
		this.yearOfLoan = yearOfLoan;
	}

	public int getHourOfLoan() {
		return hourOfLoan;
	}

	public void setHourOfLoan(int hourOfLoan) {
		this.hourOfLoan = hourOfLoan;
	}

	public int getMinuteOfLoan() {
		return minuteOfLoan;
	}

	public void setMinuteOfLoan(int minuteOfLoan) {
		this.minuteOfLoan = minuteOfLoan;
	}
}
