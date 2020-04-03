package algorithms.mazeGenerators;

import java.util.ArrayList;
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

    public int chooseRandCol(Maze maze, int row, int rowLength, int iLoop)
    {
        ArrayList<Integer> allZerosInRow = new ArrayList<Integer>();
        for (int i=iLoop; i<rowLength; i++)
        {
            if(maze.getMaze()[row][i] == 0)
            {
                allZerosInRow.add(i);
            }
        }
        int randIndex = ThreadLocalRandom.current().nextInt(0, allZerosInRow.size());
        return allZerosInRow.get(randIndex);
    }

    public int chooseRandRow(Maze maze, int col, int colLength, int iLoop)
    {
        ArrayList<Integer> allZerosInCol = new ArrayList<Integer>();
        for (int i=iLoop; i<colLength; i++)
        {
            if(maze.getMaze()[i][col] == 0)
            {
                allZerosInCol.add(i);
            }
        }
        int randIndex = ThreadLocalRandom.current().nextInt(0, allZerosInCol.size());
        return allZerosInCol.get(randIndex);
    }

    public void chooseStartandGoal(Maze maze, int rows, int cols)
    {
        //selects a random side of the frame - up, down, right or left for the start.
        int frameSideStart = ThreadLocalRandom.current().nextInt(0, 4);
        int startRandomCol;
        int startRandomRow;
        boolean startInCorner = false;

        int frameSideGoal;
        int goalRandomCol;
        int goalRandomRow;


        //up side
        if (frameSideStart == 0)
        {
            startRandomCol = chooseRandCol(maze, 0, cols, 0);
            maze.setStartPosition(0, startRandomCol);

            //up right corner-goal can be in left or down only
            if (startRandomCol == cols - 1)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//left
                {
                    goalRandomRow = chooseRandRow(maze, 0, rows, 1);
                    maze.setGoalPosition(goalRandomRow,0);
                }

                else //down
                {
                    goalRandomCol = chooseRandCol(maze, rows-1, cols-1,0);
                    maze.setGoalPosition(rows-1, goalRandomCol);
                }
            }

            //up left corner-goal can be in right or down only
            else if(startRandomCol == 0)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//right
                {
                    goalRandomRow = chooseRandRow(maze, cols-1, rows, 1);
                    maze.setGoalPosition(goalRandomRow,cols-1);
                }
                else //down
                {
                    goalRandomCol = chooseRandCol(maze, rows-1, cols,1);
                    maze.setGoalPosition(rows-1, goalRandomCol);
                }
            }

            //start is not in the corner
            if (!startInCorner)
            {
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 3);
                if (frameSideGoal == 0)//right
                {
                    goalRandomRow = chooseRandRow(maze, cols-1, rows, 1);
                    maze.setGoalPosition(goalRandomRow,cols-1);
                }
                else if (frameSideGoal == 1) //left
                {
                    goalRandomRow = chooseRandRow(maze, 0, rows, 1);
                    maze.setGoalPosition(goalRandomRow,0);
                }
                else //down
                {
                    goalRandomCol = chooseRandCol(maze, rows-1, cols,0);
                    maze.setGoalPosition(rows-1,goalRandomCol);
                }
            }
        }

        //down side
        else if (frameSideStart == 1)
        {
            startRandomCol = chooseRandCol(maze, rows-1, cols, 0);
            maze.setStartPosition(rows-1, startRandomCol);


            //down right corner-goal can be in left or up only
            if (startRandomCol == cols - 1)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//left
                {
                    goalRandomRow = chooseRandRow(maze, 0, rows-1, 0);
                    maze.setGoalPosition(goalRandomRow,0);
                }
                else //up
                {
                    goalRandomCol = chooseRandCol(maze,0, cols-1,0);
                    maze.setGoalPosition(0, goalRandomCol);
                }
            }

            //down left corner-goal can be in right or up only
            else if(startRandomCol == 0)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//right
                {
                    goalRandomRow = chooseRandRow(maze, cols-1, rows-1, 0);
                    maze.setGoalPosition(goalRandomRow,cols-1);
                }
                else //up
                {
                    goalRandomCol = chooseRandCol(maze,0, cols,1);
                    maze.setGoalPosition(0, goalRandomCol);
                }
            }

            //start is not in the corner
            if (!startInCorner)
            {
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 3);
                if (frameSideGoal == 0)//right
                {
                    goalRandomRow = chooseRandRow(maze, cols-1, rows-1, 0);
                    maze.setGoalPosition(goalRandomRow,cols-1);
                }
                else if (frameSideGoal == 1) //left
                {
                    goalRandomRow = chooseRandRow(maze, 0, rows-1, 0);
                    maze.setGoalPosition(goalRandomRow,0);
                }
                else //up
                {
                    goalRandomCol = chooseRandCol(maze,0, cols,0);
                    maze.setGoalPosition(0, goalRandomCol);
                }
            }
        }

        //left side
        else if (frameSideStart == 2)
        {
            startRandomRow = chooseRandRow(maze,0, rows,0);
            maze.setStartPosition(startRandomRow, 0);


            //up left corner-goal can be in right or down only
            if (startRandomRow == 0)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//right
                {
                    goalRandomRow = chooseRandRow(maze,cols-1, rows,1);
                    maze.setGoalPosition(goalRandomRow,cols -1);
                }
                else //down
                {
                    goalRandomCol = chooseRandCol(maze,rows-1, cols,1);
                    maze.setGoalPosition(rows-1, goalRandomCol);
                }
            }

            //down left corner-goal can be in right or up only
            else if(startRandomRow == rows-1)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//right
                {
                    goalRandomRow = chooseRandRow(maze,cols-1,rows-1,0);
                    maze.setGoalPosition(goalRandomRow,cols-1);
                }
                else //up
                {
                    goalRandomCol = chooseRandCol(maze,0, cols,1);
                    maze.setGoalPosition(0, goalRandomCol);
                }
            }

            //start is not in the corner
            if (!startInCorner)
            {
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 3);
                if (frameSideGoal == 0)//right
                {
                    goalRandomRow = chooseRandRow(maze,cols - 1, rows,0);
                    maze.setGoalPosition(goalRandomRow,cols - 1);
                }
                else if (frameSideGoal == 1) //up
                {
                    goalRandomCol = chooseRandCol(maze,0, cols,1);
                    maze.setGoalPosition(0, goalRandomCol);
                }
                else //down
                {
                    goalRandomCol = chooseRandCol(maze,rows-1,cols,1);
                    maze.setGoalPosition(rows-1,goalRandomCol);
                }
            }
        }

        //right side
        else
        {
            startRandomRow = chooseRandRow(maze,cols-1, rows,0);
            maze.setStartPosition(startRandomRow, cols-1);

            //up right corner-goal can be in left or down only
            if (startRandomRow == 0)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//left
                {
                    goalRandomRow = chooseRandRow(maze,0, rows,1);
                    maze.setGoalPosition(goalRandomRow,0);
                }
                else //down
                {
                    goalRandomCol = chooseRandCol(maze,rows-1,cols-1,0);
                    maze.setGoalPosition(rows-1, goalRandomCol);
                }
            }

            //down right corner-goal can be in left or up only
            else if (startRandomRow == rows-1)
            {
                startInCorner = true;
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 2);
                if (frameSideGoal == 0)//left
                {
                    goalRandomRow = chooseRandRow(maze,0,rows-1,0);
                    maze.setGoalPosition(goalRandomRow,0);
                }
                else //up
                {
                    goalRandomCol = chooseRandCol(maze,0,cols-1,0);
                    maze.setGoalPosition(0, goalRandomCol);
                }
            }

            //start is not in the corner
            if (!startInCorner)
            {
                frameSideGoal = ThreadLocalRandom.current().nextInt(0, 3);
                if (frameSideGoal == 0)//left
                {
                    goalRandomRow = chooseRandRow(maze,0, rows,0);
                    maze.setGoalPosition(goalRandomRow, 0);
                }
                else if (frameSideGoal == 1) //up
                {
                    goalRandomCol = chooseRandCol(maze,0,cols-1,0);
                    maze.setGoalPosition(0, goalRandomCol);
                }
                else //down
                {
                    goalRandomCol = chooseRandCol(maze,rows-1,cols-1,0);
                    maze.setGoalPosition(rows-1,goalRandomCol);
                }
            }
        }
    }
}
