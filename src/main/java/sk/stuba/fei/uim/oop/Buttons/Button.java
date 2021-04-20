package sk.stuba.fei.uim.oop.Buttons;

import javax.swing.*;



public class Button extends JButton {
    private String name;
    private int buttonHeight;
    private int buttonWidth;

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


}
