package sk.stuba.fei.uim.oop;

import java.awt.*;

public class Player extends Label {
    private int playerSize;
    private int xIndex;
    private int yIndex;
    public Player(int playerSize,int x,int y) {
        this.playerSize=playerSize;
        this.xIndex=x;
        this.yIndex=y;
        createPlayerLabel();
    }
    public void createPlayerLabel(){
        this.setBounds(1,1,playerSize,playerSize);

    }


    public int getXIndex() {
        return xIndex;
    }

    public void setXIndex(int xIndex) {
        this.xIndex = xIndex;
    }

    public int getYIndex() {
        return yIndex;
    }

    public void setYIndex(int yIndex) {
        this.yIndex = yIndex;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.CYAN);
        g2D.fillRect(0,0,playerSize,playerSize);
        g2D.setColor(Color.ORANGE);
        g2D.fillOval(0,0,playerSize,playerSize);
    }
}
