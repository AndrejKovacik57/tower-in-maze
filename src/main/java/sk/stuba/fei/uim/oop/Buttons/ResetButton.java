package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.CreateMaze;
import sk.stuba.fei.uim.oop.PannelsAndFrame.PaintGamePanel;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.SolvedMazeCounter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends Button implements ActionListener {
    public ResetButton(String name, int buttonWidth, int buttonHeight , CreateMaze maze, Player player, PaintGamePanel paintGamePanel, SolvedMazeCounter solvedMazeCounter) {
        setName(name);
        setButtonHeight(buttonHeight);
        setButtonWidth(buttonWidth);
        setMaze(maze.getMaze());
        setCreateMaze(maze);
        setPlayer(player);
        setPaintGamePanel(paintGamePanel);
        setSolvedMazeCounter(solvedMazeCounter);
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
        getCreateMaze().newMaze();
        setMaze(getCreateMaze().getMaze());
        getPaintGamePanel().setMaze(getCreateMaze().getMaze());
        getSolvedMazeCounter().setCounter(0);
        getSolvedMazeCounter().repaint();
        getPaintGamePanel().repaint();

    }


}
