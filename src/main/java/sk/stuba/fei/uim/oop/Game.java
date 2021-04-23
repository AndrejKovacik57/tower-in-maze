package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.PannelsAndFrame.ButtonAndCounterPanel;
import sk.stuba.fei.uim.oop.PannelsAndFrame.MyFrame;
import sk.stuba.fei.uim.oop.PannelsAndFrame.PaintGamePanel;

public class Game {
    private int rowCol= 12;
    private int width= 600;
    private int buttonPanelHeight=105;
    private int cellSize= width/rowCol;
    private CreateMaze maze;
    private Player player;
    private KeyboardMovement playerMovement;

    private PaintGamePanel paintMazePanel;
    private MyFrame frame;
    private ButtonAndCounterPanel buttonAndCounterPanel;
    private SolvedMazeCounter solvedMazeCounter;

    public Game() {
        createGame();
        
    }
    public void createGame(){
        solvedMazeCounter= new SolvedMazeCounter(width/4-10,buttonPanelHeight/2-10);
        maze = new CreateMaze(rowCol);
        player= new Player(cellSize,0,0);
        paintMazePanel= new PaintGamePanel(1,width,rowCol,cellSize,maze,player,solvedMazeCounter);
        buttonAndCounterPanel=new ButtonAndCounterPanel(width,buttonPanelHeight,maze,player,paintMazePanel,solvedMazeCounter,rowCol);
        playerMovement = new KeyboardMovement(rowCol,player,maze,solvedMazeCounter,paintMazePanel);
        frame=new MyFrame(paintMazePanel,buttonAndCounterPanel,playerMovement);



    }
    
}
