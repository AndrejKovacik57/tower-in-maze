package sk.stuba.fei.uim.oop.PannelsAndFrame;
import sk.stuba.fei.uim.oop.Buttons.*;
import sk.stuba.fei.uim.oop.CreateMaze;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.SolvedMazeCounter;

import javax.swing.*;
import java.awt.*;


public class ButtonAndCounterPanel extends JPanel {
    private int panelWidth;
    private int panelHeight;

    private int rowCols;
    private int componentWidth;
    private int componentHeight;
    private ButtonUp moveUp;
    private ButtonDown moveDown;
    private ButtonLeft moveLeft;
    private ButtonRight moveRight;
    private ResetButton reset;
    private CreateMaze createMaze;
    private PaintGamePanel paintGamePanel;
    private Player player ;
    private SolvedMazeCounter solvedMazeCounter;


    public ButtonAndCounterPanel(int panelWidth, int panelHeight, CreateMaze createMaze, Player player, PaintGamePanel paintGamePanel, SolvedMazeCounter solvedMazeCounter, int rowCols) {
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        componentWidth=panelWidth/4-10;
        componentHeight = panelHeight/2-10;
        this.createMaze = createMaze;
        this.paintGamePanel=paintGamePanel;
        this.player = player;
        this.solvedMazeCounter = solvedMazeCounter;
        this.rowCols=rowCols;
        createButtons();
        createButtonAndCounterPanel();
    }
    public void createButtons(){
        moveUp=new ButtonUp("Up",componentWidth,componentHeight,createMaze,player,paintGamePanel,solvedMazeCounter,rowCols);
        moveDown=new ButtonDown("Down",componentWidth,componentHeight,createMaze,player,paintGamePanel,solvedMazeCounter,rowCols);
        moveLeft=new ButtonLeft("Left",componentWidth,componentHeight,createMaze,player,paintGamePanel,solvedMazeCounter,rowCols);
        moveRight=new ButtonRight("Right",componentWidth,componentHeight,createMaze,player,paintGamePanel,solvedMazeCounter,rowCols);
        reset=new ResetButton("Reset",componentWidth,componentHeight,createMaze,player,paintGamePanel,solvedMazeCounter);
    }

    public void createButtonAndCounterPanel(){
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.GRAY);
        this.setLayout(new GridLayout(2,3));
        this.add(solvedMazeCounter);
        this.add(moveUp);
        this.add(reset);
        this.add(moveLeft);
        this.add(moveDown);
        this.add(moveRight);




    }

}
