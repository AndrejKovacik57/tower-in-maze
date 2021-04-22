package sk.stuba.fei.uim.oop.Buttons;


import sk.stuba.fei.uim.oop.CreateMaze;
import sk.stuba.fei.uim.oop.PaintGamePanel;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.SolvedMazeCounter;

import java.awt.*;
import java.awt.event.ActionEvent;


public class ButtonLeft extends MoveButton{

    public ButtonLeft(String name, int buttonWidth, int buttonHeight , int cellSize, CreateMaze maze, Player player, PaintGamePanel paintGamePanel, SolvedMazeCounter counter, int rowCols) {
        setName(name);
        setButtonHeight(buttonHeight);
        setButtonWidth(buttonWidth);
        setCellSize(cellSize);
        setMaze(maze.getMaze());
        setCreateMaze(maze);
        setPlayer(player);
        setPaintGamePanel(paintGamePanel);
        setCounter(counter);
        setRowCols(rowCols);
        createButton();
    }

    public void createButton(){
        this.setPreferredSize(new Dimension(getButtonWidth(), getButtonHeight()));
        this.setText(getName());
        this.setBackground(Color.WHITE);
        this.setFocusable(false);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        setMaze(getCreateMaze().getMaze());
        if(!getMaze()[getPlayer().getX()][getPlayer().getY()].get(0).isLeftWall()){
            getPlayer().setX(getPlayer().getX()-1);
            getPaintGamePanel().repaint();
        }
        if(getPlayer().getY()==getRowCols()-1 && getPlayer().getX()==getRowCols()-1){


            getPlayer().setX(0);
            getPlayer().setY(0);
            getCreateMaze().createMaze();
            setMaze(getCreateMaze().getMaze());
            getPaintGamePanel().setMaze(getCreateMaze().getMaze());
            getCounter().setCounter(getCounter().getCounter()+1);
            getCounter().repaint();
            getPaintGamePanel().repaint();

        }
    }
}
