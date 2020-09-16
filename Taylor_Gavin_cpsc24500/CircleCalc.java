import java.util.Random;
public class CircleCalc {
	/**
	 * This program is going to be used to calculate
	 * the circumference and the area of a circle by
	 * a given random radius
	 */
	/**
	 * This function is used to calculate the circumference of the circle given the radius.
	 * @param x
	 */
	public static double circumference(double x) { 
		double circ = 2*3.14*x; 
		return circ;
		}
	/** 
	 * This function is used to calculate the area of the circle given the radius.
	 * @author gavin
	 * @param x
	 * @return
	 */
	public static double area(double x) {
		double area = 3.14*x*x;
		return area;
	}
	/**
	 * This is main portion of the program and class to the previous functions using the given
	 * radius then prints out the results from those functions.
	 */
	public static void main(String[] args) {
		Random radius = new Random();
		double x = radius.nextInt();
		double circ = circumference(x);
		double Ar = area(x);
		System.out.printf("The radius of the circle is %.2f.\n", x);
		System.out.printf("This means that you circumfrence is %.2f.\n", circ);
		System.out.printf("This also means that the area is %.2f.\n", Ar);
		
		
		
	}
}

