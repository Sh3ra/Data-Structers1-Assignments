package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import java.awt.*;
import java.util.ArrayList;

public class Main implements IPlayersFinder{


    private Point[] MySort(Point[] line)
    {
        for(int i=line.length-1;i>=0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(line[j+1].x<line[j].x)
                {
                    Point swap=new Point();
                    swap=line[j];
                    line[j]=line[j+1];
                    line[j+1]=swap;
                }
                if(line[j+1].x==line[j].x)
                {
                    if(line[j+1].y<line[j].y)
                    {
                        Point swap=new Point();
                        swap=line[j];
                        line[j]=line[j+1];
                        line[j+1]=swap;
                    }
                }
            }
        }
        return line;
    }
    public int countElements(String[] photo,int team,int i, int j,boolean[][] visited,boolean[][] visitedDa5ma)
    {
     int count=1;
        visited[i][j]=true;
        visitedDa5ma[i][j]=true;
        if(i+1<photo.length)
        {
            char z=(char)(team+48);
            if(photo[i+1].charAt(j)==z && !visited[i+1][j])
            {
                visited[i+1][j]=true;
                count=count+countElements(photo,team,i+1,j,visited,visitedDa5ma);
            }
        }
        if (i-1>=0)
        {
            char z=(char)(team+48);
            if(photo[i-1].charAt(j)==z && !visited[i-1][j])
            {
                visited[i-1][j]=true;
                count=count+countElements(photo,team,i-1,j,visited,visitedDa5ma);
            }
        }
        if(j+1<photo[i].length())
        {
            char z=(char)(team+48);
            if(photo[i].charAt(j+1)==z && !visited[i][j+1])
            {
                visited[i][j+1]=true;
                count=count+countElements(photo,team,i,j+1,visited,visitedDa5ma);
            }
        }
        if(j-1>=0)
        {
            char z=(char)(team+48);
            if(photo[i].charAt(j-1)==z && !visited[i][j-1])
            {
                visited[i][j-1]=true;
                count=count+countElements(photo,team,i,j-1,visited,visitedDa5ma);
            }
        }
        return  count;
    }

    @Override
    public  Point[] findPlayers(String[] photo, int team, int threshold) {
        ArrayList<Point> Pos=new ArrayList<>();
        boolean [][] visitedDa5ma=new boolean[photo.length][photo[0].length()];
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
                    for (int w=0;w<visited.length;w++)
                    {
                        for(int y=0;y<visited[w].length;y++)
                            visited[w][y]=false;
                    }
                    if(!visitedDa5ma[i][j]) {
                        int area = 4 * countElements(photo, team, i, j, visited, visitedDa5ma);
                        if (area >= threshold) {
                            temp.x = (minX + maxX + 1);
                            temp.y = minY + maxY + 1;
                            boolean check;
                            check = false;
                                /*for (int k = 0; k < Pos.size(); k++) {
                                    if (Pos.contains(temp)) {
                                        check = true;
                                        break;
                                    }
                                }*/
                            if (!check) {
                                Pos.add(new Point(temp));
                            }
                        }
                    }
                }

            }
        }
        Point[] line=new Point[Pos.size()];
        for (int index = 0; index < Pos.size(); index++)
        {
            line[index] = new Point(Pos.get(index));
        }
        line=MySort(line);
        return line;
    }

        public    int getMinx(String[] photo,int team, int i,int j,boolean[][] visited)
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
        public    int getMaxX(String[] photo,int team, int i,int j,boolean[][] visited)
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
        public    int getMinY(String[] photo,int team, int i,int j,boolean[][] visited)
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
        public   int getMaxY(String[] photo,int team, int i,int j,boolean[][] visited)
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



    }

