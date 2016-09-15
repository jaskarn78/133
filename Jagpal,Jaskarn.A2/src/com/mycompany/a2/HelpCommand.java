package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command {
	private static GameWorld game;
	private static HelpCommand helpCommand;
	public HelpCommand() {
		super("Help");
	}
	public static HelpCommand getInstance(){
		if(helpCommand == null)
			helpCommand = new HelpCommand();
		return helpCommand;
	}
	public static void setTarget(GameWorld gw){
		if(game==null)
			game=gw;
	}

	@Override
	public void actionPerformed(ActionEvent ev)
	{
		System.out.println("Help Command");
	}

}
