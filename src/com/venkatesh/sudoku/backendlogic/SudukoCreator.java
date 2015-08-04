package com.venkatesh.sudoku.backendlogic;

import java.util.Random;

public class SudukoCreator {

	private final static int SIZE = 9;
	private int[][] board;

	public int[][] createBoard(int difficulty)
	{
		board = new int[SIZE] [SIZE];
		nextCell(0, 0);		
		makeHoles(difficulty);
		return board;
	}

	public boolean nextCell(int x, int y)
	{
		int nextX = x;
		int nextY = y;
		int[] suffledNumbers = suffleArrayNumbers();

		for(int i = 0; i < suffledNumbers.length; i++)
		{
			if(isNumberValidHere(x, y, suffledNumbers[i], board))
			{
				board[x][y] = suffledNumbers[i];
				if(x == 8)
					if(y == 8)
					{
						return true; // success done!
					}					
					else
					{
						nextX = 0;
						nextY = y + 1;
					}
				else
				{
					nextX = x + 1;
				}
				if(nextCell(nextX, nextY))
					return true;
			}				
		}
		board[x][y] = 0;
		return false;
	}

	public int[] suffleArrayNumbers()
	{
		int[] numbers = {1,2,3,4,5,6,7,8,9};
		int temp =0;
		int current = 0;
		Random random = new Random();
		int lengthOfArray = numbers.length;

		// Fished yath algorithm
		for(int i = lengthOfArray - 1; i > 0; i--)
		{
			current = random.nextInt(i);
			temp = numbers[current];
			numbers[current] = numbers[i];
			numbers[i] = temp;
		}
		return numbers;
	}

	public boolean isNumberValidHere(int row, int column, int number, int[][] puzzle)
	{
		if(!isNumberUsedInRow(row, number,puzzle) // checking with row 
				&& !isNumberUsedInColumn(column, number, puzzle) // checking with column
				&& !isNumberUsedInBox(row, column, number, puzzle)) // checking with box
			return true;
		else
			return false;
	}
	private boolean isNumberUsedInRow(int row, int number, int[][] puzzle)
	{
		for(int column = 0; column < SIZE; column++)
		{
			if(puzzle[row][column] == number)
				return true;
		}
		return false;
	}
	private boolean isNumberUsedInColumn(int column, int number, int[][] puzzle)
	{
		for(int row = 0; row < SIZE; row++)
		{
			if(puzzle[row][column] == number)
				return true;
		}
		return false;
	}
	public void makeHoles(int holesToMake)
	{
		/* I define difficulty as follows:
			Easy: 32+ clues (49 or fewer holes)
			Medium: 27-31 clues (50-54 holes)
			Hard: 26 or fewer clues (54+ holes)
			This is human difficulty, not algorighmically (though there is some correlation)
		 */
		double remainingSquares = 81;
		double remainingHoles = (double)holesToMake;

		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
			{
				double holeChance = remainingHoles/remainingSquares;
				if(Math.random() <= holeChance)
				{
					board[i][j] = 0;
					remainingHoles--;
				}
				remainingSquares--;
			}
	}

	private boolean isNumberUsedInBox(int row, int column, int number, int[][] puzzle)
	{
		int cornerX = row - row%3;
		int cornerY = column - column%3;
		for(int i = cornerX; i < cornerX+3; i++)
		{
			for(int j = cornerY; j < cornerY+3; j++)
			{
				if(puzzle[i][j] == number)
					return true;
			}
		}
		return false;
	}
}
