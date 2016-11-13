/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rebekah
 */
public class Board {

	private int rows = 8;
	private int columns= 8;
        private char[][] board = createBoard();
 
	public Board(){

	} 

	//create 2-d array representing the board
	private char[][] createBoard(){
		char[][] board = new char[rows][columns];
		//set inital value of each block to 0(unmarked, empty block)
		for(int r =0; r < rows; r++){
			for(int c=0; c<columns; c++){
				board[r][c]=0;
			}
		}
                return board;
	}
	//marks block in array chosen by user
	public void placeChip(int column, char player){
		for(int r=0; r<rows; r++){
			//mark the first unmarked block in the column.
			if(board[r][column]==0){
				board[r][column]=player;
				break;
			}
		}
	}

	public boolean didSomeoneWin(int row, int column, char player){
		//horizontal check
		int chipsInARow =1;
		int currentColumn = column;
		//check for player chips to the right
		while(chipsInARow < 4 && board[row][currentColumn] == player){
			chipsInARow++;
			currentColumn++;
		}
		//check for player chips to the left
		while(chipsInARow <4 && board[row][currentColumn] == player){
			chipsInARow++;
			currentColumn--;
		}
		//winner! return true
		if(chipsInARow >=4){
			return true;
		}
		//else, reset chipsInARow, currentColumn and check vertical
		chipsInARow = 1;
		int currentRow = row;
		while(chipsInARow <4 && board[currentRow][column]==player){
			chipsInARow++;
			currentRow++;
		}
		while(chipsInARow<4 && board[currentRow][column]==player){
			chipsInARow++;
			currentRow--;
		}
		//winner! return true
		if(chipsInARow >=4){
			return true;
		}
		//else, reset chipsInARow& currentColumn& currentRow, and start diagonal check
		chipsInARow =1;
		currentRow= row;
		currentColumn= column;
		//start left to right diagonal check
		while(chipsInARow < 4 && board[currentRow][currentColumn] ==player){
			chipsInARow++;
			currentColumn++;
			currentRow--;
		}
		while(chipsInARow < 4 && board[currentRow][currentColumn] ==player){
			chipsInARow++;
			currentColumn--;
			currentRow++;
		}
		//winner! return true
		if(chipsInARow >=4){
			return true;
		}
		//else start right to left diagonal check
		while(chipsInARow < 4 && board[currentRow][currentColumn] ==player){
			chipsInARow++;
			currentColumn--;
			currentRow--;
		}
		while(chipsInARow < 4 && board[currentRow][currentColumn] ==player){
			chipsInARow++;;
			currentColumn++;
			currentRow++;
		}
		//winner! return true
		if(chipsInARow >=4){
			return true;
		}
		//if no winner yet, return false
		return false;
	}

	public char[][] getCurrentBoard(){
		return board;
	}


}

