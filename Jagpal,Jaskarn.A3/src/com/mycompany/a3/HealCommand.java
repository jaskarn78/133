package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class HealCommand extends Command{
	private static HealCommand heal;
	private static GameWorld game;
	
	private HealCommand()
	{
		super("Heal");
	}
	public static HealCommand getInstance(){
		if(heal == null)
			heal = new HealCommand();
		return heal;
	}
	public static void setTarget(GameWorld gw)
	{
		if(game==null)
			game=gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt){
		game.healDogs();
	}
	

}
