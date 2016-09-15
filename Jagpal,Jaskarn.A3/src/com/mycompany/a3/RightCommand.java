package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RightCommand extends Command{
	private static GameWorld game;
	private static RightCommand rightCommand;
	public RightCommand() {
		super("Right");
	}
	public static RightCommand getInstance(){
		if(rightCommand == null)
			rightCommand = new RightCommand();
		return rightCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Net moved right");
		game.moveRight();
	}

}
