package algorithms.search;

import java.util.ArrayList;

public class Solution
{
    private AState goalState;

    public Solution(AState state)
    {
        if (state == null)
            state.setName("No solution");
        goalState = state;
    }

    public ArrayList<AState> getSolutionPath()
    {
        ArrayList<AState> sol = new ArrayList<AState>();
        //while (goalState.getParent() != )
        return sol;
    }

    public String toString()
    {
        { return ("{" + goalState.getName().charAt(0) + "," + goalState.getName().charAt(1) +"}"); }
    }


}
