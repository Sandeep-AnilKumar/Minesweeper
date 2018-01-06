package com.minesweeper;

import java.util.Scanner;

/**
 * @author sandeepa
 */

public class Minesweeper {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = 0;
		int cols = 0;
		int players = 0;

		while(rows <= 0) {
			System.out.println("Enter the number of mine field rows, minimum value is 1");
			rows = in.nextInt();
		}

		while(cols <= 0) {
			System.out.println("Enter the number of mine field cols, minimum value is 1");
			cols = in.nextInt();
		}

		while(players <= 0 || players > 2) {
			System.out.println("Enter the number of players, minimum value is 1 and maximum value is 2");
			players = in.nextInt();
		}

		Game curGame = new Game(rows, cols, players);
		curGame.playGame();
		in.close();
	}
}