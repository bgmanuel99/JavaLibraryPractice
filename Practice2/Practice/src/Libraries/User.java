package Libraries;
import java.util.Calendar;
import java.util.Properties;
import java.util.Vector;

public class User {

	private String firstName, lastName, ID, sex, email, password;
	private int birthDay, birthMonth, birthYear;
	private int dayOfRegister, monthOfRegister, yearOfRegister;
	private Vector<ObjectsOnLoan> objectsOnLoan;
	private Vector<Sanctions> sanctions;
	private Vector<Rewards> rewards;
	private boolean [] extendLoanTime;
	private final int [] rewardArray;

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
		this.objectsOnLoan = new Vector<ObjectsOnLoan>();
		this.sanctions = new Vector<Sanctions>();
		this.rewards = new Vector<Rewards>();
		this.extendLoanTime = new boolean[]{false, false};
		this.dayOfRegister = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		this.monthOfRegister = Calendar.getInstance().get(Calendar.MONTH) + 1;
		this.yearOfRegister = Calendar.getInstance().get(Calendar.YEAR);
		this.rewardArray = new int[] {1, 2, 4, 5, 7};
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

	public void printData(Properties prop) {
		System.out.println(prop.getProperty("User_firstname") + this.firstName);
		System.out.println(prop.getProperty("User_lastname") + this.lastName);
		System.out.println(prop.getProperty("User_dateOfBirth") + this.birthDay + " " + this.birthMonth + " " + this.birthYear + " (" + this.userAge() + " " + prop.getProperty("User_yearsOld") + ").");
		System.out.println(prop.getProperty("User_ID") + this.ID);
		System.out.println(prop.getProperty("User_email") + this.email);
		System.out.println(prop.getProperty("User_password") + this.password);
		System.out.println(prop.getProperty("User_sex") + this.sex);
		System.out.println(prop.getProperty("User_objectsOnLoan"));
		if(this.objectsOnLoan.size() > 0) {
			for(ObjectsOnLoan elem : objectsOnLoan) {
				System.out.println("  " + elem.getName());
			}
		}else {
			System.out.println(prop.getProperty("User_noObjectsOnLoan"));
		}
	}

	public void printObjectsOnLoan(Properties prop) {
		if(objectsOnLoan.size() > 0) {
			for(ObjectsOnLoan elem : objectsOnLoan) {
				System.out.println("  " + elem.getName());
			}
		}else {
			System.out.println(prop.getProperty("User_noObjectsOnLoan"));
		}
	}

	public boolean foundElem(String item) {
		for(ObjectsOnLoan elem : objectsOnLoan) {
			if(elem.getName().equals(item)) return true;
		}
		return false;
	}

	public ObjectsOnLoan getObjectOnLoan(String nameOfObject) {
		for(ObjectsOnLoan elem : objectsOnLoan) {
			if(elem.getName().equals(nameOfObject)) {
				return elem;
			}
		}
		return null;
	}

	public void extendLoanTime(ObjectsOnLoan object) {
		for(ObjectsOnLoan elem : objectsOnLoan) {
			if(elem.equals(object)) {
				elem.extendLoanTime();
			}
		}

		if(this.extendLoanTime[0] == false) {
			this.extendLoanTime[0] = true;
		}else {
			this.extendLoanTime[1] = true;
		}
	}

	public boolean extendTwoTimes() {
		for(boolean elem : extendLoanTime) {
			if(elem == false) return false;
		}
		return true;
	}

	public Vector<Vector<ObjectsOnLoan>> lateLoan() {
		Vector<Vector<ObjectsOnLoan>> allObjectsOnLoan = new Vector<Vector<ObjectsOnLoan>>();
		Vector<ObjectsOnLoan> lateLoanObjects = new Vector<ObjectsOnLoan>();
		Vector<ObjectsOnLoan> earlyLoanObjects = new Vector<ObjectsOnLoan>();

		for(ObjectsOnLoan elem : objectsOnLoan) {
			boolean[] overPassedTime = elem.overPassedTime(elem.getTimeOnLoan());
			if((overPassedTime[0] == true) || (overPassedTime[1] == true)) {
				lateLoanObjects.add(elem);
			}else if(overPassedTime[0] == false){
				earlyLoanObjects.add(elem);
			}
		}

		allObjectsOnLoan.add(0, lateLoanObjects);
		allObjectsOnLoan.add(1, earlyLoanObjects);
		return allObjectsOnLoan;
	}
	
	public void addSanction(Sanctions sanction) {
		this.sanctions.add(sanction);
	}
	
	public void removeSanction(Sanctions sanction) {
		this.sanctions.remove(sanction);
	}
	
	public void printSanctions(Properties prop) {
		int i = 1;
		if(sanctions.size() == 0) {
			System.out.println(prop.getProperty("User_noSanctions"));
		}else if(sanctions.size() > 0) {
			System.out.println(prop.getProperty("User_allYourSanctions"));
			for(Sanctions elem : sanctions) {
				int [] time = elem.timeToWithdrawn(elem.dateOfWithdrawn());
				if(elem.getTimeOfSanction() == 14) {
					System.out.print(i + "." + elem.getNameOfObject() + ", " + prop.getProperty("User_timeOfSanction") + elem.getTimeOfSanction() + prop.getProperty("User_time") + ", " + prop.getProperty("User_timeToWithdrawn"));
					System.out.println(time[0] + " " + prop.getProperty("User_time") + ".");
				}else {
					System.out.println(i + "." + elem.getNameOfObject() + ", " + prop.getProperty("User_timeOfSanction") + elem.getTimeOfSanction() + prop.getProperty("User_time2") + ", " + prop.getProperty("User_timeToWithdrawn"));
					if(time[1] != 0) {
						System.out.println(time[1] + " " + prop.getProperty("User_time1") + time[0] + prop.getProperty("User_time") + ".");
					}else {
						System.out.println(time[0] + " " + prop.getProperty("User_time") + ".");
					}
				}
				i++;
			}
		}
	}
	
	public String totalAmountOfSanctions() {
		int monthsSum = 0;
		int daysSum = 0;
		String sanction = "";
		for(Sanctions elem : sanctions) {
			int time = elem.getTimeOfSanction();
			if(time == 14) {
				daysSum += time;
			}else {
				monthsSum += time;
			}
		}
		
		int days = 0, months = 0, years = 0;
		int countDays = 0;
		for(int i = 0; i < daysSum; i++) {
			countDays++;
			if(countDays == 31) {
				monthsSum++;
				daysSum -= 31;
				countDays = 0;
			}
		}
		int countMonths = 0;
		for(int i = 0; i < monthsSum; i++) {
			countMonths++;
			if(countMonths == 12) {
				years += 1;
				monthsSum -= 12;
				countMonths = 0;
			}
		}
		
		days = daysSum;
		months = monthsSum;
		
		if(years == 0) {
			sanction = months + " months and " + days + " days.";
		}else {
			sanction = years + " years, " + months + " months, " + days + " days.";
		}
		return sanction;
	}
	
	public void printTimeToDeliver(Properties prop) {
		int i = 1;
		if(objectsOnLoan.size() > 0) {
			System.out.println("User_timeToDeliver");
			for(ObjectsOnLoan elem : objectsOnLoan) {
				int [] timeToDeliver = elem.timeToDeliver(elem.dateOfDeliver());
				System.out.print(i + "." + elem.getName() + ", " + prop.getProperty("User_timeOfLoan") + elem.getDayOfDeliver() + ", " + prop.getProperty("User_timeToDeliver"));
				if(timeToDeliver[1] == 0) {
					System.out.println(timeToDeliver[0] + " " + prop.getProperty("User_time"));
				}else {
					System.out.println(timeToDeliver[1] + " " + prop.getProperty("User_time1") + timeToDeliver[0] + prop.getProperty("User_time") + ".");
				}
			}
		}else {
			System.out.println(prop.getProperty("User_noObjectsOnLoan"));
		}
	}
	
	public void printAllData(Properties prop) {
		for(ObjectsOnLoan elem : objectsOnLoan) {
			if(elem.getClass().getSimpleName().equals("BooksOnLoan")) {
				elem.printAllData(prop);
			}
		}
		
		for(ObjectsOnLoan elem : objectsOnLoan) {
			if(elem.getClass().getSimpleName().equals("VideoGamesOnLoan")) {
				elem.printAllData(prop);
			}
		}
	}
	
	public int[] totalDaysRegistered() {
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int thisMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int thisDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

		int totalMonths = 0, months = 0;
		int totalDays = 0, days = 0;

		int [] time = new int[4];
		if(thisYear >= this.yearOfRegister) {
			int totalYear = thisYear - this.yearOfRegister;
			if(thisMonth < this.monthOfRegister) {
				totalYear -= 1;
				totalMonths = Math.abs(thisMonth - this.monthOfRegister);
				months = 12 - totalMonths;
				if(thisDay < this.dayOfRegister) {
					months -= 1;
					totalDays = Math.abs(totalDays - this.dayOfRegister);
					days = 31 - totalDays;
				}else if(thisDay >= this.dayOfRegister) {
					days = thisDay - this.dayOfRegister;
				}
			}else if(thisMonth >= this.monthOfRegister) {
				months = thisMonth - this.monthOfRegister;
				if(thisDay < this.dayOfRegister) {
					months -= 1;
					totalDays = Math.abs(totalDays - this.dayOfRegister);
					days = 31 - totalDays;
				}else if(thisDay >= this.dayOfRegister) {
					days = thisDay - this.dayOfRegister;
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
	
	public int timeToDays(int [] time) {
		int totalYears = time[2];
		int totalMonths = time[1];
		int totalDays = time[0];
		
		for(int i = 0; i < totalYears; i++) {
			totalDays += 365;
		}
		
		for(int i = 0; i < totalMonths; i++) {
			totalDays += 31;
		}
		
		return totalDays;
	}
	
	public boolean haveReward(int data) {
		int reward = 1;
		int numRandom = 0;
		
		if(data >= 1000) {
			numRandom = (int) Math.floor(Math.random()*100 + 1);
		}else if(data >= 800) {
			numRandom = (int) Math.floor(Math.random()*500 + 1);
		}else if(data >= 400) {
			numRandom = (int) Math.floor(Math.random()*1000 + 1);
		}else if(data >= 200) {
			numRandom = (int) Math.floor(Math.random()*2000 + 1);
		}else if(data >= 100) {
			numRandom = (int) Math.floor(Math.random()*2500 + 1);
		}else if(data >= 50) {
			numRandom = (int) Math.floor(Math.random()*5000 + 1);
		}else if(data >= 25) {
			numRandom = (int) Math.floor(Math.random()*10000 + 1);
		}
		
		if(reward == numRandom) return true;
		return false;
	}
	
	public boolean wonAPrize() {
		int [] arrayForReward = new int[5];
		
		for(int i = 0; i < arrayForReward.length; i++) {
			int randomNumberInt = (int) Math.floor(Math.random()*11 + 1);
			arrayForReward[i] = randomNumberInt;
		}
		
		int [] sortedArray = bubbleSort(arrayForReward);
		
		if(sortedArray.equals(this.rewardArray)) return true;
		return false;
	}
	
	public int[] bubbleSort(int [] array) {
		int number = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[i]) {
					number = array[i];
					array[i] = array[j];
					array[j] = number;
				}
			}
		}
		
		return array;
	}
	
	public Vector<Vector<Rewards>> separateRewards(){
		Vector<Vector<Rewards>> rewards = new Vector<Vector<Rewards>>();
		Vector<Rewards> integerRewards = new Vector<Rewards>();
		Vector<Rewards> stringRewards = new Vector<Rewards>();
		
		for(Rewards elem : this.rewards) {
			if(elem.getValue().getClass().getSimpleName().equals("Integer")) {
				integerRewards.add(elem);
			}else if(elem.getValue().getClass().getSimpleName().equals("String")) {
				stringRewards.add(elem);
			}
		}
		
		rewards.add(0, integerRewards);
		rewards.add(1, stringRewards);
		
		return rewards;
	}
	
	public void useIntegerRewards(Vector<Rewards> rewards) {
		for(int i = 0; i < rewards.size(); i++) {
			if(this.sanctions.size() > 0) {
				this.sanctions.removeElementAt(i);
				this.rewards.removeElementAt(i);
			}else break;
		}
	}
	
	public void extendRewardObjectsTime(String objectsName) {
		for(ObjectsOnLoan elem : this.objectsOnLoan) {
			if(elem.getName().equals(objectsName)) {
				elem.extendLoanTime();
			}
		}
	}
	
	public <T> void addReward(Rewards<T> reward) {
		this.rewards.add(reward);
	}
	
	public <T> void removeReward(Rewards<T> reward) {
		this.rewards.remove(reward);
	}

	public void removeAllObjectsOnLoan() {
		this.objectsOnLoan.removeAllElements();
	}

	public void addObjectOnLoan(ObjectsOnLoan object) {
		this.objectsOnLoan.add(object);
	}

	public void removeObjectOnLoan(ObjectsOnLoan object) {
		this.objectsOnLoan.remove(object);
	}
	
	public int getDayOfRegister() {
		return dayOfRegister;
	}

	public void setDayOfRegister(int dayOfRegister) {
		this.dayOfRegister = dayOfRegister;
	}

	public int getMonthOfRegister() {
		return monthOfRegister;
	}

	public void setMonthOfRegister(int monthOfRegister) {
		this.monthOfRegister = monthOfRegister;
	}

	public int getYearOfRegister() {
		return yearOfRegister;
	}

	public void setYearOfRegister(int yearOfRegister) {
		this.yearOfRegister = yearOfRegister;
	}

	public Vector<Rewards> getRewards() {
		return rewards;
	}

	public void setRewards(Vector<Rewards> rewards) {
		this.rewards = rewards;
	}

	public Vector<Sanctions> getSanctions() {
		return sanctions;
	}

	public void setSanctions(Vector<Sanctions> sanctions) {
		this.sanctions = sanctions;
	}

	public boolean[] getExtendLoanTime() {
		return extendLoanTime;
	}

	public void setExtendLoanTime(boolean[] extendLoanTime) {
		this.extendLoanTime = extendLoanTime;
	}

	public Vector<ObjectsOnLoan> getObjectsOnLoan() {
		return objectsOnLoan;
	}

	public void setObjectsOnLoan(Vector<ObjectsOnLoan> objectsOnLoan) {
		this.objectsOnLoan = objectsOnLoan;
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
