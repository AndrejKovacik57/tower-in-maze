package sk.stuba.fei.uim.oop.Buttons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends Button implements ActionListener {
    public ResetButton(String name,int buttonWidth,int buttonHeight ) {
        setName(name);
        setButtonHeight(buttonHeight);
        setButtonWidth(buttonWidth);
        createButton();


    }

    public void createButton(){
        this.setText(getName());
        this.setBackground(Color.RED);
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
