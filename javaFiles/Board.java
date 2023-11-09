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

    //if you want to add more methods to Board add them here

}
