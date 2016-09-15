package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
/**
 * 
 * @author Jaskarn Jagpal
 * Date: 02/20/2016
 * Class: CSC 133 T,TH 1030-1145
 * Dog catcher game
 *
 */
public class Game extends Form {
	private GameWorld gw;
	MapView mv;
	ScoreView sv;
	Button contractButton, expandButton, upButton, leftButton;
	Button downButton, rightButton, scoopButton, fightButton, tickButton;
	Button dogButton, catButton, kittenButton;
	Toolbar toolbar;
	/**
	 * Game constructor
	 * Parameters: None
	 * Constructor initializes a new GameWorld layout
	 * then calls the play method["+ColorUtil.red(getColor()) +
								", "+ColorUtil.green(getColor()))+
								", "+ColorUtil.blue(getColor())+"] "+
	 */
	@SuppressWarnings("deprecation")
	public Game()
	{
		gw = new GameWorld();
		gw.initLayout();
			
		mv = new MapView();
		sv = new ScoreView();
		gw.addObserver(mv);
		gw.addObserver(sv);

		
		//create command objects for each command
		//add commands to side menu and title bar area, bind commands to keys,
		// create control containers for the buttons, add buttons to the control
		//containers, add commands to the buttons, and add control containers,
		//mapview, and scoreview to the form.
		
		this.setTitle("Dog Catcher");
		this.setToolBar(new Toolbar());
		this.setLayout(new BorderLayout());
		Border border = Border.createLineBorder(1,ColorUtil.BLUE);
		Container leftContainer = new Container(new GridLayout(4,1));
		Container rightContainer = new Container(new GridLayout(5,1));
		Container bottomContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
		
		//topContainer.add(new Label("Total Points: "+gw.getTotalPoints()));
		//topContainer.add(new Label("Dogs Captured: "+gw.getDogsCaught()));
		//topContainer.add(new Label("Cats Captured: "+gw.getCatsCaught()));
		//topContainer.add(new Label("Dogs Remaining: "+gw.getDogsRemaining()));
		//topContainer.add(new Label("Cats Remaining: "+gw.getCatsRemaining()));
		//topContainer.add(new Label("Sound: "+gw.isSoundOn()));
		//topContainer.getAllStyles().setPadding(20, 20, 0, 0);
		//topContainer.add(sv);
		
		
		
		
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
		tickButton.setCommand(TickCommand.getInstance());
		
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
		
		
		leftContainer.getAllStyles().setPadding(100, 200, 10, 10);
		leftContainer.add(expandButton);
		leftContainer.add(upButton);
		leftContainer.add(leftButton);
		leftContainer.add(dogButton);
		leftContainer.getAllStyles().setBorder(border);
		add(BorderLayout.WEST, leftContainer);
		
		Container centerContainer = new Container();
		centerContainer.getAllStyles().setBgTransparency(255);
		centerContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		centerContainer.getAllStyles().setBorder(border);

		add(BorderLayout.CENTER, centerContainer);
		
		rightContainer.getAllStyles().setPadding(100, 200,10,10);
		rightContainer.add(contractButton);
		rightContainer.add(downButton);
		rightContainer.add(rightButton);
		rightContainer.add(catButton);
		rightContainer.add(scoopButton);
		rightContainer.getAllStyles().setBorder(border);

		add(BorderLayout.EAST, rightContainer);
		
		bottomContainer.add(kittenButton);
		bottomContainer.add(fightButton);
		bottomContainer.add(tickButton);
		bottomContainer.getAllStyles().setMargin(50, 20,400,50);

		add(BorderLayout.SOUTH, bottomContainer);
		add(BorderLayout.NORTH, sv);
		
		this.getToolbar().addCommandToSideMenu(ScoopCommand.getInstance());
		this.getToolbar().addCommandToSideMenu(AboutCommand.getInstance());
		this.getToolbar().addCommandToSideMenu(SoundCommand.getInstance());
		this.getToolbar().addCommandToSideMenu(HelpCommand.getInstance());
		this.getToolbar().addCommandToSideMenu(QuitCommand.getInstance());

		
		addKeyListener('s', ScoopCommand.getInstance());
		addKeyListener('l', LeftCommand.getInstance());
		addKeyListener('u', UpCommand.getInstance());
		addKeyListener('r', RightCommand.getInstance());
		addKeyListener('d', DownCommand.getInstance());
		addKeyListener('t', TickCommand.getInstance());
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
		TickCommand.setTarget(gw);
		jumpCatCommand.setTarget(gw);
		jumpDogCommand.setTarget(gw);
		
		this.show();
	}
}

		
		