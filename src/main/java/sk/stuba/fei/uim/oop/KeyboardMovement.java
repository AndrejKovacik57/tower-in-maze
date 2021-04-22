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
    private SolvedMazeCounter counter;
    public KeyboardMovement(int cellSize, int rowCol, Player player, CreateMaze createMaze,SolvedMazeCounter counter,PaintGamePanel paintGamePanel) {
        this.cellSize = cellSize;
        this.rowCol=rowCol;
        this.maze = createMaze.getMaze();
        this.player = player;
        this.createMaze=createMaze;
        this.counter=counter;
        this.paintGamePanel=paintGamePanel;
    }



    @Override
    public void keyTyped(KeyEvent e) {

        maze=createMaze.getMaze();
        switch (e.getKeyChar()){
            case 'w':

                if(!maze[player.getX()][player.getY()].get(0).isTopWall()){


                    player.setY(player.getY()-1);
                    paintGamePanel.repaint();

                }
                break;
            case 's':
                if(!maze[player.getX()][player.getY()].get(0).isBottomWall()){

                    player.setY(player.getY()+1);
                    paintGamePanel.repaint();

                }
                break;
            case 'a':
                if(!maze[player.getX()][player.getY()].get(0).isLeftWall()){

                    player.setX(player.getX()-1);
                    paintGamePanel.repaint();

                }
                break;
            case 'd':
                if(!maze[player.getX()][player.getY()].get(0).isRightWall()){

                    player.setX(player.getX()+1);
                    paintGamePanel.repaint();

                }
                break;
        }
        if(player.getY()==rowCol-1 && player.getX()==rowCol-1){

            player.setX(0);
            player.setY(0);
            createMaze.createMaze();
            maze=createMaze.getMaze();
            paintGamePanel.setMaze(createMaze.getMaze());
            counter.setCounter(counter.getCounter()+1);
            counter.repaint();
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
