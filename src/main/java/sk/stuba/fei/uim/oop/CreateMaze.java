package sk.stuba.fei.uim.oop;
import java.util.ArrayList;
import java.util.Random;

public class CreateMaze {
    private final int rows;
    private final int columns;
    private ArrayList<Cell>[][]maze;
    private Random rand=new Random();


    public CreateMaze(int rowColNum){
        this.rows=rowColNum;
        this.columns=rowColNum;
        newMaze();

    }



    public ArrayList<Cell>[][] getMaze() {
        return maze;
    }

    public void newMaze(){

        maze = new ArrayList[columns][rows];
        for (int x=0; x<columns;x++){

            for (int y=0; y<rows;y++){
                maze[x][y]=new ArrayList<Cell>();
                maze[x][y].add(new Cell(false,true,true,true,true,x,y));
            }
        }
        recursiveRandomDFS(maze[0][0].get(0));
    }
    public Cell checkIndex(int x, int y){
        if(x>=0 && y>=0 && x<columns  && y<rows ){
            return maze[x][y].get(0);
        }
        else {
            return null;
        }

    }
    public ArrayList<Cell> getNeighbours(int x, int y){
        var neighbours = new ArrayList<Cell>();

        var topNeigbour= checkIndex(x-1,y);
        var bottomNeigbour= checkIndex(x+1,y);
        var leftNeigbour= checkIndex(x, y-1);
        var rightNeigbour= checkIndex(x, y+1);

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
        var cellNeighbours= new ArrayList<Cell>();
        cellNeighbours=getNeighbours(current.getXIndex(),current.getYIndex());
        Cell nextCell = randomNeighbour(cellNeighbours);
        while (nextCell!=null){

            removeWalls(current.getXIndex(),current.getYIndex(),nextCell.getXIndex(),nextCell.getYIndex());
            recursiveRandomDFS(nextCell);
            cellNeighbours=getNeighbours(current.getXIndex(),current.getYIndex());
            nextCell = randomNeighbour(cellNeighbours);
        }

    }




}

