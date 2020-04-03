package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator
{
    @Override
    public Maze generate(int rows, int cols)
    {
        if (rows<3)
            rows=3;
        if (cols<3)
            cols=3;
        Maze myMaze = new Maze(rows, cols);
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
                myMaze.getMaze()[i][j] = 1;
        }

        LinkedList<Position[]> neigbours = new LinkedList<>();
        Random random = new Random();
        int x = random.nextInt(rows);
        int y = random.nextInt(cols);
        neigbours.add(new Position[]{new Position(x,y),new Position(x,y)});

        while (!neigbours.isEmpty())
        {
            Position[] curr = neigbours.remove(random.nextInt(neigbours.size()));
            x = curr[1].getRowIndex();
            y = curr[1].getColumnIndex();

            if(myMaze.getMaze()[x][y] == 1)
            {
                myMaze.getMaze()[curr[0].getRowIndex()][curr[0].getColumnIndex()] = 0;
                myMaze.getMaze()[x][y] = 0;

                if (x>=2 && myMaze.getMaze()[x-2][y] == 1)
                    neigbours.add(new Position[]{new Position(x-1,y),new Position(x-2,y)});

                if (y>=2 && myMaze.getMaze()[x][y-2] == 1)
                    neigbours.add(new Position[]{new Position(x,y-1),new Position(x,y-2)});

                if (x < rows-2 && myMaze.getMaze()[x+2][y] == 1)
                    neigbours.add(new Position[]{new Position(x+1,y),new Position(x+2,y)});

                if (y < cols-2 && myMaze.getMaze()[x][y+2] == 1)
                    neigbours.add(new Position[]{new Position(x,y+1),new Position(x,y+2)});
            }

        }
        //chooseStartandGoal(myMaze, rows, cols);
        return myMaze;
    }
}
