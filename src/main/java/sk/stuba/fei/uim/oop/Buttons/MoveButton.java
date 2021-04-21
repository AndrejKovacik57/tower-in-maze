package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.Cell;
import sk.stuba.fei.uim.oop.Player;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MoveButton extends JButton implements ActionListener {
    private String name;
    private int buttonHeight;
    private int buttonWidth;
    private int cellSize;
    private ArrayList<Cell>[][]maze;
    private Player player ;

    public MoveButton() {
        this.addActionListener(this);
    }

    public int getButtonHeight() {
        return buttonHeight;
    }

    public void setButtonHeight(int buttonHeight) {
        this.buttonHeight = buttonHeight;
    }

    public int getButtonWidth() {
        return buttonWidth;
    }

    public void setButtonWidth(int buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }



    public ArrayList<Cell>[][] getMaze() {
        return maze;
    }

    public void setMaze(ArrayList<Cell>[][] maze) {
        this.maze = maze;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
