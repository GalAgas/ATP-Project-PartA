package algorithms.search;

public abstract class AState
{
    private String name;
    private int cost;
    private AState parent;

    public AState(String name)
    {
        this.name = name;
    }


    public void setCost(int cost)
    {
        this.cost = cost;
    }

    public void setParent(AState parent)
    {
        this.parent = parent;
    }

    public String getName()
    {
        return name;
    }

    public int getCost()
    {
        return cost;
    }

    public AState getParent() {
        return parent;
    }
}


