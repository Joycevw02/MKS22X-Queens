public class QueenBoard{

  private int[][] board;
  private int side;

  public QueenBoard(int size){
    board = new int[size][size];
    //Set all the values on the board to 0
    for (int r = 0; r < size; r ++){
      for (int c = 0; c < size; c ++){
        board[r][c] = 0;
      }
    }
    //Sets side as the size for future use
    side = size;
  }

  private boolean addQueen(int r, int c){
    //If the location for the Queen isn't 0, then return false; because the queen
    //cannot be put there
    if (board[r][c] != 0){
//      System.out.println("Cannot add queen (" + r + "," + c + ")");
      return false;
    }
    //Increase the threat levels of the horizontal squares
    for (int i = r; i < side; i++) {
           board[r][i] += 1;
       }
    //Increase the threat levels of lower right diagonal squares
    for (int i = 0; r + i < side && c + i < side; i++){
        board[r + i][c + i] += 1;
    }
    //Increase the threat levels of upper right diagonal squares
    for (int i = 0; r - i >= 0 && c + i < side; i++){
      board[r - i][c + i] += 1;
    }
    //Set the square to -1 to indicate that there is a queen at that location
    //and return true
    board[r][c] = -1;
    return true;
  }

  private boolean removeQueen(int r, int c){
    //If the location is not -1, it does not have a queen, so there is nothing
    //to remove
    if (board[r][c] != -1){
//      System.out.println("No queen to remove at (" + r + "," + c + ")");
      return false;
    }
    //Decrease the threat levels of the horizontal squares
    for (int i = r + 1; i < side; i++) {
           board[r][i] -= 1;
       }
    //Decrease the threat levels of lower right diagonal squares
    for (int i = 0; r + i < side && c + i < side; i++){
        board[r + i][c + i] -= 1;
    }
    //Decrease the threat levels of upper right diagonal squares
    for (int i = 0; r - i >= 0 && c + i < side; i++){
      board[r - i][c + i] -= 1;
    }
    //Set the square back to 0, to indicate that there is no longer a queen in
    //that location and return true
    board[r][c] = 0;
    return true;
  }


  /*
 *@return The output string formatted as follows:
 *All numbers that represent queens are replaced with 'Q'
 *all others are displayed as underscores '_'
 *There are spaces between each symbol:
 *"""_ _ Q _
 *Q _ _ _
 *_ _ _ Q
 *_ Q _ _"""
 *(pythonic string notation for clarity,
 *excludes the character up to the *)
 */

  public String toString(){
    String ans = "";
    for (int row = 0; row < side; row ++){
      for (int col = 0; col < side; col ++){
        if (board[row][col] == -1){
          ans += "Q ";
        }
        else{
          ans += "_ ";
        }
      }
      ans += "\n";
    }
    return ans;
  }

   private String debug(){
     String ans = "";
     for (int row = 0; row < side; row ++){
       for (int col = 0; col < side; col ++){
         if (board[row][col] == -1){
           ans += "Q ";
         }
         else if (board[row][col] == 0){
           ans += "_ ";
         }
         else{
           ans += "X ";
         }
       }
       ans += "\n";
     }
     return ans;
  }

/*
 *@return false when the board is not solveable and leaves the board filled with zeros;
 *        true when the board is solveable, and leaves the board in a solved state
 *@throws IllegalStateException when the board starts with any non-zero value
*/

  public boolean solve(){
    for (int row = 0; row < side; row ++){
      for (int col = 0; col < side; col ++){
        if (board[row][col] != 0){
          throw new IllegalStateException("Cannot solve a non-empty board");
        }
      }
    }
    return help(0);
  }

  private boolean help(int col){
    //If the col is the last column, return true since there were no errors
    if (col == board.length){
      return true;
    }
    //For each row in that column, if help one column over is returns true to addQueen,
    //then return true
    for (int row = 0; row < side; row ++){
      if (addQueen(row,col)){
        if (help(col + 1)){
          return true;
        }
        removeQueen(row,col);
      }
    }
    return false;
  }

 /**
 *@return the number of solutions found, and leaves the board filled with only 0's
 *@throws IllegalStateException when the board starts with any non-zero value
 */

   public int countSolutions(){
     for (int row = 0; row < side; row ++){
       for (int col = 0; col < side; col ++){
         if (board[row][col] != 0){
           throw new IllegalStateException("Cannot count solutions on a non-empty board");
         }
       }
     }
     return counthelp(0);
   }

   private int counthelp(int col){
     //If it is a last column, return 1 because it has found a solution
     if (col == side){
       return 1;
     }
     //For each row in that column, is addQueen is successful, then add the counthelp
     //of the next row over to the current ans and return ans
     int ans = 0;
     for (int row = 0; row < side; row ++){
       if (addQueen(row,col)){
         ans += counthelp(col + 1);
       }
       removeQueen(row,col);
     }
     return ans;
   }


//  public static void main(String ans[]){
//    QueenBoard test = new QueenBoard(5);
//    System.out.println(test.debug());
//    System.out.println("______________________");
//    test.addQueen(2,1);
//    System.out.println(test.debug());
//    System.out.println("______________________");
//    test.addQueen(2,2);
//    test.addQueen(2,3);
//    System.out.println("______________________");
//    test.removeQueen(2,2);
//    System.out.println(test.debug());
//    System.out.println("______________________");
//    test.removeQueen(2,3);
//    test.help(0);
//    System.out.println(test.debug());
//    System.out.println(test.countSolutions());
// }
}
