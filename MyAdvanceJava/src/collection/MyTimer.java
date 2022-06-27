package collection;

public class MyTimer {
	
static long startTime,endTime;

	public static void startTime() {
		startTime = System.nanoTime();
	}
	
	
	public static void endTime() {
		endTime = System.nanoTime();
		System.out.println("Total execution time = "+(endTime-startTime));
	}

}
