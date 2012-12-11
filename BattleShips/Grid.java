public class Grid {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private final Piece[][] grid = new Piece[HEIGHT][WIDTH];

    public Grid() {
        for(int i=0; i<HEIGHT; i++){
            for(int j=0; j<WIDTH; j++){
                grid[i][j] = Piece.WATER;
            }
        }
    }

    public boolean canPlace(Coordinate c, int size, boolean isDown) {
        int row = c.getRow();
        int column = c.getColumn();      
        if(isDown){
            if(size+row>9){
                return false;
            }          
            for(int i=row; i<(size+row); i++){
                if(grid[i][column]==Piece.SHIP){
                    return false;
                }                
            }
        }else{
            if(size+column>9){
                return false;
            }
            for(int i=column; i<(size+column); i++){
               if(grid[row][i]==Piece.SHIP){
                    return false;
                } 
            }
            
        }
        return true;
    }

    public void placeShip(Coordinate c, int size, boolean isDown) {
        int row = c.getRow();
        int column = c.getColumn();          
        if(isDown){
            for(int i=row; i<(row+size); i++){
                grid[i][column] = Piece.SHIP;
            }
        }else{
            for(int i=column; i<(column+size); i++){
                grid[row][i] = Piece.SHIP;
            }
        }
    }

    public boolean wouldAttackSucceed(Coordinate c) {
        return grid[c.getRow()][c.getColumn()]==Piece.SHIP;
    }

    public void attackCell(Coordinate c) {
        int row=c.getRow();
        int column=c.getColumn();
        if(grid[row][column]==Piece.SHIP){
            grid[row][column] = Piece.DAMAGED_SHIP;
        }else if(grid[row][column]==Piece.WATER){
            grid[row][column] = Piece.MISS;
        }else{
            grid[row][column] = grid[row][column];
        }
    }

    public boolean areAllSunk() {
        for(int i=0; i<HEIGHT; i++){
            for(int j=0; j<WIDTH; j++){
                if(grid[i][j]==Piece.SHIP){
                    return false;
                }
            }
        }
        return true;
    }

    public String toPlayerString() {
        return null; // TODO: delete this line for Question 4.
    }

    public String toString() {
        return renderGrid(grid);
    }

    private static String renderGrid(Piece[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 0123456789\n");
        for (int i = 0; i < grid.length; i++) {
            sb.append((char) ('A' + i));
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) {
                    return "!";
                }
                switch (grid[i][j]) {
                case SHIP:
                    sb.append('#');
                    break;
                case DAMAGED_SHIP:
                    sb.append('*');
                    break;
                case MISS:
                    sb.append('o');
                    break;
                case WATER:
                    sb.append('.');
                    break;
                }

            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
