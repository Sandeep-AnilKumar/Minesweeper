package com.minesweeper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.minesweeper.Mine;

/**
 * @author sandeepa
 */

public class Game {
    final int rows;
    final int cols;
    final int players;
    final Mine[][] tiles;
    final boolean[][] visited;
    final Set<String> unvisited;
    final Set<String> mines;
    Map<Integer, Mine> mineMap;
    Random rand;
    final int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

    public Game(int rows, int cols, int players) {
        this.rows = rows;
        this.cols = cols;
        this.players = players;

        mineMap = new HashMap<>();
        mineMap.put(0, Mine.DANGER);
        mineMap.put(1, Mine.CAUTION);
        mineMap.put(2, Mine.SAFE);

        tiles = new Mine[rows][cols];
        visited = new boolean[rows][cols];

        unvisited = new HashSet<>();
        mines = new HashSet<>();

        propogateAllSafe();

        rand = new Random(System.currentTimeMillis());
        int numMines = rand.nextInt(rows) + 1;
        int i = 0;
        int j = 0;

        while(numMines > 0) {
            i = rand.nextInt(rows);
            j = rand.nextInt(cols);

            if(tiles[i][j] == Mine.SAFE || tiles[i][j] == Mine.CAUTION) {
                tiles[i][j] = Mine.DANGER;
                mines.add(i + ":" + j);
                propogateCaution(i, j);
                numMines--;
            }
        }
    }

    public void propogateCaution(int row, int col) {
        for(int[] direction : dir) {
            if(row + direction[0] >= 0 && col + direction[1] >= 0 && row + direction[0] < rows && col + direction[1] < cols && tiles[row + direction[0]][col + direction[1]] == Mine.SAFE) {
                tiles[row + direction[0]][col + direction[1]] = Mine.CAUTION;
            }
        }
    }

    public void propogateAllSafe() {
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                unvisited.add(i + ":" + j);
                tiles[i][j] = Mine.SAFE;
            }
        }
    }

    public String printCurrentState(boolean reveal) {
        int width = 0;

        if(rows > 0) {
            width = 4 * cols;

            for(int i = 0; i < rows; ++i) {
                for(int k = 0; k <= width; ++k) {
                    System.out.print("-");
                }

                System.out.print("\n|");

                for(int j = 0; j < cols; ++j) {
                    if(visited[i][j] || reveal) {
                        System.out.print(" " + tiles[i][j].getState() + " |");

                    } else {
                        System.out.print("   |" );
                    }
                }

                System.out.println();
            }

            for(int k = 0; k <= width; ++k) {
                System.out.print("-");
            }
        }

        return "";
    }

    public void playGame() {
        System.out.println(printCurrentState(false));

        if(rows > 0 && cols > 0) {
            Scanner input = new Scanner(System.in);
            int row = 0;
            int col = 0;
            int curPlayer = 0;
            boolean result = false;

            while(!unvisited.equals(mines)) {
                if(players > 1) {
                    System.out.println("\nPlayer " + (curPlayer + 1) + "'s turn");
                }

                if(players == 1) {
                    System.out.println();
                }

                System.out.println("Enter the row and column number you want to reveal");

                curPlayer ^= 1;
                row = input.nextInt();
                col = input.nextInt();

                if(row < 0 || col < 0 || row >= rows || col >= cols) {
                    System.out.println("The row or column number entered is beyond the tiles size, please enter valid row and column number");
                    curPlayer ^= 1;
                    continue;

                } else if(visited[row][col]) {
                    System.out.println("You stepped on an already visited field");
                    curPlayer ^= 1;
                    continue;
                }

                if(tiles[row][col] == Mine.DANGER) {
                    System.out.print("GAME OVER! ");

                    if(players == 1) {
                        System.out.println("You lost!");

                    } else {
                        System.out.println("Player " + (curPlayer + 1) + " won the game");
                    }

                    System.out.println(printCurrentState(true));
                    result = true;
                    break;

                } else {
                    visited[row][col] = true;
                    unvisited.remove(row + ":" + col);
                    System.out.println(printCurrentState(false));
                }
            }

            if(!result) {
                System.out.println("The game was tied");
            }

            input.close();
        }
    }

    @Override
    public String toString() {
        return printCurrentState(true);
    }
}