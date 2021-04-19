package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;
import javax.swing.JPanel;


public class Maze extends JPanel {
    public final int gridSize=3;
    private int size;
    private int rows;
    private int columns;
    private int cellSize;
    private ArrayList<Cell>[][]maze;
    private Random rand=new Random();
    Deque<Cell> stack = new ArrayDeque<Cell>();

    public Maze(int size, int rowColNum){

        this.size=size;
        this.rows=rowColNum;
        this.columns=rowColNum;
        this.cellSize=size/rowColNum;
        createMaze();
        createMazePanel();

    }

    public void createMaze(){

        maze = new ArrayList[columns][rows];
        for (int x=0; x<columns;x++){

            for (int y=0; y<rows;y++){
                maze[x][y]=new ArrayList<Cell>();
                maze[x][y].add(new Cell(false,true,true,true,true,x,y,size/rows));


            }
        }
        recursiveRandomDFS(maze[0][0].get(0));

    }
    public Cell checkIndex(int x, int y){
        if(x>=0 && y>=0 && x<columns && y<rows ){
            return maze[x][y].get(0);
        }
        return null;
    }
    public ArrayList<Cell> getNeighbours(int x, int y){
        var neighbours = new ArrayList<Cell>();

        var topNeigbour= checkIndex(x,y-1);
        var bottomNeigbour= checkIndex(x,y+1);
        var leftNeigbour= checkIndex(x-1, y);
        var rightNeigbour= checkIndex(x+1, y);

        if(topNeigbour!=null && !topNeigbour.isVisited()){
            neighbours.add(topNeigbour);

        }
        if(bottomNeigbour!= null && !bottomNeigbour.isVisited()){
            neighbours.add(bottomNeigbour);
        }
        if(leftNeigbour!=null && !leftNeigbour.isVisited()){
            neighbours.add(leftNeigbour);
        }
        if(rightNeigbour!=null && !rightNeigbour.isVisited()){
            neighbours.add(rightNeigbour);
        }

        return neighbours;
    }

    public void removeWalls(int currentX,int currentY,int nextX,int nextY){
        if(currentX-nextX==0 && currentY-nextY==1){
            maze[currentX][currentY].get(0).setTopWall(false);
            maze[nextX][nextY].get(0).setBottomWall(false);
        }
        if(currentX-nextX==0 && currentY-nextY==-1){
            maze[currentX][currentY].get(0).setBottomWall(false);
            maze[nextX][nextY].get(0).setTopWall(false);
        }
        if(currentX-nextX==1 && currentY-nextY==0){
            maze[currentX][currentY].get(0).setLeftWall(false);
            maze[nextX][nextY].get(0).setRightWall(false);
        }
        if(currentX-nextX==-1 && currentY-nextY==0){
            maze[currentX][currentY].get(0).setRightWall(false);
            maze[nextX][nextY].get(0).setLeftWall(false);
        }

    }
    public Cell randomNeighbour(ArrayList<Cell> neighbours){
        if(neighbours.size()>=1){
            return neighbours.get(rand.nextInt(neighbours.size()));
        }
        else{
            return null;
        }
    }

    public void recursiveRandomDFS(Cell current){
        current.setVisited(true);
        ArrayList<Cell> cellNeighbours= new ArrayList<Cell>();
        cellNeighbours=getNeighbours(current.getXIndex(),current.getYIndex());
        Cell nextCell = randomNeighbour(cellNeighbours);
        while (nextCell!=null){
            //stack.push(current);
            removeWalls(current.getXIndex(),current.getYIndex(),nextCell.getXIndex(),nextCell.getYIndex());
            recursiveRandomDFS(nextCell);
            cellNeighbours=getNeighbours(current.getXIndex(),current.getYIndex());
            nextCell = randomNeighbour(cellNeighbours);
        }

        System.out.println("koniec dfs");
    }



    public void createMazePanel(){
        this.setBackground(Color.RED);
        this.setSize(size+(columns+1)*gridSize,size+(rows+1)*gridSize);
        this.setLocation(100,100 );
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(gridSize));
        for (int x=0; x<columns;x++){

            for (int y=0; y<rows;y++){
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

    }
}
