package sk.stuba.fei.uim.oop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class PlayerMovement  implements KeyListener {
    private int cellSize;
    private ArrayList<Cell>[][]maze;
    private Player player ;


    public PlayerMovement(int cellSize, ArrayList<Cell>[][] maze, Player player) {
        this.cellSize = cellSize;
        this.maze = maze;
        this.player = player;
    }



    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'w':

                if(!maze[player.getXIndex()][player.getYIndex()].get(0).isTopWall()){
                    player.setLocation(player.getX(),player.getY()-cellSize);
                    player.setYIndex(player.getYIndex()-1);
                }
                break;
            case 's':
                if(!maze[player.getXIndex()][player.getYIndex()].get(0).isBottomWall()){
                    player.setLocation(player.getX(),player.getY()+cellSize);
                    player.setYIndex(player.getYIndex()+1);
                }
                break;
            case 'a':
                if(!maze[player.getXIndex()][player.getYIndex()].get(0).isLeftWall()){
                    player.setLocation(player.getX()-cellSize,player.getY());
                    player.setXIndex(player.getXIndex()-1);
                }
                break;
            case 'd':
                if(!maze[player.getXIndex()][player.getYIndex()].get(0).isRightWall()){
                    player.setLocation(player.getX()+cellSize,player.getY());
                    player.setXIndex(player.getXIndex()+1);
                }
                break;
        }


    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
