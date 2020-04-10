package test;

import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.*;

import java.util.ArrayList;

public class RunSearchOnMaze {
    public static void main(String[] args) {
        //IMazeGenerator mg = new MyMazeGenerator();
        IMazeGenerator mg = new EmptyMazeGenerator();
        Maze maze = mg.generate(10, 10);
        SearchableMaze searchableMaze = new SearchableMaze(maze);

        maze.print();
//        for (AState s:searchableMaze.getAllStates().values()) {
//            System.out.println(s.getName());
//
//            System.out.println(s.getCost());
//            System.out.println("****");
//        }

        solveProblem(searchableMaze, new BreadthFirstSearch());
        //solveProblem(searchableMaze, new DepthFirstSearch());
        solveProblem(searchableMaze, new BestFirstSearch());
    }

    private static void solveProblem(ISearchable domain, ISearchingAlgorithm searcher) {

        long startTime = System.currentTimeMillis();
        Solution solution = searcher.solve(domain);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);


        //Solve a searching problem with a searcher
//        Solution solution = searcher.solve(domain);
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));
//        // Printing Solution Path
//        System.out.println("Solution path:");
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        for (int i = 0; i < solutionPath.size(); i++)
        {
            System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
        }

        System.out.println(domain.getGoal().getCost());

    }
}
