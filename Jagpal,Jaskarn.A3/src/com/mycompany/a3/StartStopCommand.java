package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.UITimer;

public class StartStopCommand extends Command  {
	double timeRate;
	UITimer timer;
	Form form;
	boolean stopped;
	GameWorld gw;
	private boolean bPause = false;
	private BGSound bgSound;
	
	
	
	public StartStopCommand(UITimer timer, Form form, double timeRate)
	{
		super("Play/Pause");
		stopped=true;
		
		this.timer=timer;
		this.form=form;
		this.timeRate=timeRate;
		bgSound=new BGSound();
		bgSound.play();

	}
	@Override
	public void actionPerformed(ActionEvent evt){
		if(stopped ){
			stopped=false;
			timer.schedule((int)timeRate, true, form);
			bgSound.play();
		}else{
			stopped=true;
			timer.cancel();
			bgSound.pause();
		}
	}


}
