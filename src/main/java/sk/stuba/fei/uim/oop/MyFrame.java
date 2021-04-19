package sk.stuba.fei.uim.oop;
import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame{
    private int size;
    private Maze maze;
    public MyFrame(int size){
        this.size=size;
        maze = new Maze(550,11);
        createFrame();

    }
    public void createFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(size,size);
        this.getContentPane().setBackground(Color.BLUE);
        this.add(maze);
        this.setVisible(true);


    }
}
