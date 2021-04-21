package sk.stuba.fei.uim.oop;
import sk.stuba.fei.uim.oop.Buttons.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonAndCounterPanel extends JPanel {
    private int panelWidth;
    private int panelHeight;
    private ButtonUp moveUp;
    private ButtonDown moveDown;
    private ButtonLeft moveLeft;
    private ButtonRight moveRight;
    private ResetButton reset;
    private ResetButton iii;
    private int cellSize;
    private CreateMaze createMaze;
    private Player player ;


    public ButtonAndCounterPanel(int panelWidth, int panelHeight,int rowCol, int cellSize, CreateMaze createMaze, Player player, PaintGamePanel paintGamePanel) {
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.cellSize = cellSize;
        this.createMaze = createMaze;
        this.player = player;
        moveUp=new ButtonUp("Up",190,45,cellSize,createMaze,player,paintGamePanel);
        moveDown=new ButtonDown("Down",190,45,cellSize,createMaze,player,paintGamePanel);
        moveLeft=new ButtonLeft("Left",190,45,cellSize,createMaze,player,paintGamePanel);
        moveRight=new ButtonRight("Right",190,45,cellSize,createMaze,player,paintGamePanel);
        reset=new ResetButton("Reset",190,45);
        iii=new ResetButton("Reset",190,45);
        createButtonAndCounterPanel();
    }


    public void createButtonAndCounterPanel(){
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.GRAY);
        this.add(reset);
        this.add(moveUp);
        this.add(iii);
        this.add(moveLeft);
        this.add(moveDown);
        this.add(moveRight);




    }

}
