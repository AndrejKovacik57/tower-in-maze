package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.Cell;
import sk.stuba.fei.uim.oop.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ButtonDown extends MoveButton {

    public ButtonDown(String name, int buttonWidth, int buttonHeight ,int cellSize,ArrayList<Cell>[][]maze,Player player) {
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
        System.out.println("ButtonDown");
        if(!getMaze()[getPlayer().getXIndex()][getPlayer().getYIndex()].get(0).isBottomWall()){
            getPlayer().setLocation(getPlayer().getX(),getPlayer().getY()+getCellSize());
            getPlayer().setYIndex(getPlayer().getYIndex()+1);
        }


    }
}
