package Libraries;

public class SoftBookCover extends LoanObjectsPattern{
	
	public SoftBookCover(LoanObjects loanObjects, String type) {
		super(loanObjects, type);
	}
	
	public String characteristic() {
		return super.getType();
	}
}
