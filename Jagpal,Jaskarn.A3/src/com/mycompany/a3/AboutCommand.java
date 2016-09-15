package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;

public class AboutCommand extends Command {
	//private static GameWorld gw;
	private static AboutCommand aboutCommand;
	public AboutCommand() {
		super("About");
	}
	public static AboutCommand getInstance(){
		if(aboutCommand == null)
			aboutCommand = new AboutCommand();
		return aboutCommand;
	}


	@Override
	public void actionPerformed(ActionEvent ev)
	{
		Dialog d = new Dialog("About");
		TextArea popupBody = new TextArea("Dog Catcher Assignment 2\n Author"
				+ ": Jaskarn Jagpal\n CLass: Csc 133");
		popupBody.setUIID("PopupBody");
		popupBody.setEditable(false);
		d.setLayout(new BorderLayout());
		d.add(BorderLayout.CENTER, popupBody);
		d.showDialog();
		
	}


}
