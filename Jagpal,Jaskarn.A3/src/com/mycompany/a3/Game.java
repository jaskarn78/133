package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import java.lang.Runnable;
/**
 * 
 * @author Jaskarn Jagpal
 * Date: 02/20/2016
 * Class: CSC 133 T,TH 1030-1145
 * Dog catcher game
 *
 */
public class Game extends Form implements Runnable {
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	Button contractButton, expandButton, upButton, leftButton;
	Button downButton, rightButton, scoopButton, fightButton, tickButton;
	Button dogButton, catButton, kittenButton, startStopButton, healButton;
	Toolbar toolbar;
	Button b = new Button("Hello");
	
	private static double rate;
	//private double elapsedTime;
	private Toolbar toolBar;
	private Label checkStatus;
	private static boolean isGamePaused;
	//private boolean bPause;
	private static UITimer timer;

	/**
	 * Game constructor
	 * Parameters: None
	 * Constructor initializes a new GameWorld layout
	 * then calls the play method["+ColorUtil.red(getColor()) +
								", "+ColorUtil.green(getColor()))+
								", "+ColorUtil.blue(getColor())+"] "+
	 */
	public Game()
	{

		rate=20;
		this.setLayout(new BorderLayout());
		this.setTitle("Dog Catcher");
		gw = new GameWorld();
		gw.initLayout();

		mv = new MapView(gw);
		timer = new UITimer(this);
		timer.schedule((int)rate, true, this);
		sv = new ScoreView();
		this.add(BorderLayout.CENTER, mv);

		gw.addObserver(mv);
		gw.addObserver(sv);
		gw.notifyObservers();
		
		
		//bPause=false;
		checkStatus = new Label("OFF");
		CheckBox snd = new CheckBox("Sound");
		SoundCommand sndcmd = new SoundCommand(gw, this);
		snd.setCommand(sndcmd);
		snd.putClientProperty("SideCmpt", snd);
		
		//create command objects for each command
		//add commands to side menu and title bar area, bind commands to keys,
		// create control containers for the buttons, add buttons to the control
		//containers, add commands to the buttons, and add control containers,
		//mapview, and scoreview to the form.
		
		
		
		toolBar = new Toolbar();
		setToolbar(toolBar);
		toolBar.addCommandToSideMenu(sndcmd);
		Border border = Border.createLineBorder(1,ColorUtil.BLUE);
		Container leftContainer = new Container(new GridLayout(4,1));
		Container rightContainer = new Container(new GridLayout(5,1));
		Container bottomContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
		
		
	
		
		contractButton = new Button("Contract");		
		downButton = new Button("Down");
		expandButton = new Button("Expand");
		fightButton = new Button("   Fight  ");
		kittenButton = new Button("Collision");
		leftButton = new Button("Left");
		rightButton = new Button("Right");
		scoopButton = new Button("Scoop");
		tickButton = new Button("   Tick  ");
		upButton = new Button("Up");
		dogButton = new Button("JumpToDog");
		catButton = new Button("JumpToCat");
		startStopButton = new Button("Pause/Play");
		healButton = new Button("Heal");
		
		
		
		
		healButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		healButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		healButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		healButton.setCommand(HealCommand.getInstance());
		
		contractButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		contractButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		contractButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		contractButton.setCommand(ContractCommand.getInstance());
		
		expandButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		expandButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		expandButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		expandButton.setCommand(ExpandCommand.getInstance());
		
		fightButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		fightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		fightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		fightButton.setCommand(FightCommand.getInstance());
		

		kittenButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		kittenButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		kittenButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		kittenButton.setCommand(KittenCommand.getInstance());
		
		rightButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		rightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		rightButton.setCommand(RightCommand.getInstance());
		
		scoopButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		scoopButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		scoopButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		scoopButton.setCommand(ScoopCommand.getInstance());
		
		tickButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		tickButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		tickButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		//tickButton.setCommand(TickCommand.getInstance());
		
		catButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		catButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		catButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		catButton.setCommand(jumpCatCommand.getInstance());
		
		downButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		downButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		downButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		downButton.setCommand(DownCommand.getInstance());
		
		upButton.getAllStyles().setPadding(Component.BOTTOM,10);
		upButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		upButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		upButton.setCommand(UpCommand.getInstance());
		
		leftButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		leftButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		leftButton.setCommand(LeftCommand.getInstance());
		
		dogButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		dogButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		dogButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		dogButton.setCommand(jumpDogCommand.getInstance());
		
		startStopButton.getAllStyles().setPadding(Component.BOTTOM, 10);
		startStopButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		startStopButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		StartStopCommand playPause = new StartStopCommand(timer, this, (int)rate);
		startStopButton.setCommand(playPause);
		addKeyListener('p', playPause);

		
		
		leftContainer.getAllStyles().setPadding(100, 200, 10, 10);
		leftContainer.add(expandButton);
		leftContainer.add(upButton);
		leftContainer.add(leftButton);
		leftContainer.add(dogButton);
		leftContainer.getAllStyles().setBorder(border);
		add(BorderLayout.WEST, leftContainer);
		
		final Container centerContainer = new Container();
		centerContainer.getAllStyles().setBgTransparency(100);
		centerContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		centerContainer.getAllStyles().setBorder(border);
		//centerContainer.add(mv);

		
		rightContainer.getAllStyles().setPadding(100, 200,10,10);
		rightContainer.add(contractButton);
		rightContainer.add(downButton);
		rightContainer.add(rightButton);
		rightContainer.add(catButton);
		rightContainer.add(scoopButton);
		rightContainer.add(healButton);
		
		rightContainer.getAllStyles().setBorder(border);

		add(BorderLayout.EAST, rightContainer);
		
		bottomContainer.add(kittenButton);
		bottomContainer.add(fightButton);
		bottomContainer.add(tickButton);
		bottomContainer.add(startStopButton);
		bottomContainer.getAllStyles().setMargin(50, 20,400,50);

		add(BorderLayout.SOUTH, bottomContainer);
		add(BorderLayout.NORTH, sv);
	
		
		
		toolBar.addCommandToSideMenu(ScoopCommand.getInstance());
		toolBar.addCommandToSideMenu(AboutCommand.getInstance());
		toolBar.addCommandToSideMenu(HelpCommand.getInstance());
		toolBar.addCommandToSideMenu(QuitCommand.getInstance());
		ExitCommand exitCmd = new ExitCommand(this);
		toolBar.addCommandToSideMenu(exitCmd);

		

		
		addKeyListener('s', ScoopCommand.getInstance());
		addKeyListener('l', LeftCommand.getInstance());
		addKeyListener('u', UpCommand.getInstance());
		addKeyListener('r', RightCommand.getInstance());
		addKeyListener('d', DownCommand.getInstance());
		//addKeyListener('t', TickCommand.getInstance());
		addKeyListener('c', ContractCommand.getInstance());
		addKeyListener('f', FightCommand.getInstance());
		addKeyListener('e', ExpandCommand.getInstance());
		addKeyListener('o', jumpDogCommand.getInstance());
		addKeyListener('a', jumpCatCommand.getInstance());
		//exit 

		
		ExpandCommand.setTarget(gw);
		ContractCommand.setTarget(gw);
		ScoopCommand.setTarget(gw);
		RightCommand.setTarget(gw);
		LeftCommand.setTarget(gw);
		UpCommand.setTarget(gw);
		DownCommand.setTarget(gw);
		KittenCommand.setTarget(gw);
		FightCommand.setTarget(gw);
//		TickCommand.setTarget(gw);
		jumpCatCommand.setTarget(gw);
		jumpDogCommand.setTarget(gw);
		HealCommand.setTarget(gw);
		
		this.show();
	}
	
	public boolean isPaused(){
		return isGamePaused;
	}
	public void pauseGame(){
		isGamePaused = true;
		expandButton.getDisabledStyle();
		contractButton.getDisabledStyle();
		scoopButton.getDisabledStyle();
		rightButton.getDisabledStyle();
		leftButton.getDisabledStyle();
		upButton.getDisabledStyle();
		downButton.getDisabledStyle();
		kittenButton.getDisabledStyle();
		fightButton.getDisabledStyle();
		catButton.getDisabledStyle();
		dogButton.getDisabledStyle();
		repaint();
	}

		

	public void setCheckStatus(boolean b)
	{
		if(b)
			checkStatus.setText("ON");
		else
			checkStatus.setText("OFF");
	}

	

	public void run() {
		// TODO Auto-generated method stub
		gw.tick(rate);
		
	}

}

		
		