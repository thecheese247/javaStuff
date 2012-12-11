import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Grid grid = makeInitialGrid();
        int numAttacks = 0;
        System.out.println(grid);
        while(!grid.areAllSunk()){
            System.out.println("Please enter a coordinate to attack");
            String stringAttackCo = input.next();
            Coordinate attackCo = Util.parseCoordinate(stringAttackCo);
            if(grid.wouldAttackSucceed(attackCo)){
                System.out.println("Direct Hit!");                
            }
            grid.attackCell(attackCo);
            System.out.println(grid);
            numAttacks ++;
        }
        System.out.println("You sunk all the battleships");
        System.out.println("It took " + numAttacks + " attacks");
    }

    private static Grid makeInitialGrid() {
        Grid grid = new Grid();

        String[] coords = { "A7", "B1", "B4", "D3", "F7", "H1", "H4" };
        int[] sizes = { 2, 4, 1, 3, 1, 2, 5 };
        boolean[] isDowns = { false, true, true, false, false, true, false };

        for (int i = 0; i < coords.length; i++) {
            Coordinate c = Util.parseCoordinate(coords[i]);
            grid.placeShip(c, sizes[i], isDowns[i]);
        }

        return grid;
    }

}
