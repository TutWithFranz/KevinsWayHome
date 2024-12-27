package franz.with.tut.logic.path.finding;

public abstract class Node {
    private int gCost;
    private int hCost;
    private Node previous;

    // setter

    public void setGCost(int gCost) {
        this.gCost = gCost;
    }

    public void setHCost(int hCost) {
        this.hCost = hCost;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    // getter

    public int getGCost() {
        return gCost;
    }

    public int getHCost() {
        return hCost;
    }

    public int getFCost() {
        return gCost + hCost;
    }

    public Node getPrevious() {
        return previous;
    }
}
