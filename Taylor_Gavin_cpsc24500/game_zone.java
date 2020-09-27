import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author gavin
 *
 */
public class game_zone {
	/**
	 * This function is the menu
	 * Here you will choose what game it is you want to play
	 * @param sc
	 * @return choice
	 */
	public static int menu(Scanner sc) {
		int choice;
		try {
			System.out.println("What would you like to play?");
			System.out.println("1. Twenty-one");
			System.out.println("2. Rock, Paper, Scissors");
			System.out.println("3. Neither - I'm done!");
			System.out.println("Please enter the number of your choice:");
			choice = sc.nextInt();
		}catch (Exception ex) {
				sc.nextLine();
				choice = 0;
			}
		return choice;
	}
	/**
	 * This is the twenty-one game
	 * in this game the computer get a random card from 13 to 21
	 * and the user get a random card 1 to 11
	 * and can get an additanl card or decline 
	 * if the user get 21 the win
	 * if they go over 21 the lose 
	 * in every other case if the user number is greater than the computers
	 * they win
	 * @param sc
	 */
	public static void twenty_one(Scanner sc){
		String Do_again;
		int low = 13;
		int high = 21;
		int yt_number = 0;
		Random y_number = new Random();
		int x = y_number.nextInt(12);
		Random c_number = new Random();
		int y = c_number.nextInt(high - low) + low;
		yt_number = x + yt_number;
		System.out.printf("You drew %d\n",yt_number);
		System.out.print("Would you like another card?(y or n)\n");
		Do_again = sc.next().trim().toLowerCase();
		do{
			if (Do_again.equals("y")) {
				x = y_number.nextInt(12);
				yt_number = x + yt_number;
				if (yt_number == 21) {
					System.out.println("You got 21 you win!");
					Do_again = "n";
				}
				else if (yt_number > 21) {
					System.out.printf("You currently have %d, which is over 21.\nYou lose!",yt_number);
					Do_again = "n";
				}	
				else{
					System.out.printf("Your current total is %d\n",yt_number);
					System.out.print("Would you like to draw another card? (y or n)\n");
					Do_again = sc.next();
					Do_again = Do_again.toLowerCase().trim();
					if (Do_again.equals("n")) {
						if (yt_number > y) {
							System.out.printf("Your current total is %d\n",yt_number);
							System.out.printf("The computer drew %d.", y);
							System.out.println("You win!");					
						}
						else {
							System.out.printf("Your current total is %d\n",yt_number);
							System.out.printf("The computer drew %d.", y);
							System.out.println("You lose!");
						}
					}
				}
				}
			}while (Do_again.equalsIgnoreCase("y"));
		
		}
	/**
	 * This is Rock, Paper, Scissors
	 * Same rules as usual
	 * rock beats scissors
	 * scissors beats paper
	 * paper beats rock
	 * @param sc
	 */
	public static void rock_paper_scissors(Scanner sc){
		String [] arr = {"rock", "paper","scissors"};
			Random x = new Random();
			int you = x.nextInt(arr.length);
			Random y = new Random();
			int comp = y.nextInt(arr.length);
			if (comp != you) {
				if (you == 0 && comp == 1) {
					System.out.println("You played " + arr[you]+", and the computer played "+ arr[comp]);
					System.out.println("You lose!");
				}
				else if (you == 0 && comp == 2) {
					System.out.println("You played " + arr[you]+", and the computer played "+ arr[comp]);
					System.out.println("You win!");
				}
				else if (you == 1 && comp == 0 ) {
					System.out.println("You played " + arr[you]+", and the computer played "+ arr[comp]);
					System.out.println("You win!");
				}
				else if (you == 1 && comp == 2) {
					System.out.println("You played " + arr[you]+", and the computer played "+ arr[comp]);
					System.out.println("You lose!");
				}
				else if (you == 2 && comp == 0) {
					System.out.println("You played " + arr[you]+", and the computer played "+ arr[comp]);
					System.out.println("You lose!");
				}
				else if (you == 2 && comp == 1) {
					System.out.println("You played " + arr[you]+", and the computer played "+ arr[comp]);
					System.out.println("You win!");
				}
			}
			else {
				System.out.println("You played " + arr[you]+", and the computer played "+ arr[comp]);
				System.out.println("You tie!");
			}
		}
	/**
	 * This is the main part of the code
	 * this calls to the the last three functions
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("******************************************");
		System.out.println("*        Welcome to Game Zone            *");
		System.out.println("******************************************");
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			choice = menu(sc);
			if (choice == 1) {
				twenty_one(sc);
			}else if (choice == 2) {
				rock_paper_scissors(sc);
			}
		}while (choice != 3);
		System.out.println("Thanks for playing");
	}
}

