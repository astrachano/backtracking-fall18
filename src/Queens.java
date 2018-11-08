
public class Queens {

    private IQueenState myBoard;
    private int mySize;
    private int myCount;
    
    public Queens(int n){
        mySize = n;
        myBoard = new QBoardGUI(n);
        if (solve(0)){
            myBoard.print();
        }
    }
    /**
     * Queens have been placed in all columns [0..col), try to place
     * a queen in column <code>col</code> and all columns after 
     * it, returning true if this is possible, false otherwise.
     * @param col is left-most column with no queen in it
     * @return true if a queen can be placed in all columns [col..size)
     */
    public boolean solve(int col){
        
        if (col == mySize) {
        	myCount++;
        	return true;
        }
        
        // try each row until all are tried
        
        for(int r=0; r < mySize; r++){
            if (myBoard.safeToPlace(r,col)){
                myBoard.setQueen(r,col,true);
  
                if (solve(col+1)){
                    return true;
                }
                myBoard.setQueen(r,col,false);
            }
        }
        return false;
    }
    
    public int getCount(){
        return myCount;
    }
    
    public static void main(String[] args){
        int size = 8;
        double start = System.nanoTime();
        Queens q = new Queens(size);
        System.out.println("# ways = "+q.getCount());
        double end = System.nanoTime();
        System.out.printf("time: %f\n",(end-start)/1e9);
    }
}
