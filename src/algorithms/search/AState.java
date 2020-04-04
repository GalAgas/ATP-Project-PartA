package algorithms.search;

public abstract class AState
{
    private String name;
    private int cost;
    private AState parent;
    private AState[] neigbours;

    public AState(String name)
    {
        this.name = name;
        neigbours = new AState[4];
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

    public void setName(String name) {
        this.name = name;
    }

    public AState[] getNeigbours() {
        return neigbours;
    }

    public String toString() { return ("{" + name.charAt(0) + "," + name.charAt(1) +"}"); }

}


