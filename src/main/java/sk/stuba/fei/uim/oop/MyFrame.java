package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame{

    private PaintGamePanel paintMaze;
    private ButtonAndCounterPanel buttonPanel;
    private KeyboardMovement keyboardMovement;

    public MyFrame(PaintGamePanel paintMaze, ButtonAndCounterPanel buttonPanel, KeyboardMovement keyboardMovement){

        this.paintMaze = paintMaze;
        this.buttonPanel = buttonPanel;
        this.keyboardMovement = keyboardMovement;


        createFrame();

    }



    public void createFrame(){
        this.setTitle("Maze game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyboardMovement);
        this.setVisible(true);
        this.setResizable(false);
        this.add(paintMaze,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.SOUTH);
        this.pack();




    }





}
