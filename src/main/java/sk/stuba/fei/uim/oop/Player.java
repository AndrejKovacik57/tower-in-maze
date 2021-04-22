package sk.stuba.fei.uim.oop;

public class Player {
    private int playerSize;
    private int x;
    private int y;

    public Player(int playerSize,int x,int y) {
        this.playerSize=playerSize;
        this.x=x;
        this.y=y;


    }


    public int getPlayerSize() {
        return playerSize;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
