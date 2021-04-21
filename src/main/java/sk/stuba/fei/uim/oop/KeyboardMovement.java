package sk.stuba.fei.uim.oop;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyboardMovement implements KeyListener {
    private int cellSize;
    private int rowCol;
    private ArrayList<Cell>[][]maze;
    private Player player ;
    private CreateMaze createMaze;
    private PaintGamePanel paintGamePanel;

    public KeyboardMovement(int cellSize, int rowCol, Player player, CreateMaze createMaze, PaintGamePanel paintGamePanel) {
        this.cellSize = cellSize;
        this.rowCol=rowCol;
        this.maze = createMaze.getMaze();
        this.player = player;
        this.createMaze=createMaze;
        this.paintGamePanel=paintGamePanel;
    }



    @Override
    public void keyTyped(KeyEvent e) {

        maze=createMaze.getMaze();
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
        if(player.getYIndex()==rowCol-1 && player.getXIndex()==rowCol-1){
            System.out.println("ciel");
            player.setXIndex(0);
            player.setYIndex(0);
            player.setLocation(1,1);
            createMaze.createMaze();
            maze=createMaze.getMaze();
            paintGamePanel.setMaze(createMaze.getMaze());
            paintGamePanel.repaint();

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
