package Libraries;

import java.util.Properties;

public abstract class LoanObjectsPattern extends LoanObjects{
	
	private LoanObjects loanObject;
	private String type;
	
	public LoanObjectsPattern(LoanObjects loanObject, String type) {
		this.loanObject = loanObject;
		this.type = type;
	}
	
	public void printAllData(Properties prop) {
		System.out.print(this.characteristic());
	}
	
	public abstract String characteristic();

	public LoanObjects getLoanObject() {
		return loanObject;
	}

	public void setLoanObject(LoanObjects loanObject) {
		this.loanObject = loanObject;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
