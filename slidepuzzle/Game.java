public class Game {
    
    public static void main ( String [] args ) {
    
        SlidePuzzle puzzle = new SlidePuzzle (3);
        
        System .out . println (" Initial 3x3 puzzle:");
        System .out . println ( puzzle );
        
        System .out . println (" After '3' moves up:");
        puzzle . moveUp ();
        System .out . println ( puzzle );
        
        System .out . println (" After '4' moves left :");
        puzzle . moveLeft ();
        System .out . println ( puzzle );
        
        System .out . println (" After 1000 random moves :");
        puzzle . scramble (1000);
        System .out . println ( puzzle );
}
}