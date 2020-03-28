package algorithms.mazeGenerators;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AMazeGenerator implements IMazeGenerator
{
    public long measureAlgorithmTimeMillis(int rows, int cols)
    {
        long startTime = System.currentTimeMillis();
        this.generate(rows, cols);
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }

    public void chooseStartandGoal(Maze maze, int rows, int cols)
    {
        //selects a random side of the frame - up, down, right or left for the start.
        int frameSideStart = ThreadLocalRandom.current().nextInt(0, 4);
        int startRandomCol = ThreadLocalRandom.current().nextInt(0, cols);
        int startRandomRow = ThreadLocalRandom.current().nextInt(0, rows);
        boolean startInCorner = false;


        int frameSideGoal;
        int goalRandomCol = ThreadLocalRandom.current().nextInt(0, cols);
        int goalRandomRow = ThreadLocalRandom.current().nextInt(0, rows);


        //up side
        if (frameSideStart == 0)
        {
            maze.setStartPosition(0, startRandomCol);
            goalRandomRow = ThreadLocalRandom.current().nextInt(1, rows);


            //up right corner-goal can be in left or down only
            if (startRandomCol == cols - 1)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//left
                    maze.setGoalPosition(goalRandomRow,0);
                else //down
                {
                    goalRandomCol = ThreadLocalRandom.current().nextInt(0, cols-1);
                    maze.setGoalPosition(rows-1, goalRandomCol);
                }
            }

            //up left corner-goal can be in right or down only
            else if(startRandomCol == 0)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//right
                    maze.setGoalPosition(goalRandomRow,cols-1);
                else //down
                {
                    goalRandomCol = ThreadLocalRandom.current().nextInt(1, cols);
                    maze.setGoalPosition(rows-1, goalRandomCol);
                }
            }

            //start is not in the corner
            if (!startInCorner)
            {
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 3);
                if (frameSideGoal == 0)//right
                    maze.setGoalPosition(goalRandomRow,cols-1);
                else if (frameSideGoal == 1) //left
                    maze.setGoalPosition(goalRandomRow,0);
                else //down
                    maze.setGoalPosition(rows-1,goalRandomCol);
            }
        }

        //down side
        else if (frameSideStart == 1)
        {
            maze.setStartPosition(rows-1, startRandomCol);
            goalRandomRow = ThreadLocalRandom.current().nextInt(0, rows-1);


            //down right corner-goal can be in left or up only
            if (startRandomCol == cols - 1)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//left
                    maze.setGoalPosition(goalRandomRow,0);
                else //up
                {
                    goalRandomCol = ThreadLocalRandom.current().nextInt(0, cols-1);
                    maze.setGoalPosition(0, goalRandomCol);
                }
            }

            //down left corner-goal can be in right or up only
            else if(startRandomCol == 0)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//right
                    maze.setGoalPosition(goalRandomRow,cols-1);
                else //up
                {
                    goalRandomCol = ThreadLocalRandom.current().nextInt(1, cols);
                    maze.setGoalPosition(0, goalRandomCol);
                }
            }

            //start is not in the corner
            if (!startInCorner)
            {
                int goalRandLR =
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 3);
                if (frameSideGoal == 0)//right
                    maze.setGoalPosition(goalRandomRow,cols-1);
                else if (frameSideGoal == 1) //left
                    maze.setGoalPosition(goalRandomRow,0);
                else //up
                    maze.setGoalPosition(0,goalRandomCol);
            }
        }

        //left side
        else if (frameSideStart == 2)
        {
            maze.setStartPosition(startRandomRow, 0);
            goalRandomCol = ThreadLocalRandom.current().nextInt(1, cols);


            //up left corner-goal can be in right or down only
            if (startRandomRow == 0)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//right
                {
                    goalRandomRow = ThreadLocalRandom.current().nextInt(1, rows);
                    maze.setGoalPosition(goalRandomRow,cols -1);
                }
                else //down
                    maze.setGoalPosition(rows-1, goalRandomCol);
            }

            //down left corner-goal can be in right or up only
            else if(startRandomRow == rows-1)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//right
                {
                    goalRandomRow = ThreadLocalRandom.current().nextInt(0, rows-1);
                    maze.setGoalPosition(goalRandomRow,cols-1);
                }
                else //up
                    maze.setGoalPosition(0, goalRandomCol);
            }

            //start is not in the corner
            if (!startInCorner)
            {
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 3);
                if (frameSideGoal == 0)//right
                    maze.setGoalPosition(goalRandomRow,cols-1);
                else if (frameSideGoal == 1) //up
                    maze.setGoalPosition(0, goalRandomCol);
                else //down
                    maze.setGoalPosition(rows-1,goalRandomCol);
            }
        }

        //right side
        else
        {
            maze.setStartPosition(startRandomRow, cols-1);
            goalRandomCol = ThreadLocalRandom.current().nextInt(0, cols-1);

            //up right corner-goal can be in left or down only
            if (startRandomRow == 0)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//left
                {
                    goalRandomRow = ThreadLocalRandom.current().nextInt(1, rows);
                    maze.setGoalPosition(goalRandomRow,0);
                }
                else //down
                    maze.setGoalPosition(rows-1, goalRandomCol);
            }

            //down right corner-goal can be in left or up only
            else if (startRandomRow == rows-1)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//left
                {
                    goalRandomRow = ThreadLocalRandom.current().nextInt(0, rows-1);
                    maze.setGoalPosition(goalRandomRow,0);
                }
                else //up

                    maze.setGoalPosition(0, goalRandomCol);

            }

            //start is not in the corner
            if (!startInCorner)
            {
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 3);
                if (frameSideGoal == 0)//left
                    maze.setGoalPosition(goalRandomRow,0);
                else if (frameSideGoal == 1) //up
                    maze.setGoalPosition(0, goalRandomCol);

                else //down
                    maze.setGoalPosition(rows-1,goalRandomCol);
            }
        }
    }
}
