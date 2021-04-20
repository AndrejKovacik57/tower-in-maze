package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.Buttons.MoveButton;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame{
    private int frameWidth;
    private int frameHeight;
    private CreateMaze maze;
    private PaintGamePanel paintMaze;
    private ButtonAndCounterPanel buttonPanel;
    public MyFrame(int frameWidth,int frameHeight){
        this.frameWidth=frameWidth;
        this.frameHeight=frameHeight;
        maze = new CreateMaze(12);
        paintMaze= new PaintGamePanel(maze.getMaze());
        buttonPanel=new ButtonAndCounterPanel(600,200);

        createFrame();


    }
    public void createFrame(){
        this.setSize(frameWidth, frameHeight);
        this.setTitle("Maze game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.add(paintMaze,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.SOUTH);
        this.pack();




    }


}
