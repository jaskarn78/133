package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.SideMenuBar;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command {
	//private  SoundCommand soundCommand;
	private GameWorld game;
	private Game g;
	
	public SoundCommand(GameWorld gw, Game form){
		super("Sound On/Off");
		this.game=gw;
		this.g=form;
	}

	public void actionPerformed(ActionEvent ev){
		//System.out.println("SOUND On/Off");
		boolean status = game.getSound();
		if(status){
			game.setSound(false);
			g.setCheckStatus(false);
		}else{
			game.setSound(true);
			g.setCheckStatus(true);
		}
		SideMenuBar.closeCurrentMenu();
		game.notifyObservers();
	}

}
