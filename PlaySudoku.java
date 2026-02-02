// Xander Gordon
// CS 143
// HW #1: Sudoku #1 (Board Setup) - 2D Arrays Practice
//
// PlaySudoko.java will test the class SudokuBoard.java


import java.io.FileNotFoundException;

public class PlaySudoku {
   
   // pre: the file data1-1-1.sdk exists
   // post: the SudokuBoard toString method is tested 
   public static void main(String[] args) throws FileNotFoundException {
      SudokuBoard myBoard = new SudokuBoard("data1-1-1.sdk");
      System.out.println(myBoard);
   }

}



//jGrasp Output:

/*
 ----jGRASP exec: java PlaySudoku
 2 0 0 1 0 5 0 0 3 
 0 5 4 0 0 0 7 1 0 
 0 1 0 2 0 3 0 8 0 
 6 0 2 8 0 7 3 0 4 
 0 0 0 0 0 0 0 0 0 
 1 0 5 3 0 9 8 0 6 
 0 2 0 7 0 1 0 6 0 
 0 8 1 0 0 0 2 4 0 
 7 0 0 4 0 2 0 0 1 
 
 
  ----jGRASP: Operation complete.
*/