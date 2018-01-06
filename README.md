# Minesweeper
A minesweeper game in Java

#### The player can choose between number of rows and columns for the grid. And also the number of players (a maximum of 2).

The states of a mine can be:
#### a) Danger: A mine denoted by 'X'
#### b) Caution: A mine is adjacent to this tile, denoted by '!'
#### c) Safe: No mines nearby, denoted by '~'

The mines in the grid are laid out randomly and also the number of mines to be put into the grid is chosen randomly.
The caution tiles are then laid out to all the tiles adjacent to mines (danger), and finally everything else is a safe tile.

#### In a single player version, a player is playing to find out all non-mine tiles (safe plus caution tiles). Player wins if he succeeds in uncovering all non-mine tiles, loses if not.

#### Example runs for a single-player game:
##### a) A losing game:
```
Enter the number of mine field rows, minimum value is 1
2
Enter the number of mine field cols, minimum value is 1
2
Enter the number of players, minimum value is 1 and maximum value is 2
1
---------
|   |   |
---------
|   |   |
---------

Enter the row and column number you want to reveal
1 0
---------
|   |   |
---------
| ! |   |
---------

Enter the row and column number you want to reveal
0 0

GAME OVER! You lost!
---------
| X | ! |
---------
| ! | ! |
---------
```

##### b) A winning game:
```
Enter the number of mine field rows, minimum value is 1
2
Enter the number of mine field cols, minimum value is 1
2
Enter the number of players, minimum value is 1 and maximum value is 2
1
---------
|   |   |
---------
|   |   |
---------

Enter the row and column number you want to reveal
0 0
---------
| ! |   |
---------
|   |   |
---------

Enter the row and column number you want to reveal
1 0
---------
| ! |   |
---------
| ! |   |
---------

You have won!
---------
| ! | X |
---------
| ! | X |
---------
```

#### In a two player game, the first to step on a mine loses, if both the players dodge all the mines, and there are only mines left (i.e. they have uncovered all non-mine tiles) then the game is tied.

#### Example runs for a two player game:
##### a) A tied game:
```
Enter the number of mine field rows, minimum value is 1
2
Enter the number of mine field cols, minimum value is 1
2
Enter the number of players, minimum value is 1 and maximum value is 2
2
---------
|   |   |
---------
|   |   |
---------

Player 1's turn
Enter the row and column number you want to reveal
1 1
---------
|   |   |
---------
|   | ! |
---------

Player 2's turn
Enter the row and column number you want to reveal
1 0
---------
|   |   |
---------
| ! | ! |
---------

The game was tied
---------
| X | X |
---------
| ! | ! |
---------
```

##### b) A result game:
```
Enter the number of mine field rows, minimum value is 1
2
Enter the number of mine field cols, minimum value is 1
2
Enter the number of players, minimum value is 1 and maximum value is 2
2
---------
|   |   |
---------
|   |   |
---------

Player 1's turn
Enter the row and column number you want to reveal
0 0
---------
| ! |   |
---------
|   |   |
---------

Player 2's turn
Enter the row and column number you want to reveal
1 0

GAME OVER! Player 1 won the game
---------
| ! | X |
---------
| X | ! |
---------
```

