package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command {
	private static SoundCommand soundCommand;
	private static GameWorld game;
	
	private SoundCommand(){
		super("Sound On/Off");
	}
	public static SoundCommand getInstance(){
		if(soundCommand ==null)
			soundCommand = new SoundCommand();
		return soundCommand;
	}
	public static void setTarget(GameWorld gw)
	{
		if(game==null)
			game=gw;
	}
	public void actionPerformed(ActionEvent ev){
		//System.out.println("SOUND On/Off");
		game.toggleSound();
	}

}
