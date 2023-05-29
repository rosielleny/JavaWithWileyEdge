
public class CalculateFactorial {

	private int number;
	private long factorial;
	
	public void setNumber(int number) {
		
		this.number = number;
	}
	
	public long getFactorial() {
		
		calculateFactorial();
		
		return factorial;
	}

	private void calculateFactorial() {
		
	    factorial = 1;
	    for (int i = 1; i <= number; i++) {
	       factorial *= i;
        }
	}
}
