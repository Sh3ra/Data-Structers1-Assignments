package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import java.awt.*;
import java.util.ArrayList;

public class Main implements IPlayersFinder{
    @Override
    public  Point[] findPlayers(String[] photo, int team, int threshold) {
        ArrayList<Point> Pos=new ArrayList<>();
        Point temp=new Point();

        //lef wa7ed wa7ed we el ta5doh 7awel el rectagel kolo le 'a'

        Pos.add(temp);
       // Pos.sort();
        Point[] line=new Point[Pos.size()];
        for (int index = 0; index < line.length; index++)
        {
            line[index] = new Point(Pos.get(index));
        }
        return line;
    }
    public static void main(String[] args) {
        //write a way to get the size of Pos
        Point[] Pos= new Point[4];
        for (int index = 0; index < Pos.length; index++)
        {
            Pos[index] = new Point();
        }
        //Pos= findPlayers(new String[]{"33JUBU33","3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X" }, 3, 16);
        for (Point i : Pos) {
            System.out.println("("+i.x+","+i.y+")");
        }
    }
}
