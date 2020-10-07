import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.*;
public class Baseball_Standings {
	public static void Welcome() {
		System.out.println("***********************************");
		System.out.println("*   BASEBALL STANDINGS ANALYZER   *");
		System.out.println("***********************************");
		System.out.println("This program reads a file that");
		System.out.println("contains current baseball standings");
		System.out.println("and adds to more detail statistics.");
		System.out.println("It also prints overall standings in");
		System.out.println("the American and National league.");
	}
	public static int Menu(Scanner sc) {
		System.out.println("Which standings would you like to see?");
		System.out.println("1. AL East");
		System.out.println("2. AL Centeral");
		System.out.println("3. AL West");
		System.out.println("4. NL East");
		System.out.println("5. NL Centeral");
		System.out.println("6. NL West");
		System.out.println("7. Overall");
		System.out.println("8. Exit");
		System.out.print("Enter the number of your choice:");
		int choice = sc.nextInt();
		return choice;
	}
	public static double WinningPrc(String line) {
		String [] parts = line.split("\t");
		double win = Double.parseDouble(parts[1]);
		double lose = Double.parseDouble(parts[2]);
		double prc = win /(win + lose);
		return prc;
		
	}
	public static void Stats(ArrayList<String> everyTeam) {
		String[] parts;
		double prc;
		System.out.println("Team         wins	loses	Pct.	behind");
		System.out.println("------------------------------------------");
		for(String team : everyTeam) {
			parts = team.split("\t");
			prc = WinningPrc(team);
			System.out.printf("%13s	%.3f	%.3f	%.3f",parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), prc);
				
				
			}
		}
	
	public static void insertByWinningPrc(ArrayList<String> everyTeam, String line) {
		double this_prc = WinningPrc(line);
		double other_prc;
		int pos = -1;
		for (int i = 0; i < everyTeam.size(); i++) {
			other_prc = WinningPrc(everyTeam.get(i));
			if (this_prc > other_prc) {
				pos = i;
				break;
			}
			
		}
		if (pos < 0) {
			everyTeam.add(line);
		}
		else {
			everyTeam.add(pos,line);
		}
			
	}
	public static void main(String args[]) {
		Welcome();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the standing file:");
		String fileName = sc.nextLine();
		ArrayList<String> AL_East = new ArrayList<String>();
		ArrayList<String> AL_Centeral = new ArrayList<String>();
		ArrayList<String> AL_West = new ArrayList<String>();
		ArrayList<String> NL_East = new ArrayList<String>();
		ArrayList<String> NL_Centeral = new ArrayList<String>();
		ArrayList<String> NL_West = new ArrayList<String>();
		ArrayList<String> target = null;
		ArrayList<String> everyTeam = new ArrayList<String>();
		String[] parts;
		String league;
		String line;
		int choice;
		try {
			Scanner fsc = new Scanner(new File(fileName));
				while (fsc.hasNextLine()) {
					line = fsc.nextLine();
					parts = line.split("\t");
					if (parts[0].equalsIgnoreCase("League")) {
						league = parts[1];
						if (league.equalsIgnoreCase("AL East")) {
						target = AL_East;
						}
						else if (league.equalsIgnoreCase("AL Centeral")) {
							target = AL_Centeral;
						}
						else if (league.equalsIgnoreCase("AL West")) {
							target = AL_West;
						}
						else if (league.equalsIgnoreCase("NL East")) {
							target = NL_East;
						}
						else if (league.equalsIgnoreCase("NL Centeral")) {
							target = NL_Centeral;
						}
						else if (league.equalsIgnoreCase("NL West")) {
							target = NL_West;
						}
							
					}
					else {
						target.add(line);
						insertByWinningPrc(everyTeam, line);
					}
			}
			fsc.close();
		
		}catch (Exception ex) {
			System.out.println("Could not read the file.");
			ex.printStackTrace();
			 
		}
		do {
			choice = Menu(sc);
			if (choice == 1) {
				Stats(AL_East);
			}
			else if (choice == 2) {
				Stats(AL_Centeral);
			}
			else if (choice == 3) {
				Stats(AL_West);
			}
			else if (choice == 4) {
				Stats(NL_East);
			}
			else if (choice == 5) {
				Stats(NL_Centeral);
			}
			else if (choice == 6) {
				Stats(NL_West);
			}
			else if (choice == 7) {
				System.out.print(everyTeam);
			}
			else if (choice == 8) {
				System.out.print("");
			}
		}while (choice != 8);

 }
}


