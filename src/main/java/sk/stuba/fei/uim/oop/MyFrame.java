package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame{
    private int frameWidth;
    private int frameHeight;
    private CreateMaze maze;
    private PaintGamePanel paintMaze;
    private ButtonAndCounterPanel buttonPanel;
    private KeyboardMovement playerMovementKeyboard;
    public MyFrame(int frameWidth, int frameHeight, CreateMaze maze, PaintGamePanel paintMaze, ButtonAndCounterPanel buttonPanel, KeyboardMovement playerMovementKeyboard){
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.maze = maze;
        this.paintMaze = paintMaze;
        this.buttonPanel = buttonPanel;
        this.playerMovementKeyboard = playerMovementKeyboard;
        createFrame();
    }



    public void createFrame(){
        this.setPreferredSize(new Dimension(frameWidth, frameHeight));
        this.setTitle("Maze game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(playerMovementKeyboard);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.add(paintMaze,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.SOUTH);
        this.pack();



    }





}
