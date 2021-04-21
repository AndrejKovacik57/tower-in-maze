package sk.stuba.fei.uim.oop;

public class GameLogic {
    private int rowCol;
    private int width;
    private int cellSize;
    private CreateMaze maze;
    private Player player;
    private KeyboardMovement playerMovement;
    private PaintGamePanel paintMazePanel;
    private MyFrame frame;
    private ButtonAndCounterPanel buttonAndCounterPanel;
    private SolvedMazeCounter counter;
    public GameLogic() {
        rowCol = 11;
        width = 600;
        cellSize = width/rowCol;
        createGame();
        
    }
    public void createGame(){
        counter= new SolvedMazeCounter(190,45);
        maze = new CreateMaze(rowCol);
        player= new Player(cellSize-1,0,0);
        paintMazePanel= new PaintGamePanel(1,width,rowCol,rowCol,cellSize,maze.getMaze(),player);
        buttonAndCounterPanel=new ButtonAndCounterPanel(width,100,rowCol,cellSize, maze,player,paintMazePanel,counter,rowCol);
        playerMovement = new KeyboardMovement(cellSize,rowCol,player,maze,counter,paintMazePanel);
        frame=new MyFrame(617,740,maze,paintMazePanel,buttonAndCounterPanel,playerMovement);




    }
    
}
