package sk.stuba.fei.uim.oop;

public class GameLogic {
    public int rowCol;
    public int width;
    public int cellSize;
    public CreateMaze maze;
    public Player player;
    public KeyboardMovement playerMovement;
    public PaintGamePanel paintMazePanel;
    public MyFrame frame;
    public ButtonAndCounterPanel buttonAndCounterPanel;

    public GameLogic(int rowCol, int width) {
        this.rowCol = rowCol;
        this.width = width;
        this.cellSize = width/rowCol;
        createGame();
        
    }
    public void createGame(){

        maze = new CreateMaze(rowCol);
        player= new Player(cellSize-1,0,0);
        paintMazePanel= new PaintGamePanel(1,width,rowCol,rowCol,cellSize,maze.getMaze(),player);
        buttonAndCounterPanel=new ButtonAndCounterPanel(width,100,rowCol,cellSize, maze,player,paintMazePanel);
        playerMovement = new KeyboardMovement(cellSize,rowCol,player,maze,paintMazePanel);
        frame=new MyFrame(617,740,maze,paintMazePanel,buttonAndCounterPanel,playerMovement);




    }
    
}
