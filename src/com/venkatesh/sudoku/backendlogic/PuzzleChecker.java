package com.venkatesh.sudoku.backendlogic;



public class PuzzleChecker {

	public static boolean isPuzzleFilled(int[][] puzzle) {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle.length; j++) {
				if(puzzle[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public static boolean isNumberValidInRow(int row, int currentColumn, int number, int[][] puzzle) {
		for (int j = 0; j < puzzle.length; j++) {
			if (j != currentColumn) {
				if(puzzle[row][j] == number)
					return false;
			}
		}
		return true;
	}

	public static boolean isNumberValidInColumn(int currentrow, int Column, int number, int[][] puzzle) {
		for (int i = 0; i < puzzle.length; i++) {
			if (i != currentrow) {
				if(puzzle[i][Column] == number)
					return false;
			}
		}
		return true;
	}

	private static boolean isNumberValidInBox(int row, int column, int number, int[][] puzzle)
	{
		int cornerX = row - row%3;
		int cornerY = column - column%3;
		for(int i = cornerX; i < cornerX+3; i++)
		{
			for(int j = cornerY; j < cornerY+3; j++)
			{
				if((i != row) && (j != column))
				{
					if(puzzle[i][j] == number)
						return false;					
				}

			}
		}
		return true;
	}

	public static boolean isPuzzleFilledCorrectly(int row, int column, int number, int[][] puzzle) {

		if((isNumberValidInRow(row, column, number, puzzle)) && (isNumberValidInColumn(row, column, number, puzzle)) && (isNumberValidInBox(row, column, number, puzzle)))
			return true;
		else {
			return false;
		}

	}

}
