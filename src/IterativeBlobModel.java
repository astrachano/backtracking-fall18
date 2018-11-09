import java.util.*;

public class IterativeBlobModel extends BlobModel {

    private class Pair{
        int row;
        int col;
        public Pair(int r, int c){
            row = r;
            col = c;
        }
        @Override
        public boolean equals(Object o){
        		if (o == null || ! (o instanceof Pair)) return false;
        		
            Pair p = (Pair) o;
            return row == p.row && col == p.col;
        }
        @Override
        public int hashCode(){
            return row*1000+col;
        }
    }
    
    private Pair[][] myPairGrid;
    
    @Override
    public void initialize(int rows, int cols, int count){
        super.initialize(rows,cols,count);
        myPairGrid = new Pair[myGrid.length][myGrid[0].length];
        for(int r=0; r < myPairGrid.length; r++){
            for(int c=0; c < myPairGrid[0].length; c++){
                myPairGrid[r][c] = new Pair(r,c);
            }
        }
    }
    
    
    @Override
    protected int blobFill(int row, int col, int lookFor, int fillWith) {
        int size = 0;
        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
        
        if (myGrid[row][col] != lookFor) return 0; // not part of blob
        
        Queue<Pair> qp = new LinkedList<>();       
        myGrid[row][col] = fillWith;  // mark pixel
        size++;                       // count pixel
        qp.add(myPairGrid[row][col]);
        while (qp.size() != 0){
            Pair p = qp.remove();
            for(int k=0; k < rowDelta.length; k++){
                row = p.row + rowDelta[k];
                col = p.col + colDelta[k];
                if (inRange(row,col) && myGrid[row][col] == lookFor){
                    qp.add(myPairGrid[row][col]);
                    myGrid[row][col] = fillWith;
                    size++;
                }
            }
        }
        return size;
    }

}
