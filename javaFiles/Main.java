package javaFiles;

public class Main{
    public static void main(String[] args){
        Board board = Loader.loadBoard("test1.ksdk");

        Solver.solve(board);

        Solver.testSolve(board);

        // board = Loader.loadBoard("test2.ksdk");

        // Solver.solve(board);

        // Solver.testSolve(board);

        // board = Loader.loadBoard("test3.ksdk");

        // Solver.solve(board);

        // Solver.testSolve(board);
    }
}