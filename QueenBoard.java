public class QueenBoard{

  private int[][] board;
  private int size;

  public QueenBoard(int size){
    //Set all the values on the board to 0
    for (int r = 0; r < size; r ++){
      for (int c = 0; c < size; c ++){
        board[r][c] = 0;
      }
    }
  }

  private boolean addQueen(int r, int c){
    if (board[r][c] != 0){
      return false;
    }
    else{
      return true;
  }

  private boolean removeQueen(int r, int c){

  }

  private void diagonal(int r, int c){

  }

  private void horizontal(int r, int c){

  }

  private void vertical(int r, int c){

  }

  /**
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
