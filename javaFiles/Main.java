package javaFiles;

public class Main{
    public static void main(String[] args){
        Board board = Loader.loadBoard("test1.ksdk");
        board.printBoard();
        System.out.println();

        Solver.solve(board);
        board.printBoard();

        Solver.testSolve(board);

        // board = Loader.loadBoard("test2.ksdk");

        // Solver.solve(board);

        // Solver.testSolve(board);

        // board = Loader.loadBoard("test3.ksdk");

        // Solver.solve(board);

        // Solver.testSolve(board);
    }
}