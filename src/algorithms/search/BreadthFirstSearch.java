package algorithms.search;


import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearcinghAlgorithm {

    private Queue<AState> Q;

    public BreadthFirstSearch() {
        super.name = "Breadth First Search";
        Q = new LinkedList<AState>();
    }

    @Override
    public Solution solve(ISearchable s)
    {
        Q.add(s.getStart());
        s.getStart().setVisited(true);
        Solution sol = null;

        while (!Q.isEmpty()) {
            AState currState = Q.remove();

            //found goal
            if (currState == s.getGoal())
            {
                //building the solution's path
                ArrayList<AState> path = new ArrayList<AState>();
                while (currState != null)
                {
                    path.add(currState);
                    //changes all isVisited back to false
                    currState.setVisited(false);
                    currState = currState.getParent();
                }
                Collections.reverse(path);
                sol = new Solution(path);
                return sol;
            }

            //get all currState's neigbours
            ArrayList<AState> allPossNext = s.getAllPossibleStates(currState);
            for (int i = 0; i < allPossNext.size(); i++)
            {
                AState nextState = allPossNext.get(i);
                if (!nextState.isVisited())
                {
                    nextState.setVisited(true);
                    visitedNodes ++;
                    nextState.setParent(currState);
                    Q.add(nextState);
                }
            }
        }

        return sol;
    }

}
