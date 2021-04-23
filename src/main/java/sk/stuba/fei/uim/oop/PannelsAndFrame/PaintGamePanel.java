package sk.stuba.fei.uim.oop.PannelsAndFrame;

import sk.stuba.fei.uim.oop.Cell;
import sk.stuba.fei.uim.oop.CreateMaze;
import sk.stuba.fei.uim.oop.Player;
import sk.stuba.fei.uim.oop.SolvedMazeCounter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintGamePanel extends JPanel implements MouseListener {
    private  int gridSize;
    private  int panelSize ;
    private  int rows;
    private  int columns;
    private  int cellSize;
    private int moveUp=0;
    private int moveDown=0;
    private int moveLeft=0;
    private int moveRight=0;
    private int possibleMovesSize;
    private CreateMaze createMaze;
    private ArrayList<Cell>[][]maze;
    private Player player;
    private SolvedMazeCounter solvedMazeCounter;


    public PaintGamePanel(int gridSize, int panelSize, int rowCol, int cellSize, CreateMaze createMaze , Player player, SolvedMazeCounter solvedMazeCounter) {
        this.gridSize = gridSize;
        this.panelSize = panelSize;
        this.rows = rowCol;
        this.columns = rowCol;
        this.cellSize = cellSize;
        this.createMaze=createMaze;
        this.maze = createMaze.getMaze();
        this.player=player;
        this.solvedMazeCounter=solvedMazeCounter;
        possibleMovesSize=player.getPlayerSize()/2;
        createMazePanel();
    }


    public void createMazePanel(){
        this.setPreferredSize(new Dimension(panelSize+1, panelSize+1));
        this.addMouseListener(this);



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

         for (int x=0; x<columns;x++){
             for (int y=0; y<rows;y++){

                 g2D.setColor(Color.PINK);
                 g2D.fillOval(maze[columns-1][rows-1].get(0).getXIndex()*cellSize,maze[columns-1][rows-1].get(0).getYIndex()*cellSize,cellSize,cellSize);

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

       if(player.isPlayerSelect()){

           g2D.setColor(Color.RED);
           g2D.fillOval(player.getX()*cellSize, player.getY()*cellSize, player.getPlayerSize(), player.getPlayerSize());
            moveDown=0;moveUp=0;moveLeft=0;moveRight=0;
           g2D.setColor(Color.YELLOW);
           for(int i=1; !maze[player.getX()][player.getY()-i+1].get(0).isTopWall();i++){
               moveUp++;
               g2D.fillOval(player.getX()*cellSize+(cellSize/4), (player.getY()-i)*cellSize+(cellSize/4), possibleMovesSize, possibleMovesSize);
           }

           for(int i=1; !maze[player.getX()][player.getY()+i-1].get(0).isBottomWall();i++){
               moveDown++;
               g2D.fillOval(player.getX()*cellSize+(cellSize/4), (player.getY()+i)*cellSize+(cellSize/4), possibleMovesSize, possibleMovesSize);
           }

           for(int i=1; !maze[player.getX()-i+1][player.getY()].get(0).isLeftWall();i++){
               moveLeft++;
               g2D.fillOval((player.getX()-i)*cellSize+(cellSize/4), player.getY()*cellSize+(cellSize/4), possibleMovesSize, possibleMovesSize);
           }

           for(int i=1; !maze[player.getX()+i-1][player.getY()].get(0).isRightWall();i++){
               moveRight++;
               g2D.fillOval((player.getX()+i)*cellSize+(cellSize/4), player.getY()*cellSize+(cellSize/4), possibleMovesSize, possibleMovesSize);
           }

           player.setPlayerSelect(false);

       }
     }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        maze=createMaze.getMaze();
        //klik na hraca zvyrazni
        if(e.getX()>= player.getX()*cellSize && e.getX()<=player.getX()*cellSize+cellSize && e.getY()>= player.getY()*cellSize && e.getY()<= player.getY()*cellSize+cellSize){
            player.setPlayerSelect(true);
            this.repaint();
        }
        //pohyb hore
        else if(e.getX()>= player.getX()*cellSize && e.getX()<= player.getX()*cellSize+cellSize && player.getY()-e.getY()/cellSize<= moveUp && e.getY()/cellSize< player.getY()){

            player.setY(e.getY()/cellSize);

            this.repaint();
        }
        //pohyb dole
        else if(e.getX()>= player.getX()*cellSize && e.getX()<= player.getX()*cellSize+cellSize && e.getY()/cellSize -player.getY()<= moveDown && e.getY()/cellSize> player.getY()){

            player.setY(e.getY()/cellSize);

            this.repaint();
        }
        //pohyb do lava
        else if(e.getY()>= player.getY()*cellSize && e.getY()<= player.getY()*cellSize+cellSize && player.getX()-e.getX()/cellSize<= moveLeft && e.getX()/cellSize< player.getX()){

            player.setX(e.getX()/cellSize);

            this.repaint();
        }
        //pohyb do prava
        else if(e.getY()>= player.getY()*cellSize && e.getY()<= player.getY()*cellSize+cellSize && e.getX()/cellSize-player.getX()<= moveRight && e.getX()/cellSize>player.getX()){

            player.setX(e.getX()/cellSize);

            this.repaint();
        }

        else{
            this.repaint();
        }
        if(player.getX()==columns-1 && player.getY()==rows-1){

            player.setX(0);
            player.setY(0);
            createMaze.newMaze();
            maze=createMaze.getMaze();
            solvedMazeCounter.setCounter(solvedMazeCounter.getCounter()+1);
            solvedMazeCounter.repaint();
            this.repaint();

        }
        


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
