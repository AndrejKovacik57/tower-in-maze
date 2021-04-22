package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.CreateMaze;
import sk.stuba.fei.uim.oop.PaintGamePanel;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.SolvedMazeCounter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends MoveButton implements ActionListener {
    public ResetButton(String name, int buttonWidth, int buttonHeight , int cellSize, CreateMaze maze, Player player, PaintGamePanel paintGamePanel, SolvedMazeCounter counter) {
        setName(name);
        setButtonHeight(buttonHeight);
        setButtonWidth(buttonWidth);
        setCellSize(cellSize);
        setMaze(maze.getMaze());
        setCreateMaze(maze);
        setPlayer(player);
        setPaintGamePanel(paintGamePanel);
        setCounter(counter);
        createButton();


    }

    public void createButton(){
        this.setPreferredSize(new Dimension(getButtonWidth(), getButtonHeight()));
        this.setText(getName());
        this.setBackground(Color.RED);
        this.setFocusable(false);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {


        getPlayer().setX(0);
        getPlayer().setY(0);
        getCreateMaze().createMaze();
        setMaze(getCreateMaze().getMaze());
        getPaintGamePanel().setMaze(getCreateMaze().getMaze());
        getCounter().setCounter(0);
        getCounter().repaint();
        getPaintGamePanel().repaint();

    }


}
