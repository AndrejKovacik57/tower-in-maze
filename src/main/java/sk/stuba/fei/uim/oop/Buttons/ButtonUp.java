package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.CreateMaze;
import sk.stuba.fei.uim.oop.PaintGamePanel;
import sk.stuba.fei.uim.oop.Player;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ButtonUp extends MoveButton{

    public ButtonUp(String name, int buttonWidth, int buttonHeight , int cellSize, CreateMaze maze, Player player, PaintGamePanel paintGamePanel) {
        setName(name);
        setButtonHeight(buttonHeight);
        setButtonWidth(buttonWidth);
        createButton();
        setCellSize(cellSize);
        setMaze(maze.getMaze());
        setCreateMaze(maze);
        setPlayer(player);
        setPaintGamePanel(paintGamePanel);
    }

    public void createButton(){
        this.setText(getName());
        this.setBackground(Color.WHITE);
        this.setFocusable(false);
        this.setVisible(true);
    }
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(getButtonWidth(), getButtonHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setMaze(getCreateMaze().getMaze());

        if(!getMaze()[getPlayer().getXIndex()][getPlayer().getYIndex()].get(0).isTopWall()){
            getPlayer().setLocation(getPlayer().getX(),getPlayer().getY()-getCellSize());
            getPlayer().setYIndex(getPlayer().getYIndex()-1);
        }
        if(getPlayer().getYIndex()==4-1 && getPlayer().getXIndex()==4-1){
            System.out.println("ciel");
            getPlayer().setLocation(1,1);
            getPlayer().setXIndex(1);
            getPlayer().setYIndex(1);
            getCreateMaze().createMaze();
            setMaze(getCreateMaze().getMaze());
            getPaintGamePanel().setMaze(getCreateMaze().getMaze());
            getPaintGamePanel().repaint();
        }
    }
}