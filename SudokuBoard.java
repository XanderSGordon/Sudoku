import java.util.Scanner;
// Xander Gordon
// CS 143
// HW #2: Sudoku #2 (isValid, isSolved) - 2D Arrays Practice
// 
// V1
// SudokuBoard.java will simulate setting up a game of classic 
// Sudoku. This program will store the board in a 9x9 2D Array and 
// will have a toString method that can print the board out in 
// orderly fashion when called to do so. 
//  
// V2
// This program can now also test whether the board is valid and solved

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class SudokuBoard {

   int[][] board = new int[9][9];
   
   
   // pre: fileName is the name of an exisiting file
   // post: contents from inputed file is organized into the 
   //       9x9 2D Array varible - board
   public MySudokuBoard (String fileName) throws FileNotFoundException {
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
            try {
               board[row][col] = Integer.parseInt(value);
            } 
            catch (NumberFormatException e) {
               board[row][col] = -1;
            }
         }
      }
   }
   
   // pre: none
   // post: returns true if the board is solved and false if not
   public boolean isSolved () {
      if (isValid()) {
         for (int[] row : board) {
            for (int value : row) {
               if (value == 0) {
                  return false;
               }
            }
         }
         return true;
      }
      return false;
   }
   
   // pre: none
   // post: returns try if the board is valid and false if not
   public boolean isValid () {
      if (hasValidValues()) {
         if (hasValidRows() && hasValidCols() && hasValidSquares()) {
            return true;
         }
      }
      return false;
   }
   
   // pre: none
   // post: returns true if all values in board are between 0 and 9 and false if not
   private boolean hasValidValues () {
      for (int[] row : board) {
         for (int value : row) {
            if (!(0 <= value && value <= 9)) {
               return false;
            }
         }
      }
      return true;
   }
   
   // pre: none
   // post: returns true if all rows in board are valid and false if not
   private boolean hasValidRows () {
      for (int[] row : board) {
         HashMap<Integer, Integer> map = new HashMap<>();
         for (int value : row) {
            if (map.containsKey(value)) {
               return false;
            } else {
               if (value != 0) {
                  map.put(value, 1);
               }
            }
         }
      }
      return true;
   } 
   
   // pre: none
   // post: returns true if all cols in board are valid and false if not
   private boolean hasValidCols () {
      for (int col = 0; col < 9; col++) {
         HashMap<Integer, Integer> map = new HashMap<>();
         for (int row = 0; row < 9; row++) {
            int value = board[row][col];
            if (map.containsKey(value)) {
               return false;
            } else {
               if (value != 0) {
                  map.put(value, 1);
               }
            }
         }
      }
      return true;
   } 
   
   // pre: none
   // post: returns true if a 3x3 mini squares in board are valid and false if not
   private boolean hasValidSquares () {
      for (int spot = 0; spot < 9; spot++) {
         HashMap<Integer, Integer> map = new HashMap<>();
         int startingRow = 3*(spot/3);
         for (int row = startingRow; row < startingRow+3; row++) {
            int startingCol = 3*(spot%3);
            for (int col = startingCol; col < startingCol+3; col++) {
               int value = board[row][col];
                  if (map.containsKey(value)) {
                  return false;
               } else {
                  if (value != 0) {
                     map.put(value, 1);
                  }
               }
            }
         }
      }  
      return true;
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