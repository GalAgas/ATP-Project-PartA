package algorithms.search;

public abstract class ASearcinghAlgorithm implements ISearchingAlgorithm
{

    private String name;

    @Override
    public String getName()
    {
        return name;
    }


    public int getNumberOfNodesEvaluated()
    {
        return 0;
    }
}
