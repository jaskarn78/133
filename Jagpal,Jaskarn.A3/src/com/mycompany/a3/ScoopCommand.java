package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ScoopCommand extends Command{
	private static GameWorld game;
	private static ScoopCommand scoopCommand;
	//private Sounds scoopSound;
	public ScoopCommand() {
		super("Scoop");
		//scoopSound = new Sounds("dog_whine.wav");
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
		//scoopSound.playNet();
	}

}
