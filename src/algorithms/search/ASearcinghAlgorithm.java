package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;

public abstract class ASearcinghAlgorithm implements ISearchingAlgorithm
{

    protected String name;
    protected int visitedNodes;

    @Override
    public String getName() { return name; }

    public int getNumberOfNodesEvaluated() { return visitedNodes; }

    //building the solution's path
    public Solution createSolPath (AState currState)
    {
        Solution sol;
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

}
