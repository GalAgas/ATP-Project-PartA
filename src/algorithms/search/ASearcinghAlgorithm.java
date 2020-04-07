package algorithms.search;

public abstract class ASearcinghAlgorithm implements ISearchingAlgorithm
{

    protected String name;
    private int visitedNoeds;

    @Override
    public String getName() { return name; }

    public int getNumberOfNodesEvaluated() { return visitedNoeds; }

}
