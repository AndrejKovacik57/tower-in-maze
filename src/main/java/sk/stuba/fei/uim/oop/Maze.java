package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Maze extends JPanel {
    public final int gridSize=3;
    private int size;
    private int rows;
    private int columns;
    private int cellSize;
    private ArrayList<Cell>[][] maze = new ArrayList[10][10];

    public Maze(int size, int rowColNum){
        System.out.println("konstruktor maze");
        this.size=size;
        this.rows=rowColNum;
        this.columns=rowColNum;
        this.cellSize=size/rowColNum;

        createMaze();
        createPanel();

    }

    public void createMaze(){
        System.out.println("create maze size "+size+" col "+columns+", row "+rows);
        maze = new ArrayList[columns][rows];
        for (int x=0; x<columns;x++){
            System.out.println("add cell for 1");
            for (int y=0; y<rows;y++){
                //maze.add(new Cell(false,true,true,true,true,x,y,size/rows));
                maze[x][y]=new ArrayList<Cell>();
                maze[x][y].add(new Cell(false,true,true,true,true,x,y,size/rows));
                System.out.println("add cell for 2");

            }
        }
    }
    /*public Cell findCell(int x,int y){

        for(Cell cell: maze){
            if(cell.getXIndex()==x && cell.getYIndex()==y){
                return cell;
            }
        }
        return null;
    }*/
    public void recursiveRandomDFS(int x,int y){
        //findCell(x,y).setVisited(true);


    }

    public void createPanel(){
        this.setPreferredSize(new Dimension(size+(columns+1)*gridSize,size+(rows+1)*gridSize));
        this.setBackground(Color.GREEN);
        this.setVisible(true);
        this.setLocation(100,100 );
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(gridSize));
        System.out.println("maze paint");

        for (int x=0; x<columns;x++){
            System.out.println("add cell for 1");
            for (int y=0; y<rows;y++){
                if(maze[x][y].get(0).isTopWall()){
                    g2D.drawLine(maze[x][y].get(0).getXIndex()*cellSize, maze[x][y].get(0).getYIndex()*cellSize+1, maze[x][y].get(0).getXIndex()*cellSize+cellSize, maze[x][y].get(0).getYIndex()*cellSize+1);
                }
                if(maze[x][y].get(0).isBottomWall()){
                    g2D.drawLine(maze[x][y].get(0).getXIndex()*cellSize, maze[x][y].get(0).getYIndex()*cellSize+cellSize+1, maze[x][y].get(0).getXIndex()*cellSize+cellSize, maze[x][y].get(0).getYIndex()*cellSize+cellSize+1);
                }
                if(maze[x][y].get(0).isLeftWall()){
                    g2D.drawLine(maze[x][y].get(0).getXIndex()*cellSize, maze[x][y].get(0).getYIndex()*cellSize, maze[x][y].get(0).getXIndex()*cellSize, maze[x][y].get(0).getYIndex()*cellSize+cellSize);
                }
                if(maze[x][y].get(0).isRightWall()){
                    g2D.drawLine(maze[x][y].get(0).getXIndex()*cellSize+cellSize, maze[x][y].get(0).getYIndex()*cellSize, maze[x][y].get(0).getXIndex()*cellSize+cellSize, maze[x][y].get(0).getYIndex()*cellSize+cellSize);

                }
            }
        }




    }
}
