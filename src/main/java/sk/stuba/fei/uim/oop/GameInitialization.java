package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.PannelsAndFrame.ButtonAndCounterPanel;
import sk.stuba.fei.uim.oop.PannelsAndFrame.MyFrame;
import sk.stuba.fei.uim.oop.PannelsAndFrame.PaintGamePanel;

public class GameInitialization {
    //rowCol a width sa da zmenit ak width je delitelne rowCol
    private final int rowCol= 12;
    private final int width= 600;
    private final int buttonPanelHeight=100;
    private final int cellSize= width/rowCol;
    private CreateMaze maze;
    private Player player;
    private KeyboardMovement playerMovement;

    private PaintGamePanel paintMazePanel;
    private MyFrame frame;
    private ButtonAndCounterPanel buttonAndCounterPanel;
    private SolvedMazeCounter solvedMazeCounter;

    public GameInitialization() {
        createGame();
        
    }
    public void createGame(){
        solvedMazeCounter= new SolvedMazeCounter(width/4,buttonPanelHeight/2);
        maze = new CreateMaze(rowCol);
        player= new Player(cellSize-3,0,0);
        paintMazePanel= new PaintGamePanel(width,rowCol,cellSize,maze,player,solvedMazeCounter);
        buttonAndCounterPanel=new ButtonAndCounterPanel(width,buttonPanelHeight,maze,player,paintMazePanel,solvedMazeCounter,rowCol);
        playerMovement = new KeyboardMovement(rowCol,player,maze,solvedMazeCounter,paintMazePanel);
        frame=new MyFrame(paintMazePanel,buttonAndCounterPanel,playerMovement);



    }
    
}
