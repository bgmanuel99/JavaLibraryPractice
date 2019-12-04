package Libraries;

public class PC extends LoanObjectsPattern{
	
	public PC(LoanObjects loanObject, String type) {
		super(loanObject, type);
	}
	
	public String characteristic() {
		return super.getType();
	}
}
