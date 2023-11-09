package javaFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Loader {
    public static Board loadBoard(String path){

        //don't edit this
        Board board = new Board();
        File file = new File(path);
        String contents = new String();
        try{
            Scanner scan = new Scanner(file);
            contents = scan.nextLine();
            scan.close();
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
            System.out.println("Couldn't find file "+path);
        }

        int index = 0;
        for (String squareData: contents.split(";")){
            Square square = board.squares.get(index);
            String[] dataSections = squareData.substring(1,squareData.length()-1).split(":");
            square.setValue(Integer.parseInt(dataSections[0]));
            String connectedCoords = dataSections[2].substring(1,dataSections[2].length()-1);
            for (String connectedCoord: connectedCoords.split("\\.")){
                if (connectedCoord.equals("")){
                    continue;
                }
                int connectedx = Integer.parseInt(connectedCoord.substring(1,2));
                int connectedy = Integer.parseInt(connectedCoord.substring(3,4));
                square.addConnection(board.squares.get(connectedx + connectedy*9));
            }
            int sum = Integer.parseInt(dataSections[1]);
            if (sum != -1){
                board.squares.get(index).setSum(sum);
            }
            index++;
        }

        return board;
    }

    public static void saveBoard(Board board, String path){
        File file = new File(path);
        try{
            PrintWriter pw = new PrintWriter(file);
            for (Square square: board.squares){
                pw.append("("+square.value+":"+square.regionSum+":(");
                for (Square s: square.connectedSquares){
                    pw.append("("+s.x+":"+s.y+").");
                }
                pw.append("));");
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
