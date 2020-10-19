import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;
public class CovidPlotter {
	/**
	 * This function is takes in the file that the user gives,
	 * and in way that if you where to ask for a country which is
	 * the key there is data that comes with it.
	 * @param fsc
	 * @return
	 */
	public static LinkedHashMap<String, double[]> data(Scanner fsc){
		LinkedHashMap<String, double[]> result = new LinkedHashMap<String, double[]>();
		String line = fsc.nextLine();
		String [] parts = line.split("\t");
		String country;
		int count = parts.length - 1;
		double [] deathCount;
		while (fsc.hasNextLine()) {
			line = fsc.nextLine();
			parts = line.split("\t");
			country = parts[0];
			deathCount = new double[count];
			for (int i = 1; i < parts.length;i++) {
				deathCount[i-1] = Double.parseDouble(parts[i]);
			}
			result.put(country, deathCount);
		}
		return result;
	}
	/**
	 * This function takes in the list size of of death_count
	 * and turns that into the amount of days there are to help 
	 * with the graphing process.
	 * @param amount
	 * @return
	 */
	public static double[] days(int amount) {
		double [] result = new double[amount];
		for (int i = 0; i < amount; i++) {
			result[i] = i;
		}
		return result;
	}
	/**
	 * This is meant to define what we want for are graph
	 * the dimentions, where we want it, the name of the
	 * both axises, and title
	 * @param plot
	 */
	public static void frame(Plot2DPanel plot) {
		plot.setAxisLabels("days", "deaths");
		JFrame frm = new JFrame();
		frm.setTitle("Covid-19 Death");
		frm.setBounds(100, 100, 500, 500);
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(plot,BorderLayout.CENTER);
		frm.setVisible(true);
	}
	public static String destionMaker(Scanner sc) {
		String choice;
		System.out.print("[D]aily or [C]umulative?");
		choice = sc.nextLine();
		return choice;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the file:");
		String fileName = sc.nextLine();
		LinkedHashMap<String, double[]> data_country = null;
		String country;
		String choice;//This was going to be the varible used when the user made a choice for cumulative or daily
		String [] parts;
		double [] death_count;//this will be the list the holds the data depending on what keys the user uses
		double [] death_by_day = null;//this was going to be the list for the daily option
		try {
			Scanner fsc = new Scanner(new File(fileName));
			data_country = data(fsc);
			fsc.close();
		//This is here to make sure that if the file can't be read that it doesn't crash	
		}catch(Exception ex) {
			data_country = null;
		}
		if (data_country == null) {
			System.out.println("File could not be read.");
		}
		else {
			 do {
	                System.out.print("Enter names of countries you would like to see seperated by a comma: ");
	                country = sc.nextLine();
	                choice = destionMaker(sc);
	                if (!country.equalsIgnoreCase("quit")) {
	                    Plot2DPanel plot = new Plot2DPanel();
	                    plot.addLegend("SOUTH");
	                    parts = country.split(",");
	                    for (String part : parts) {
	                        part = part.trim();
	                        if (data_country.containsKey(part) == false) {
	                            System.out.printf("%s was not found.\n",part);
	                        } else {
	                        	if (choice.equalsIgnoreCase("D")) {//This gives you everything special with the daily count
	                        		 death_count = data_country.get(part);
	 	                             plot.addLinePlot(part,days(death_count.length),death_count);
	 	                             //Here we would have calculated deaths by day doin some thin like
	 	                             //for (int i = 1; i < death_count; i++){
	 	                             //		death_count [i] = death_count[i] - death_count[i-1];
	 	                             BaseLabel title = new BaseLabel("Daily Deaths",Color.BLUE, 0.5,1.1,1 );
	 	                             plot.addPlotable(title);
	                        	}
	                        	else if (choice.equalsIgnoreCase("C")) {//This gives you everything special about the cumulative count
	                        		 death_count = data_country.get(part);
	 	                             plot.addLinePlot(part,days(death_count.length),death_count);
	 	                             BaseLabel title = new BaseLabel("Cumulative Deaths",Color.BLUE, 0.5,1.1,1 );
	 	                             plot.addPlotable(title);
	                        	}
	                        }
	                    }
	                    //This prints out the graph that the user will see
	                    frame(plot);
	                }
	                //This closes the do loop
	            } while (!country.equalsIgnoreCase("quit"));
	        }
		System.out.println("The only task you have is to wear a mask.");
	    }
	}

		
		
		
	





