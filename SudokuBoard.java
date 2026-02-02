import java.util.Scanner;
// Xander Gordon
// CS 143
// HW #1: Sudoku #1 (Board Setup) - 2D Arrays Practice
//
// SudokuBoard.java will simulate setting up a game of classic 
// Sudoku. This program will store the board in a 9x9 2D Array and 
// will have a toString method that can print the board out in 
// orderly fashion when called to do so. 


import java.io.File;
import java.io.FileNotFoundException;

public class SudokuBoard {

   int[][] board = new int[9][9];
   
   // pre: fileName is the name of an exisiting file
   // post: contents from inputed file is organized into the 
   //       9x9 2D Array varible - board
   public SudokuBoard (String fileName) throws FileNotFoundException {
      Scanner input = new Scanner(new File(fileName));
      String sequence = ""; 
       
      while (input.hasNextLine()) {
         sequence += input.nextLine(); 
      }
      
      for (int i = 0; i < 81; i++) {
         int col = i%9;
         int row = (i-col)/9;
         String value = sequence.substring(i, i+1); 
         if (value.equals(".")) {
            board[row][col] = 0;
         } else {
            board[row][col] = Integer.parseInt(value);
         }
      }
   }
   
   // pre: none
   // post: a 9x9 grid representing the contents of the board 2D Array
   //       is returned in the form of a multi-line, organized Strinng
   public String toString () {
      String output = "";
      for (int row = 0; row < 9; row++) {
         for (int col = 0; col < 9; col++) {
            output += board[row][col] + " ";
         }
         output += "\n";
      }
      return output;
   }
   
}