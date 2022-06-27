package lamdaexpression;

interface Sum {
	public int sum();
}

public class LamdaExpressionExample2 {
	public static void main(String[] args) {
		
		Sum s = () -> {
			return 5 + 4;
		};

		System.out.println("Sum = "+s.sum());

	}

}
