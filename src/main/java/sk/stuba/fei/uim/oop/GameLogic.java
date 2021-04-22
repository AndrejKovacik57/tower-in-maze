package sk.stuba.fei.uim.oop;

public class GameLogic {
    private int rowCol= 12;
    private int width= 600;
    private int cellSize= width/rowCol;
    private CreateMaze maze;
    private Player player;
    private KeyboardMovement playerMovement;
    private MouseMovement playerMovementMouse;
    private PaintGamePanel paintMazePanel;
    private MyFrame frame;
    private ButtonAndCounterPanel buttonAndCounterPanel;
    private SolvedMazeCounter counter;

    public GameLogic() {

        createGame();
        
    }
    public void createGame(){
        counter= new SolvedMazeCounter(190,45);
        maze = new CreateMaze(rowCol);

        player= new Player(cellSize-1,0,0);
        playerMovementMouse=new MouseMovement(cellSize,rowCol,player,maze,counter);

        paintMazePanel= new PaintGamePanel(1,width,rowCol,rowCol,cellSize,maze.getMaze(),player,playerMovementMouse);
        buttonAndCounterPanel=new ButtonAndCounterPanel(width,105,rowCol,cellSize, maze,player,paintMazePanel,counter,rowCol);
        playerMovementMouse=new MouseMovement(cellSize,rowCol,player,maze,counter);
        playerMovement = new KeyboardMovement(cellSize,rowCol,player,maze,counter,paintMazePanel);
        frame=new MyFrame(617,745,maze,paintMazePanel,buttonAndCounterPanel,playerMovement);



    }
    
}
