package Libraries;

public class HardBookCover extends LoanObjectsPattern{
	
	public HardBookCover(LoanObjects loanObject, String type) {
		super(loanObject, type);
	}
	
	public String characteristic() {
		return super.getType();
	}
}
