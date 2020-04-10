package algorithms.search;

import java.util.PriorityQueue;

public class BestFirstSearch extends BreadthFirstSearch
{
    public BestFirstSearch()
    {
        name = "Best First Search";
        Q = new PriorityQueue<AState>();
    }

//    public Solution solve(ISearchable s) {
//        return null;
//    }
}
