package javaFiles;

import java.util.ArrayList;

public class Board {
    ArrayList<Square> squares = new ArrayList<Square>();//using a 1d array allows you to get a 2d value with index y*9+x
    //you can add code here

    public Board(){
        for (int y = 0; y<9; y++){
            for (int x = 0; x<9; x++){
                squares.add(new Square(x, y));
            }
        }
    }

    public void printBoard(){
        int groupCount = 0;
        String[] valueArray = new String[81];
        ArrayList<Square> completedSquares = new ArrayList<Square>();
        for (int y = 0; y<9; y++){
            for (int x = 0; x<9; x++){
                valueArray[x + y*9] = "0";
            }
        }
        for (Square square: this.squares){
            if (!completedSquares.contains(square)){
                for (Square s: square.connectedSquares){
                    completedSquares.add(s);
                    int val = 0;
                    if (s.value > 0){
                        val = s.value;
                    }
                    valueArray[s.x + s.y*9] = "\033[38;5;"+Integer.toString(groupCount*40)+"m"+Integer.toString(val)+"\033[0m";
                }
                int val = 0;
                if (square.value > 0){
                    val = square.value;
                }
                valueArray[square.x + square.y*9] = "\033[38;5;"+Integer.toString(groupCount*40)+"m"+Integer.toString(val)+"\033[0m";
            }
            groupCount++;
        }
        for (int y = 0; y<9; y++){
            for (int x = 0; x<9; x++){
                System.out.print(valueArray[x + y*9] + " ");
            }
            System.out.println();
        }
        //woah that was scary it worked first try no bugs... i'm suspicious
    }

    //if you want to add more methods to Board add them here

}
