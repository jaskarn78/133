package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command{
	private Game g;
	public ExitCommand(Game g){
		super("Exit");
		this.g=g;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt){
		Boolean b = Dialog.show("Confirm", "Sure?", "OK", "Cance");
		if(b){
			Display.getInstance().exitApplication();
		}
		g.show();
	}

}
