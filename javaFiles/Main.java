package javaFiles;

public class Main{
    public static void main(String[] args){
        Board board = Loader.loadBoard("test1.ksdk");

        // board.printBoard();
        // System.out.println();
        
        // Solver.solve(board);

        // board.printBoard();
        System.out.println(Solver.testSolve(board));
        System.out.println();

        board = Loader.loadBoard("test2.ksdk");

        board.printBoard();
        System.out.println();

        Solver.solve(board);

        board.printBoard();
        System.out.println(Solver.testSolve(board));
        // System.out.println();

        // board = Loader.loadBoard("test3.ksdk");

        // board.printBoard();
        // System.out.println(Solver.testSolve(board));
        // System.out.println();
    }
}