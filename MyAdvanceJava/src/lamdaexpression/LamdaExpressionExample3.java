package lamdaexpression;

interface Test {
	int sum(int a, int b);
}

public class LamdaExpressionExample3 {

	public static void main(String[] args) {

		Test t = (a, b) -> (a + b);
		System.out.println("Sum = " + t.sum(10, 20));

		Test t1 = (int a, int b) -> (a + b);
		System.out.println("Sum = " + t1.sum(100, 200));

		Test ad1 = (a, b) -> (a + b);
		System.out.println("Sum = " + ad1.sum(40, 20));

		Test ad2 = (int a, int b) -> {
			return (a + b);
		};
		System.out.println("Sum = "+ad2.sum(200, 200));

	}

}
