package Libraries;

import java.util.Calendar;

public class Sanctions {
	private String nameOfObject;
	private int timeOfSanction;
	private int returnDay, returnMonth, returnYear;

	public Sanctions(String nameOfObject, int timeOfSanction, int returnDay, int returnMonth, int returnYear) {
		this.nameOfObject = nameOfObject;
		this.timeOfSanction = timeOfSanction;
		this.returnDay = returnDay;
		this.returnMonth = returnMonth;
		this.returnYear = returnYear;
	}

	public int[] dateOfWithdrawn() {
		int [] time = new int[3];
		int sanction = this.timeOfSanction;
		
		int years = this.returnYear;
		int month = this.returnMonth;
		int day = this.returnDay;
		
		if(sanction == 14) {
			for(int i = 0; i < sanction; i++) {
				day++;
				if(day == 31) {
					month++;
					day = 0;
				}
			}
			time[0] = day;
			time[1] = month;
			time[2] = years;
		}else{
			for(int i = 0; i < sanction; i++) {
				month++;
				if(month == 12) {
					years++;
					month = 0;
				}
			}
			time[0] = day;
			time[1] = month;
			time[2] = years;
		}
		
		return time;
	}
	
	public int[] timeToWithdrawn(int [] time) {
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

	public int getReturnDay() {
		return returnDay;
	}

	public void setReturnDay(int returnDay) {
		this.returnDay = returnDay;
	}

	public int getReturnMonth() {
		return returnMonth;
	}

	public void setReturnMonth(int returnMonth) {
		this.returnMonth = returnMonth;
	}

	public int getReturnYear() {
		return returnYear;
	}

	public void setReturnYear(int returnYear) {
		this.returnYear = returnYear;
	}

	public String getNameOfObject() {
		return nameOfObject;
	}

	public void setNameOfObject(String nameOfObject) {
		this.nameOfObject = nameOfObject;
	}

	public int getTimeOfSanction() {
		return timeOfSanction;
	}

	public void setTimeOfSanction(int timeOfSanction) {
		this.timeOfSanction = timeOfSanction;
	}
}
