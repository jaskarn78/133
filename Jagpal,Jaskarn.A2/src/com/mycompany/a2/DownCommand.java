package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class DownCommand extends Command{
	private static GameWorld game;
	private static DownCommand downCommand;
	public DownCommand() {
		super("Down");
	}
	public static DownCommand getInstance(){
		if(downCommand == null)
			downCommand = new DownCommand();
		return downCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	@Override
	public void actionPerformed(ActionEvent ev)
	{
		System.out.println("move net down");
		game.moveDown();
	}

}
