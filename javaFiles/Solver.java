package javaFiles;

public class Solver {
    public static Board solve(Board board){

        //your code here

        return board;
    }

    public static void testSolve(Board board){
        //do not edit code here
        Boolean passing = true;
        for (Square square: board.squares){
            int testSum = square.value;
            int sum = square.regionSum;
            for (Square s: square.connectedSquares){
                testSum = testSum + s.value;
            }
            if (testSum != sum){
                passing = false;
            }
        }
        for (int y = 0; y<9; y++){
            for (int x = 0; x<9; x++){
                
            }
        }
    }
}
