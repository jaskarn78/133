package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class FightCommand extends Command{
	private static GameWorld game;
	private static FightCommand fightCommand;
	public FightCommand() {
		super("     Fight     ");
	}
	public static FightCommand getInstance(){
		if(fightCommand == null)
			fightCommand = new FightCommand();
		return fightCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Fight Occured");
		game.fight();
		//fightSounds.play();
	}

}
