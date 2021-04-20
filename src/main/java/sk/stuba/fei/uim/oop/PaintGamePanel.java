package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintGamePanel extends JPanel implements KeyListener {
    public final int gridSize=1;
    private final int panelSize =600;
    private final int rows=12;
    private final int columns=12;
    private final int WallSize= (panelSize/rows);
    private final int cellSize= (panelSize/rows);
    private ArrayList<Cell>[][]maze;
    private Player player = new Player(cellSize-1,0,0);

    public PaintGamePanel(ArrayList<Cell>[][]maze){
        this.maze =  maze;
        createMazePanel();

    }

    public void createMazePanel(){
       // this.setSize(panelSize, panelSize+1);
        this.setLayout(null);
        this.setFocusable(true);
        this.addKeyListener(this);
        this.add(player);

    }
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(panelSize, panelSize+1);
    }
    @Override
    public void paint(Graphics g) {
         Graphics2D g2D = (Graphics2D)g;
         g2D.setStroke(new BasicStroke(gridSize));
         g2D.setColor(Color.CYAN);
         g2D.fillRect(0,0,panelSize,panelSize);
         /*g2D.setColor(Color.RED);
         g2D.drawRect(0,0,panelSize,panelSize);*/
         for (int x=0; x<rows;x++){
             for (int y=0; y<columns;y++){

                 g2D.setColor(Color.PINK);
                 g2D.fillRect(maze[rows-1][columns-1].get(0).getXIndex()*cellSize,maze[rows-1][columns-1].get(0).getYIndex()*cellSize,cellSize,cellSize);

                 g2D.setColor(Color.BLACK);
                 if(maze[x][y].get(0).isTopWall()){
                     g2D.drawLine(maze[x][y].get(0).getXIndex()*WallSize, maze[x][y].get(0).getYIndex()*WallSize, maze[x][y].get(0).getXIndex()*WallSize+WallSize, maze[x][y].get(0).getYIndex()*WallSize);
                 }
                 if(maze[x][y].get(0).isBottomWall()){
                     g2D.drawLine(maze[x][y].get(0).getXIndex()*WallSize, maze[x][y].get(0).getYIndex()*WallSize+WallSize, maze[x][y].get(0).getXIndex()*WallSize+WallSize, maze[x][y].get(0).getYIndex()*WallSize+WallSize);
                 }
                 if(maze[x][y].get(0).isLeftWall()){
                     g2D.drawLine(maze[x][y].get(0).getXIndex()*WallSize, maze[x][y].get(0).getYIndex()*WallSize, maze[x][y].get(0).getXIndex()*WallSize, maze[x][y].get(0).getYIndex()*WallSize+WallSize);
                 }
                 if(maze[x][y].get(0).isRightWall()){
                     g2D.drawLine(maze[x][y].get(0).getXIndex()*WallSize+WallSize, maze[x][y].get(0).getYIndex()*WallSize, maze[x][y].get(0).getXIndex()*WallSize+WallSize, maze[x][y].get(0).getYIndex()*WallSize+WallSize);

                 }
             }
         }
     }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped");
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
