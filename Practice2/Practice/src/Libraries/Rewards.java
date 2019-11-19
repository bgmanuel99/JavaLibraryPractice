package Libraries;

public class Rewards <T>{
	
	private T value;
	
	public Rewards(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
