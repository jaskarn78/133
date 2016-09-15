package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class KittenCommand extends Command{
	private static GameWorld game;
	private static KittenCommand kittenCommand;
	public KittenCommand() {
		super("  Collision  ");
	}
	public static KittenCommand getInstance(){
		if(kittenCommand == null)
			kittenCommand = new KittenCommand();
		return kittenCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Cat has been added");
		game.pretend();
	}

}
