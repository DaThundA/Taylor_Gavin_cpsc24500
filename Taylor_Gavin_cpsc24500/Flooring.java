public class Flooring {
/**
 * This program will calculate the amount of floor boards are need for a particular room, and state how much it will cost and how much 
 * waste there will be
 */
/**
 * This Function is used to calculate the area of a rectangle
 */
public static double Rectangle(double L, double W) {
	double area = L * W;
	return area;
}
/**
 * This function is used to calculate the area a triangle
 */
public static double Triangle(double L, double W) {
	double area = .5 * L *W;
	return area;
}
/**
 * This function is used to calculate the area of the boards used on the floor.
 */
public static double Board(double L, double W) {
	double area = L * W;
	return area;
}
/**
 * this function is used to find the total number of boxes of flooring that is need for each shape
 */
public static double BoxConversion(double BoardArea, double ShapeArea, double PreBox) {
	double boxes = (ShapeArea / BoardArea)/ PreBox;
	return boxes;
}
/**
 * This function is used to find the total cost of all the boxes
 */
public static double Cost(double boxes, double Cost) {
	double pay = boxes * Cost;
	return pay;
}
public static void main(String[] args) {
	System.out.println("This Program will calculate how many boxes of flooring tiles you will need as well how much is will coast you.");
	double PreBox = 6;
	double Pay = 24.99;
	double Length_B = 30;
	double Wieth_B = 6;
	double Length_T = 144;
	double Wieth_T = 120;
	double Length_R1 = 300;
	double Wieth_R1 = 120;
	double Length_R2 = 156;
	double Wieth_R2 = 120;
	double Rectangle_1 = Rectangle(Length_R1, Wieth_R1);
	double Rectangle_2 = Rectangle(Length_R2, Wieth_R2);
	double Tri = Triangle(Length_T, Wieth_T);
	double BoardArea = Board(Length_B, Wieth_B);
	double BoxesR_1 = BoxConversion(BoardArea, Rectangle_1, PreBox);
	double BoxesR_2 = BoxConversion(BoardArea, Rectangle_2, PreBox);
	double BoxesT = BoxConversion(BoardArea, Tri, PreBox);
	double R_1Box = Math.ceil(BoxesR_1);
	double R_2Box = Math.ceil(BoxesR_2);
	double T_Box = Math.ceil(BoxesT);
	double Total_B = R_1Box + R_2Box + T_Box;
	double Payment = Cost(Total_B, Pay);
	System.out.printf("The total amount of box that you will need to get is %.0f.\n", Total_B);
	System.out.printf("This means that your total is $%.2f.\n", Payment);
	
}
}

