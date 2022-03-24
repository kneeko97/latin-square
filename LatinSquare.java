import java.util.Arrays;

import java.io.*;

public class LatinSquare{

  public static void printBoard(int board [][]){ //Printing the board
    for (int[] row: board){
      System.out.println(Arrays.toString(row).replace(", ", "| "));

      for(int j = 0; j < board[0].length ; j++){ 
        System.out.print("---"); //Adding dividors for the rows
      }

      System.out.print("\n");
    }
  }

  public static int[] findEmptySquare(int board [][]) //returns the next empty square space on board
  {
    int[] position = new int[2];
    for (int row = 0; row < board.length; row++){
      for (int col = 0; col < board[row].length; col++){
        if(board[row][col] == 0){
          position[0] = row;
          position[1] = col;
          return position;
        }
      }
    }
    return null;
  }

  public static boolean isValid(int board[][], int input, int[ ] position) //checks element already exists in the row
  {
    //Horizontal Checker
    for(int i = 0; i < board[0].length; i++){
      if (board[position[0]][i] == input && position[1] != i)
        return false;
    }

    //Vertical Checker
    for(int j = 0; j < board.length; j++){
      if (board[j][position[1]] == input && position[0] != j)
        return false;
    }

    return true;
  }

  public static boolean foundSoln(int board [][])
  {
    System.out.println("**********************");
    printBoard(board);
    
    int[] position = new int[2];
    int[] find = findEmptySquare(board);
    if (find == null){
      return true;
    }
    else{
      position[0] = find[0];
      position[1] = find[1];
    }
    
    for(int i = 1; i <= board.length; i++){
      if (isValid(board, i, position)){
        
        board[position[0]][position[1]] = i;

        if (foundSoln(board)){
          return true;
        }

        board[position[0]][position[1]] = 0;
      }
    }
    return true;

  }

  public static void main(String[] args) throws IOException{
    int[][] board = {{1,3,2,4}, {4,1,3,2}, {0,0,0,0}, {0,0,0,0}};

    // System.out.println(Arrays.deepToString(board).replace("], ", "]\n")); // prints out the two-dim board

    printBoard(board);
    foundSoln(board);
    System.out.println("==========================");
    printBoard(board);
  }
}
  
