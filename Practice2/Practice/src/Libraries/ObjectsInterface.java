package Libraries;

import java.util.Properties;

public interface ObjectsInterface {
	public int[] getTimeOnLoan();
	public boolean[] overPassedTime(int [] time);
	public int sanctions(int [] time);
	public int [] dateOfDeliver();
	public int[] timeToDeliver(int [] time);
	abstract public void printAllData(Properties prop);
	abstract public void printData(Properties prop);
}
