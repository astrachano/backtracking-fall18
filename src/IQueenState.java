
/**
 * Interface for an nxn board for the N-Queens problem. The interface
 * is meant to facilitate graphical/non-graphical views of a board.
 * @author ola
 *
 */
public interface IQueenState {
    
    /**
     * Determine if a queen can be placed at (row,col) on the board, return true 
     * if the queen can be placed without attack by previously placed queens, false otherwise.
     * @param row is row being considered for placement
     * @param col is column being considered for placement
     * @return true iff queen can be placed at (row,col) without attack by other queens placed
     */
    public boolean safeToPlace(int row, int col);
    
    /**
     * Set or unset a queen at (row,col) depending on value, e.g., value == true
     * means queen is placed at (row,col), otherwise queen is removed from (row,col)
     * @param row is row at which queen state is set
     * @param col is column at which queen state is set
     * @param value determines if queen is placed (true) or removed (false)
     */
    public void setQueen(int row, int col, boolean value);
    
    /**
     * Print some version of the board indicating where queens are placed.
     */
    public void print();
}
