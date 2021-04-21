package sk.stuba.fei.uim.oop;
import sk.stuba.fei.uim.oop.Buttons.*;

import javax.swing.*;
import java.awt.*;


public class ButtonAndCounterPanel extends JPanel {
    private int panelWidth;
    private int panelHeight;
    private int cellSize;
    private int rowCols;
    private ButtonUp moveUp;
    private ButtonDown moveDown;
    private ButtonLeft moveLeft;
    private ButtonRight moveRight;
    private ResetButton reset;
    private CreateMaze createMaze;
    private PaintGamePanel paintGamePanel;
    private Player player ;
    private SolvedMazeCounter counter;


    public ButtonAndCounterPanel(int panelWidth, int panelHeight,int rowCol, int cellSize, CreateMaze createMaze, Player player, PaintGamePanel paintGamePanel,SolvedMazeCounter counter, int rowCols) {
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.cellSize = cellSize;
        this.createMaze = createMaze;
        this.paintGamePanel=paintGamePanel;
        this.player = player;
        this.counter = counter;
        this.rowCols=rowCols;
        createButtons();
        createButtonAndCounterPanel();
    }
    public void createButtons(){
        moveUp=new ButtonUp("Up",190,45,cellSize,createMaze,player,paintGamePanel,counter,rowCols);
        moveDown=new ButtonDown("Down",190,45,cellSize,createMaze,player,paintGamePanel,counter,rowCols);
        moveLeft=new ButtonLeft("Left",190,45,cellSize,createMaze,player,paintGamePanel,counter,rowCols);
        moveRight=new ButtonRight("Right",190,45,cellSize,createMaze,player,paintGamePanel,counter,rowCols);
        reset=new ResetButton("Reset",190,45,cellSize,createMaze,player,paintGamePanel,counter);
    }

    public void createButtonAndCounterPanel(){
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.GRAY);
        this.add(counter);
        this.add(moveUp);
        this.add(reset);
        this.add(moveLeft);
        this.add(moveDown);
        this.add(moveRight);




    }

}
