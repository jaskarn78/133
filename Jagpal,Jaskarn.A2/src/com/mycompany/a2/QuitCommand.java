package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class QuitCommand extends Command{
	
	private static QuitCommand quitCommand;
	private QuitCommand(){
		super("Quit");
	}
	public static QuitCommand getInstance(){
		if(quitCommand == null)
			quitCommand = new QuitCommand();
		return quitCommand;
	}
	public void actionPerformed(ActionEvent ev){
		System.out.println("You have quit the game");
		System.exit(0);
		
	}
	
}
