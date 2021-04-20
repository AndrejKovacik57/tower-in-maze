package sk.stuba.fei.uim.oop.Buttons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveButton extends Button implements ActionListener {

    public MoveButton(String name,int buttonWidth,int buttonHeight ) {
        setName(name);
        setButtonHeight(buttonHeight);
        setButtonWidth(buttonWidth);
        createButton();


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

    }
}
