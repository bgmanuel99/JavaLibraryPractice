package Libraries;

public class Xbox extends LoanObjectsPattern{
	
	public Xbox(LoanObjects loanObject, String type) {
		super(loanObject, type);
	}
	
	public String characteristic() {
		return super.getType();
	}
}
