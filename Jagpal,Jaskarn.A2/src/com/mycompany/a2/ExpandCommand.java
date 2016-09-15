package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ExpandCommand extends Command{
	private static GameWorld game;
	private static ExpandCommand expandCommand;
	public ExpandCommand() {
		super("Expand");
	}
	public static ExpandCommand getInstance(){
		if(expandCommand == null)
			expandCommand = new ExpandCommand();
		return expandCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Net expanded");
		game.expand();
	}

}
