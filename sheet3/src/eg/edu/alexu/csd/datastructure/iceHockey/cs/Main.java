package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import java.awt.*;
import java.util.ArrayList;

public class Main implements IPlayersFinder{
    @Override
    public  Point[] findPlayers(String[] photo, int team, int threshold) {
        ArrayList<Point> Pos = new ArrayList<>();
        Point temp = new Point();

        //lef wa7ed wa7ed we el ta5doh 7awel el rectagel kolo le 'a'

        Pos.add(temp);
        // Pos.sort();
        Point[] line = new Point[Pos.size()];
        for (int index = 0; index < line.length; index++) {
            line[index] = new Point(Pos.get(index));
        }
        return line;
    }

        public  static  int getMinx(String[] photo,int team, int i,int j,boolean[][] visited)
        {
            int minX=j;
            visited[i][j]=true;
            if(i+1<photo.length)
            {
                char z=(char)(team+48);
                if(photo[i+1].charAt(j)==z && !visited[i+1][j])
                {
                    visited[i+1][j]=true;
                    minX=Math.min(minX,getMinx(photo,team,i+1,j,visited));
                }
            }
            if (i-1>=0)
            {
                char z=(char)(team+48);
                if(photo[i-1].charAt(j)==z && !visited[i-1][j])
                {
                    visited[i-1][j]=true;
                    minX=Math.min(minX,getMinx(photo,team,i-1,j,visited));
                }
            }
            if(j+1<photo[i].length())
            {
                char z=(char)(team+48);
                if(photo[i].charAt(j+1)==z && !visited[i][j+1])
                {
                    visited[i][j+1]=true;
                    minX=Math.min(minX,getMinx(photo,team,i,j+1,visited));
                }
            }
            if(j-1>=0)
            {
                char z=(char)(team+48);
                if(photo[i].charAt(j-1)==z && !visited[i][j-1])
                {
                    visited[i][j-1]=true;
                    minX=Math.min(minX,getMinx(photo,team,i,j-1,visited));
                }
            }
            return  minX;
        }
        public  static  int getMaxX(String[] photo,int team, int i,int j,boolean[][] visited)
        {
            int maxX=j;

            visited[i][j]=true;
            if(i+1<photo.length)
            {
                char z=(char)(team+48);
                if(photo[i+1].charAt(j)==z && !visited[i+1][j])
                {
                    visited[i+1][j]=true;
                    maxX=Math.max(maxX,getMaxX(photo,team,i+1,j,visited));
                }
            }
            if (i-1>=0)
            {
                char z=(char)(team+48);
                if(photo[i-1].charAt(j)==z && !visited[i-1][j])
                {
                    visited[i-1][j]=true;
                    maxX=Math.max(maxX,getMaxX(photo,team,i-1,j,visited));
                }
            }
            if(j+1<photo[i].length())
            {
                char z=(char)(team+48);
                if(photo[i].charAt(j+1)==z && !visited[i][j+1])
                {
                    visited[i][j+1]=true;
                    maxX=Math.max(maxX,getMaxX(photo,team,i,j+1,visited));
                }
            }
            if(j-1>=0)
            {
                char z=(char)(team+48);
                if(photo[i].charAt(j-1)==z && !visited[i][j-1])
                {
                    visited[i][j-1]=true;
                    maxX=Math.max(maxX,getMaxX(photo,team,i,j-1,visited));
                }
            }
            return  maxX;
        }
        public  static  int getMinY(String[] photo,int team, int i,int j,boolean[][] visited)
        {
            int minY=i;
            visited[i][j]=true;
            if(i+1<photo.length)
            {
                char z=(char)(team+48);
                if(photo[i+1].charAt(j)==z && !visited[i+1][j])
                {
                    visited[i+1][j]=true;
                    minY=Math.min(minY,getMinY(photo,team,i+1,j,visited));
                }
            }
            if (i-1>=0)
            {
                char z=(char)(team+48);
                if(photo[i-1].charAt(j)==z && !visited[i-1][j])
                {
                    visited[i-1][j]=true;
                    minY=Math.min(minY,getMinY(photo,team,i-1,j,visited));
                }
            }
            if(j+1<photo[i].length())
            {
                char z=(char)(team+48);
                if(photo[i].charAt(j+1)==z && !visited[i][j+1])
                {
                    visited[i][j+1]=true;
                    minY=Math.min(minY,getMinY(photo,team,i,j+1,visited));
                }
            }
            if(j-1>=0)
            {
                char z=(char)(team+48);
                if(photo[i].charAt(j-1)==z && !visited[i][j-1])
                {
                    visited[i][j-1]=true;
                    minY=Math.min(minY,getMinY(photo,team,i,j-1,visited));
                }
            }
            return  minY;
        }
        public  static  int getMaxY(String[] photo,int team, int i,int j,boolean[][] visited)
        {
            int maxY=i;

            visited[i][j]=true;
            if(i+1<photo.length)
            {
                char z=(char)(team+48);
                if(photo[i+1].charAt(j)==z && !visited[i+1][j])
                {
                    visited[i+1][j]=true;
                    maxY=Math.max(maxY,getMaxY(photo,team,i+1,j,visited));
                }
            }
            if (i-1>=0)
            {
                char z=(char)(team+48);
                if(photo[i-1].charAt(j)==z && !visited[i-1][j])
                {
                    visited[i-1][j]=true;
                    maxY=Math.max(maxY,getMaxY(photo,team,i-1,j,visited));
                }
            }
            if(j+1<photo[i].length())
            {
                char z=(char)(team+48);
                if(photo[i].charAt(j+1)==z && !visited[i][j+1])
                {
                    visited[i][j+1]=true;
                    maxY=Math.max(maxY,getMaxY(photo,team,i,j+1,visited));
                }
            }
            if(j-1>=0)
            {
                char z=(char)(team+48);
                if(photo[i].charAt(j-1)==z && !visited[i][j-1])
                {
                    visited[i][j-1]=true;
                    maxY=Math.max(maxY,getMaxY(photo,team,i,j-1,visited));
                }
            }

            return  maxY;
        }


        public static Point[] findPlayers1(String[] photo, int team, int threshold) {
        ArrayList<Point> Pos=new ArrayList<>();
        Point temp=new Point();
            boolean[][] visited=new boolean[photo.length][photo[0].length()];
            for (int w=0;w<visited.length;w++)
            {
                for(int y=0;y<visited[w].length;y++)
                    visited[w][y]=false;
            }
        //lef wa7ed wa7ed we el ta5doh 7awel el rectagel kolo le 'a'
            for(int i=0;i<photo.length;i++)
            {
                for(int j=0;j<photo[i].length();j++)
                {
                    char z=(char)(team+48);

                    if(photo[i].charAt(j)==z)
                    {
                        for (int w=0;w<visited.length;w++)
                        {
                            for(int y=0;y<visited[w].length;y++)
                                visited[w][y]=false;
                        }
                        int minX=getMinx(photo,team,i,j,visited);
                        for (int w=0;w<visited.length;w++)
                        {
                            for(int y=0;y<visited[w].length;y++)
                                visited[w][y]=false;
                        }
                        int maxX=getMaxX(photo,team,i,j,visited);
                        for (int w=0;w<visited.length;w++)
                        {
                            for(int y=0;y<visited[w].length;y++)
                                visited[w][y]=false;
                        }
                        int minY=getMinY(photo,team,i,j,visited);
                        for (int w=0;w<visited.length;w++)
                        {
                            for(int y=0;y<visited[w].length;y++)
                                visited[w][y]=false;
                        }
                        int maxY=getMaxY(photo,team,i,j,visited);
                        int area=((maxX-minX+1)*team)*((maxY-minY+1)*team);
                        if(area>=threshold)
                        {
                            temp.x=(minX+maxX+1);
                            temp.y=minY+maxY+1;
                            boolean check=false;
                            check=false;
                            for (Point po : Pos) {
                                if(po==temp)
                                {
                                    check=true;
                                    break;
                                }
                            }
                            if(check)
                            Pos.add(temp);
                        }
                    }

                }
            }

       // Pos.sort();
        Point[] line=new Point[Pos.size()];
        for (int index = 0; index < Pos.size(); index++)
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
       Pos= findPlayers1(new String[]{"33JUBU33","3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X" }, 3, 16);
        for (Point i : Pos) {
            System.out.println("("+i.x+","+i.y+")");
        }
    }
}
