package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ScoopCommand extends Command{
	private static GameWorld game;
	private static ScoopCommand scoopCommand;
	public ScoopCommand() {
		super("Scoop");
	}
	public static ScoopCommand getInstance(){
		if(scoopCommand == null)
			scoopCommand = new ScoopCommand();
		return scoopCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Scoop performed");
		game.scoop();
	}

}
