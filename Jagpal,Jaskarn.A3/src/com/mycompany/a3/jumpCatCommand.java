package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class jumpCatCommand extends Command{
	private static GameWorld game;
	private static jumpCatCommand catCommand;
	
	public jumpCatCommand() {
		super("JumpToCat");
	}
	public static jumpCatCommand getInstance(){
		if(catCommand == null)
			catCommand = new jumpCatCommand();
		return catCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	@Override
	public void actionPerformed(ActionEvent ev)
	{
		System.out.println("Jump to cat");
		game.randomCat();
	}


}
