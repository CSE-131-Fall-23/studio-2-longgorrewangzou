package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How much money do you want to start with?");
		int startAmount = in.nextInt();
		double winChance = 0.5;
		int winLimit = (startAmount + 50);
		int dayLost = 0;
		int dayWin = 0;
		double ratio = (double)startAmount/winLimit;
		double expectedruin = 1.00 - ratio;
		for (int totalsimulations = 1; totalsimulations <= 30; totalsimulations++) {
			int newAmount = startAmount;
			while (0 < newAmount && newAmount < winLimit) {
				double prob = Math.random();
				if (prob < winChance) {
					newAmount = newAmount + 1;
				} else {
					newAmount = newAmount - 1;
				}
			}
			if (newAmount == winLimit) {
				System.out.println("Simulation " + totalsimulations + ": won!");
				dayWin = (dayWin + 1);
			} else {
				System.out.println("Simulation " + totalsimulations + ": lost");
				dayLost = (dayLost + 1);
			}
		}
		System.out.println("Days won:" + dayWin);
		System.out.println("Days lost:" + dayLost);
		double ruinrate = dayLost/30.00;
		System.out.println("Expected ruin rate: " + expectedruin);
		System.out.println("Actual ruin rate: " + ruinrate);
		
		
	}
}
