package algorithms.search;

public abstract class ASearcinghAlgorithm implements ISearchingAlgorithm
{

    protected String name;
    protected int visitedNodes;

    @Override
    public String getName() { return name; }

    public int getNumberOfNodesEvaluated() { return visitedNodes; }

}
