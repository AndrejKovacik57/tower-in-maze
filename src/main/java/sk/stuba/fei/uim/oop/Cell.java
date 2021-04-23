package sk.stuba.fei.uim.oop;



public class Cell{
    private boolean visited;
    private boolean topWall;
    private boolean bottomWall;
    private boolean leftWall;
    private boolean rightWall;
    private final int xIndex;
    private final int yIndex;

    public Cell(boolean visited, boolean topWall, boolean bottomWall, boolean leftWall, boolean rightWall, int xIndex, int yIndex) {
        this.visited = visited;
        this.topWall = topWall;
        this.bottomWall = bottomWall;
        this.leftWall = leftWall;
        this.rightWall = rightWall;
        this.xIndex = xIndex;
        this.yIndex = yIndex;

    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isTopWall() {
        return topWall;
    }

    public boolean isBottomWall() {
        return bottomWall;
    }

    public boolean isLeftWall() {
        return leftWall;
    }

    public boolean isRightWall() {
        return rightWall;
    }

    public int getXIndex() {
        return xIndex;
    }

    public int getYIndex() {
        return yIndex;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setTopWall(boolean topWall) {
        this.topWall = topWall;
    }

    public void setBottomWall(boolean bottomWall) {
        this.bottomWall = bottomWall;
    }

    public void setLeftWall(boolean leftWall) {
        this.leftWall = leftWall;
    }

    public void setRightWall(boolean rightWall) {
        this.rightWall = rightWall;
    }
}
