package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class LeftCommand extends Command{
	private static GameWorld game;
	private static LeftCommand leftCommand;
	public LeftCommand() {
		super("Left");
	}
	public static LeftCommand getInstance(){
		if(leftCommand == null)
			leftCommand = new LeftCommand();
		return leftCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Net moved to the left");
		game.moveLeft();
	}

}
