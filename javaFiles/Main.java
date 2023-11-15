package javaFiles;

public class Main{
    public static void main(String[] args){
        // Board board = Loader.loadBoard("test1.ksdk");
        // System.out.println();
        // board.printBoard();
        // System.out.println();

        // Solver.solve(board);
        // board.printBoard();

        // System.out.println(Solver.testSolve(board));

        Board board = Loader.loadBoard("test3.ksdk");
        board.printBoard();

        Solver.solve(board);

        System.out.println(Solver.testSolve(board));
    }
}