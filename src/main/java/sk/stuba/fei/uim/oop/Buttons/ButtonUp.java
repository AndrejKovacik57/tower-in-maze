package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.CreateMaze;
import sk.stuba.fei.uim.oop.PaintGamePanel;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.SolvedMazeCounter;

import java.awt.*;
import java.awt.event.ActionEvent;


public class ButtonUp extends MoveButton{

    public ButtonUp(String name, int buttonWidth, int buttonHeight , int cellSize, CreateMaze maze, Player player, PaintGamePanel paintGamePanel, SolvedMazeCounter counter, int rowCols) {
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

        if(!getMaze()[getPlayer().getXIndex()][getPlayer().getYIndex()].get(0).isTopWall()){
            getPlayer().setLocation(getPlayer().getX(),getPlayer().getY()-getCellSize());
            getPlayer().setYIndex(getPlayer().getYIndex()-1);
        }
        if(getPlayer().getYIndex()==getRowCols()-1 && getPlayer().getXIndex()==getRowCols()-1){

            getPlayer().setLocation(1,1);
            getPlayer().setXIndex(1);
            getPlayer().setYIndex(1);
            getCreateMaze().createMaze();
            setMaze(getCreateMaze().getMaze());
            getPaintGamePanel().setMaze(getCreateMaze().getMaze());
            getCounter().setCounter(getCounter().getCounter()+1);
            getCounter().repaint();
            getPaintGamePanel().repaint();
        }
    }
}
