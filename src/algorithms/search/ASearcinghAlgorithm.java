package algorithms.search;

public abstract class ASearcinghAlgorithm implements ISearchingAlgorithm
{

    private String name;
    private int visitedNoeds;

    @Override
    public String getName()
    {
        return name;
    }

    public ASearcinghAlgorithm(String name)
    {
        this.name = name;
    }

    public int getNumberOfNodesEvaluated()
    {
        return visitedNoeds;
    }

}
