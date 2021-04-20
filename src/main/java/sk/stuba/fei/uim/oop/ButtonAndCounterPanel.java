package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.Buttons.MoveButton;
import sk.stuba.fei.uim.oop.Buttons.ResetButton;

import javax.swing.*;
import java.awt.*;

public class ButtonAndCounterPanel extends JPanel {
    private int panelWidth;
    private int panelHight;
    private MoveButton moveUp;
    private MoveButton moveDown;
    private MoveButton moveLeft;
    private MoveButton moveRight;
    private ResetButton reset;
    private MoveButton iii;
    public ButtonAndCounterPanel(int panelWidth, int panelHight) {
        this.panelWidth=panelWidth;
        this.panelHight=panelHight;
        moveUp=new MoveButton("Up",190,40);
        moveDown=new MoveButton("Down",190,40);
        moveLeft=new MoveButton("Left",190,40);
        moveRight=new MoveButton("Right",190,40);
        reset=new ResetButton("reset",190,40);
        iii=new MoveButton("iii",190,40);
        createButtonAndCounterPanel();
    }

    public void createButtonAndCounterPanel(){

        this.setSize(panelWidth,panelHight);
        this.setBackground(Color.GRAY);

        this.add(iii);
        this.add(moveUp);
        this.add(reset);
        this.add(moveLeft);
        this.add(moveDown);
        this.add(moveRight);


    }
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(600, 100);
    }
}
