package sk.stuba.fei.uim.oop;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MouseMovement implements MouseListener {
    private int cellSize;
    private int rowCol;
    private ArrayList<Cell>[][]maze;
    private Player player ;
    private CreateMaze createMaze;

    private SolvedMazeCounter counter;
    public MouseMovement(int cellSize, int rowCol, Player player, CreateMaze createMaze,SolvedMazeCounter counter) {
        this.cellSize = cellSize;
        this.rowCol=rowCol;
        this.maze = createMaze.getMaze();
        this.player = player;
        this.createMaze=createMaze;
        this.counter=counter;

    }
    @Override
    public void mouseClicked(MouseEvent e) {

            System.out.println("klikol si na hraca");


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
