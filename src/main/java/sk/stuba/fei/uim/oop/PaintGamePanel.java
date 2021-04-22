package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintGamePanel extends JPanel {
    private  int gridSize;
    private  int panelSize ;
    private  int rows;
    private  int columns;
    private  int cellSize;
    private ArrayList<Cell>[][]maze;
    private Player player;
    private MouseMovement mouseMovement;

    public PaintGamePanel(int gridSize, int panelSize, int rows, int columns, int cellSize, ArrayList<Cell>[][] maze ,Player player,MouseMovement mouseMovement) {
        this.gridSize = gridSize;
        this.panelSize = panelSize;
        this.rows = rows;
        this.columns = columns;
        this.cellSize = cellSize;
        this.maze = maze;
        this.player=player;
        this.mouseMovement=mouseMovement;
        createMazePanel();
    }


    public void createMazePanel(){
        this.setPreferredSize(new Dimension(panelSize, panelSize+1));
       // this.add(player);
        this.setLayout(null);

        //this.addMouseListener(mouseMovement);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMaze(ArrayList<Cell>[][] maze) {
        this.maze = maze;
    }


   @Override
    public void paintComponent(Graphics g) {
         Graphics2D g2D = (Graphics2D)g;
         g2D.setStroke(new BasicStroke(gridSize));
         g2D.setColor(Color.CYAN);
         g2D.fillRect(0,0,panelSize,panelSize);

         for (int x=0; x<rows;x++){
             for (int y=0; y<columns;y++){

                 g2D.setColor(Color.PINK);
                 g2D.fillOval(maze[rows-1][columns-1].get(0).getXIndex()*cellSize,maze[rows-1][columns-1].get(0).getYIndex()*cellSize,cellSize-1,cellSize-1);

                 g2D.setColor(Color.RED);
                 if(maze[x][y].get(0).isTopWall()){
                     g2D.drawLine(maze[x][y].get(0).getXIndex()*cellSize, maze[x][y].get(0).getYIndex()*cellSize, maze[x][y].get(0).getXIndex()*cellSize+cellSize, maze[x][y].get(0).getYIndex()*cellSize);
                 }
                 if(maze[x][y].get(0).isBottomWall()){
                     g2D.drawLine(maze[x][y].get(0).getXIndex()*cellSize, maze[x][y].get(0).getYIndex()*cellSize+cellSize, maze[x][y].get(0).getXIndex()*cellSize+cellSize, maze[x][y].get(0).getYIndex()*cellSize+cellSize);
                 }
                 if(maze[x][y].get(0).isLeftWall()){
                     g2D.drawLine(maze[x][y].get(0).getXIndex()*cellSize, maze[x][y].get(0).getYIndex()*cellSize, maze[x][y].get(0).getXIndex()*cellSize, maze[x][y].get(0).getYIndex()*cellSize+cellSize);
                 }
                 if(maze[x][y].get(0).isRightWall()){
                     g2D.drawLine(maze[x][y].get(0).getXIndex()*cellSize+cellSize, maze[x][y].get(0).getYIndex()*cellSize, maze[x][y].get(0).getXIndex()*cellSize+cellSize, maze[x][y].get(0).getYIndex()*cellSize+cellSize);

                 }
             }
         }
       g2D.setColor(Color.ORANGE);
       g2D.fillOval(player.getX()*cellSize, player.getY()*cellSize, player.getPlayerSize(), player.getPlayerSize());
     }



}
