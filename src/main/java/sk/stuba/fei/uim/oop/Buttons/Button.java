package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.*;
import sk.stuba.fei.uim.oop.PannelsAndFrame.PaintGamePanel;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


abstract class Button extends JButton implements ActionListener {
    protected String name;
    protected int buttonHeight;
    protected int buttonWidth;

    protected int rowCols;
    protected CreateMaze createMaze;
    protected ArrayList<Cell>[][]maze;
    protected Player player ;
    protected PaintGamePanel paintGamePanel;
    protected SolvedMazeCounter solvedMazeCounter;

    public Button() {
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

    public int getRowCols() {
        return rowCols;
    }

    public void setRowCols(int rowCols) {
        this.rowCols = rowCols;
    }

    public CreateMaze getCreateMaze() {
        return createMaze;
    }

    public void setCreateMaze(CreateMaze createMaze) {
        this.createMaze = createMaze;
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

    public PaintGamePanel getPaintGamePanel() {
        return paintGamePanel;
    }

    public void setPaintGamePanel(PaintGamePanel paintGamePanel) {
        this.paintGamePanel = paintGamePanel;
    }

    public SolvedMazeCounter getSolvedMazeCounter() {
        return solvedMazeCounter;
    }

    public void setSolvedMazeCounter(SolvedMazeCounter solvedMazeCounter) {
        this.solvedMazeCounter = solvedMazeCounter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
