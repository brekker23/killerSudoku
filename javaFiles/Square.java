package javaFiles;

import java.util.ArrayList;

public class Square {
    int x;
    int y;
    int value;
    int regionSum;
    ArrayList<Square> connectedSquares = new ArrayList<Square>();
    //you can add code here

    public Square(int x, int y, int value, int regionSum){
        this.x = x;
        this.y = y;
        this.value = value;
        this.regionSum = regionSum;
    }

    public Square(int x, int y){
        this.x = x;
        this.y = y;
        this.value = -1; //-1 denotes no assigned value
        this.regionSum = -1; //-1 denotes no assigned value
    }

    public void addConnection(Square square){
        //when building a board, make sure that you connect all the connected squares before you set the region sums
        for (Square s: this.connectedSquares){
            if (s.equals(square)){
                continue;
            }
            if (!square.connectedSquares.contains(s)){
                square.connectedSquares.add(s);
            }
            if (!s.connectedSquares.contains(square)){
                s.connectedSquares.add(square);
            }
        }
        if (!square.connectedSquares.contains(this)){
            square.connectedSquares.add(this);
        }
        if (!this.connectedSquares.contains(square)){
            this.connectedSquares.add(square);
        }
    }
    


    public void print(){
        System.out.println("("+this.x+", "+this.y+"), value="+this.value+"; regionSum="+this.regionSum+" connectedSquares={"+this.connectedSquares+"}");
    }

    public void setSum(int sum){
        //make sure to add all the connections before calling setSum
        this.regionSum = sum;
        for (Square s: connectedSquares){
            s.regionSum = sum;
        }
    }

    public void setValue(int value){
        this.value = value;
    }

    //you can add code here is you want more methods
}
