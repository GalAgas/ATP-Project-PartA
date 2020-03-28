package algorithms.mazeGenerators;

import java.util.concurrent.ThreadLocalRandom;

public class EmptyMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int rows, int cols)
    {
        Maze emptyMaze = new Maze(rows, cols);
        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
                emptyMaze.getMaze()[i][j] = '0';
        }

        //selects a random side of the frame - up, down, right or left.
        int frameSideStart = ThreadLocalRandom.current().nextInt(0, 4);
        //int frameSideGoal = ThreadLocalRandom.current().nextInt(0, 3);
        int frameSideGoal;




        int startRandomCol = ThreadLocalRandom.current().nextInt(0, cols);
        int startRandomRow = ThreadLocalRandom.current().nextInt(0, rows);
        int GoalRandomRow = ThreadLocalRandom.current().nextInt(0, rows);
        int goalRandomCol = ThreadLocalRandom.current().nextInt(0, cols);


        //up side
        if (frameSideStart == 0)
        {
            emptyMaze.setStartPosition(0, startRandomCol);

            //up right corner-goal can be in left or down only
            if (startRandomCol == cols - 1)
            {
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//left
                    emptyMaze.setGoalPosition(GoalRandomRow,0);
                else //down
                    emptyMaze.setGoalPosition(rows-1,goalRandomCol);
            }

            //up left corner-goal can be in right or down only
            else if(startRandomCol == 0)
            {
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//right
                    emptyMaze.setGoalPosition(GoalRandomRow,cols-1);
                else //down
                    emptyMaze.setGoalPosition(rows-1,goalRandomCol);

            }

            //not in the corner-goal can be in right, left or down
            else
            {
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 3);
                if (frameSideGoal == 0)//right
                    emptyMaze.setGoalPosition(GoalRandomRow,cols-1);
                else if (frameSideGoal == 1) //left
                    emptyMaze.setGoalPosition(GoalRandomRow,0);
                else //down
                    emptyMaze.setGoalPosition(rows-1,goalRandomCol);

            }



        }

        //down side
        else if (frameSideStart == 3)
        {
            emptyMaze.setStartPosition(rows-1, startRandomCol);
        }

        //left side
        else if (frameSideStart == 2)
        {
            emptyMaze.setStartPosition(startRandomRow, 0);
        }

        //right side
        else
        {
            emptyMaze.setStartPosition(startRandomRow, cols-1);

        }


        return emptyMaze;
    }
}
