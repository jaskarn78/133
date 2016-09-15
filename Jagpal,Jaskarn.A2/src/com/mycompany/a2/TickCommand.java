package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TickCommand extends Command{
	private static GameWorld game;
	private static TickCommand tickCommand;
	public TickCommand() {
		super("     Tick     ");
	}
	public static TickCommand getInstance(){
		if(tickCommand == null)
			tickCommand = new TickCommand();
		return tickCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	@Override
	public void actionPerformed(ActionEvent ev)
	{
		System.out.println("Tick performed");
		game.tick();
	}

}
