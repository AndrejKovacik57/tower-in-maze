package sk.stuba.fei.uim.oop.Buttons;

import sk.stuba.fei.uim.oop.CreateMaze;
import sk.stuba.fei.uim.oop.PannelsAndFrame.PaintGamePanel;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.SolvedMazeCounter;

import java.awt.*;
import java.awt.event.ActionEvent;


public class ButtonDown extends Button {

    public ButtonDown(String name, int buttonWidth, int buttonHeight , CreateMaze createMaze, Player player, PaintGamePanel paintGamePanel, SolvedMazeCounter solvedMazeCounter, int rowCols) {
        setName(name);
        setButtonHeight(buttonHeight);
        setButtonWidth(buttonWidth);
        setMaze(createMaze.getMaze());
        setCreateMaze(createMaze);
        setPlayer(player);
        setPaintGamePanel(paintGamePanel);
        setSolvedMazeCounter(solvedMazeCounter);
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
        if(!getMaze()[getPlayer().getX()][getPlayer().getY()].get(0).isBottomWall()){
            getPlayer().setY(getPlayer().getY()+1);
            getPaintGamePanel().repaint();
        }
        if(getPlayer().getY()==getRowCols()-1 && getPlayer().getX()==getRowCols()-1){


            getPlayer().setX(0);
            getPlayer().setY(0);
            getCreateMaze().newMaze();
            setMaze(getCreateMaze().getMaze());
            getPaintGamePanel().setMaze(getCreateMaze().getMaze());
            getSolvedMazeCounter().setCounter(getSolvedMazeCounter().getCounter()+1);
            getSolvedMazeCounter().repaint();
            getPaintGamePanel().repaint();

        }

    }
}
