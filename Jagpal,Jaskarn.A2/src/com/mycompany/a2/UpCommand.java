package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class UpCommand extends Command{
	private static GameWorld game;
	private static UpCommand upCommand;
	public UpCommand() {
		super("Up");
	}
	public static UpCommand getInstance(){
		if(upCommand == null)
			upCommand = new UpCommand();
		return upCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	@Override
	public void actionPerformed(ActionEvent ev)
	{
		System.out.println("Net moved up");
		game.moveUp();
	}

}
