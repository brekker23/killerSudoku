package javaFiles;


public class Solver {
    public static Board solve(Board board){

        //your code here

        return board;
    }

    public static boolean testSolve(Board board){
        //do not edit code here
        for (Square square: board.squares){
            int testSum = square.value;
            int sum = square.regionSum;
            for (Square s: square.connectedSquares){
                testSum = testSum + s.value;
            }
            if (testSum != sum){
                return false;
            }
            if (square.value < 1){
                return false;
            }
        }
        int[][] testCollumns = new int[9][9];
        int[][] testRows = new int[9][9];
        int[][] houses = new int[9][9];
        for (int y = 0; y<9; y++){
            for (int x = 0; x<9; x++){
                testCollumns[y][x]=board.squares.get(x + y*9).value;
                testRows[x][y]=board.squares.get(x + y*9).value;
                houses[(int)(x/3) + (int)(y/3)*3][x%3 + 3*y%3]=board.squares.get(x + y*9).value;
            }
        }
        for (int[] collumn: testCollumns){
            for (int i = 0; i<collumn.length; i++){
                for (int j = i+1; j<collumn.length;j++){
                    if (collumn[i] == collumn[j]){
                        return false;
                    }
                }
            }
        }
        for (int[] row: testRows){
            for (int i = 0; i<row.length; i++){
                for (int j = i+1; j<row.length; j++){
                    if (row[i]==row[j]){
                        return false;
                    }
                }
            }
        }
        for (int[] house: houses){
            for (int i = 0; i<house.length; i++){
                for (int j = i+1; j<house.length; j++){
                    if (house[j]==house[i]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
