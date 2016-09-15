package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class jumpDogCommand extends Command{
	private static GameWorld game;
	private static jumpDogCommand dogCommand;
	
	public jumpDogCommand() {
		super("JumpToDog");
	}
	public static jumpDogCommand getInstance(){
		if(dogCommand == null)
			dogCommand = new jumpDogCommand();
		return dogCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	@Override
	public void actionPerformed(ActionEvent ev)
	{
		System.out.println("Jump to dog");
		game.randomDog();
	}


}
