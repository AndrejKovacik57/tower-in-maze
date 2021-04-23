package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class SolvedMazeCounter extends JLabel {
    private final int width;
    private final int height;
    private int counter=0;

    public SolvedMazeCounter(int width, int height ) {
        this.width = width;
        this.height = height;
        createCounterLabel();
    }
    public void createCounterLabel(){
        this.setPreferredSize(new Dimension(width,height));

        this.setFocusable(false);
        this.setVisible(true);

    }
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.GRAY);
        g2D.fillRect(1,1,width,height);
        g2D.setColor(Color.BLACK);
        g2D.drawString("Solved mazes: "+counter,width/2-width/8,height - height/2);

    }
}
