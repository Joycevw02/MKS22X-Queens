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
    side = size;
  }
  private boolean addQueen(int r, int c){
    if (board[r][c] != 0){
      System.out.println("Cannot add queen (" + r + "," + c + ")");
      return false;
    }
    //Horizontal Square
    for (int i = r; i < side; i++) {
           board[r][i] += 1;
       }
    //Diagonal to the lower right
    for (int i = 0; r + i < side && c + i < side; i++){
        board[r + i][c + i] += 1;
    }
    //Diagonal to the upper right
    for (int i = 0; r - i >= 0 && c + i < side; i++){
      board[r - i][c + i] += 1;
    }
    board[r][c] = -1;
    return true;
  }

  private boolean removeQueen(int r, int c){
    if (board[r][c] != -1){
      System.out.println("No queen to remove at (" + r + "," + c + ")");
      return false;
    }
    //Horizontal Square
    for (int i = r + 1; i < side; i++) {
           board[r][i] -= 1;
       }
    //Diagonal to the lower right
    for (int i = 0; r + i < side && c + i < side; i++){
        board[r + i][c + i] -= 1;
    }
    //Diagonal to the upper right
    for (int i = 0; r - i >= 0 && c + i < side; i++){
      board[r - i][c + i] -= 1;
    }
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
          throw new IllegalStateException();
        }
      }
    }
  }

  public boolean help(int row){
    
  }

 /**
 *@return the number of solutions found, and leaves the board filled with only 0's
 *@throws IllegalStateException when the board starts with any non-zero value
 */
// public int countSolutions(){
//
// }
  public static void main(String ans[]){
    QueenBoard test = new QueenBoard(5);
    System.out.println(test.debug());
    System.out.println("______________________");
    test.addQueen(2,1);
    System.out.println(test.debug());
    System.out.println("______________________");
    test.addQueen(2,2);
    test.addQueen(2,3);
    System.out.println("______________________");
    test.removeQueen(2,2);
    System.out.println(test.debug());
    System.out.println("______________________");
    test.removeQueen(2,3);
  }
}
