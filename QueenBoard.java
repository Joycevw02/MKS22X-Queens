public class QueenBoard{

  private int[][] board;
  private int side;

  public QueenBoard(int size){
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
      return false;
    }
    else{
      board[r][c] = -1;
      int i = 1;
      while (r + i < side || r - i >= 0 || c + i < side){
        if (r + i < side && c + i < side){
          board[r + i][c + i] += 1;
        }
        if (r - i >= 0 && c + i < side){
          board[r - i][c + i] += 1;
        }
        if (c + i < side){
          board[r][c + i] += 1;
        }
      }
      return true;
    }
  }

  private boolean removeQueen(int r, int c){

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

 /**
 *@return false when the board is not solveable and leaves the board filled with zeros;
 *        true when the board is solveable, and leaves the board in a solved state
 *@throws IllegalStateException when the board starts with any non-zero value

 */
 public boolean solve(){

 }

 /**
 *@return the number of solutions found, and leaves the board filled with only 0's
 *@throws IllegalStateException when the board starts with any non-zero value
 */
 public int countSolutions(){

 }
}
