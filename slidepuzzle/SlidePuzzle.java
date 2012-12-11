import java.util.Random;
public class SlidePuzzle{

    private Random random = new Random();
    private int[][] SlidePuzzle;
    private int currentRow=0;
    private int currentColumn=0;
    
    public SlidePuzzle(int size){
        SlidePuzzle = new int[size][size];
        reset();
    }
    
    public void reset(){
        int value = 0;
        for(int i=0; i<SlidePuzzle.length; i++){
            for(int j=0; j<SlidePuzzle[i].length; j++){
                SlidePuzzle[i][j]=value;
                value++;
            }
        }
    }
    
    private void swapWith(int targetRow, int targetColumn){
        if(targetRow>=SlidePuzzle.length || targetColumn>=SlidePuzzle.length
            || targetRow<0 || targetColumn<0){
            SlidePuzzle = SlidePuzzle;
        } else {
            SlidePuzzle[currentRow][currentColumn] 
                    = SlidePuzzle[targetRow][targetColumn];
            SlidePuzzle[targetRow][targetColumn] = 0;
            currentColumn = targetColumn;
            currentRow = targetRow;
        }
    }
    
    public void moveUp(){
        swapWith(currentRow+1, currentColumn);
    }
    
    public void moveDown(){
        swapWith(currentRow-1, currentColumn);
    }
    
    public void moveLeft(){
        swapWith(currentRow, currentColumn+1);
    }
    
    public void moveRight(){
        swapWith(currentRow, currentColumn-1);
    }
    
    public void scramble(int steps){
        for(int i=0; i<steps; i++){
            int move = random.nextInt(4);
            switch(move){
                case 0: moveUp();
                        break;
                case 1: moveDown();
                        break;
                case 2: moveLeft();
                        break;
                case 3: moveRight();
                        break;
            }
        }
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<SlidePuzzle.length;i++){
            for(int j=0;j<SlidePuzzle[i].length;j++){
                if(SlidePuzzle[i][j]==0){
                    result.append(" \t");
                }else{
                    result.append(SlidePuzzle[i][j] + "\t");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}