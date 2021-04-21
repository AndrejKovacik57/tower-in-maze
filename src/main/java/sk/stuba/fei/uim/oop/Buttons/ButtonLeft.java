package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.Cell;
import sk.stuba.fei.uim.oop.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ButtonLeft extends MoveButton{

    public ButtonLeft(String name, int buttonWidth, int buttonHeight , int cellSize, ArrayList<Cell>[][]maze, Player player) {
        setName(name);
        setButtonHeight(buttonHeight);
        setButtonWidth(buttonWidth);
        createButton();
        setCellSize(cellSize);
        setMaze(maze);
        setPlayer(player);
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
        System.out.println("ButtonLeft");
        if(!getMaze()[getPlayer().getXIndex()][getPlayer().getYIndex()].get(0).isLeftWall()){
            getPlayer().setLocation(getPlayer().getX()-getCellSize(),getPlayer().getY());
            getPlayer().setXIndex(getPlayer().getXIndex()-1);
        }

    }
}
