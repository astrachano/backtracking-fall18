import java.util.Arrays;

public class QBoard implements IQueenState{
    
    private int[] myBoardRows;
    private static int NONE = 100000; // invalid row, and calculations ok
    
    public QBoard(int n){
        myBoardRows = new int[n];
        Arrays.fill(myBoardRows,NONE);
    }
    
    public boolean safeToPlace(int row, int col){
        
        // check each column to see if conflict exists
        
        for(int c=0; c < myBoardRows.length; c++){
            if (myBoardRows[c] == row) return false;
            
            int diagDistance = col - c;
            if (myBoardRows[c] == row - diagDistance) return false;
            if (myBoardRows[c] == row + diagDistance) return false;
        }
        return true;
    }
    
    public void setQueen(int row, int col, boolean value){
        myBoardRows[col] = value ? row : NONE;
    }
    
    public void print(){
        for(int r=0; r < myBoardRows.length; r++){
            for(int c=0; c < myBoardRows.length; c++){
                if (myBoardRows[c] == r){
                    System.out.print("Q");
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
