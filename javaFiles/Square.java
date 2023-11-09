package javaFiles;

import java.util.ArrayList;

public class Square {
    int x;
    int y;
    int value;
    int regionSum;
    ArrayList<Square> connectedSquares = new ArrayList<Square>();

    public Square(int x, int y, int value, int regionSum){
        this.x = x;
        this.y = y;
        this.value = value;
        this.regionSum = regionSum;
    }

    public Square(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void addConnection(Square square){
        for (Square s: this.connectedSquares){
            if (!s.connectedSquares.contains(square)){
                s.connectedSquares.add(square);
            }
            if (!square.connectedSquares.contains(s)){
                square.connectedSquares.add(s);
            }
        }
        connectedSquares.add(square);
    }

    public void print(){
        System.out.println("("+this.x+", "+this.y+") "+this.value+"; "+this.regionSum+" {"+this.connectedSquares.size()+"}");
    }

    public void setSum(int sum){
        //make sure to add all the connections first
        this.regionSum = sum;
        for (Square s: connectedSquares){
            s.regionSum = sum;
        }
    }

    public void setValue(int value){
        this.value = value;
    }
}
