package com.mycompany.a3;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import java.lang.Runnable;

public class BGSound implements Runnable{
	private Media m;
	public BGSound(){
		System.out.println(getClass());

		try{
			InputStream is;
			is = Display.getInstance().getResourceAsStream(BGSound.class.getClass(), "/bg.mp3");
			if(is==null)
				System.out.println("null");
			m=MediaManager.createMedia(is, "audio/wav", this);
			//m.play();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error playing ");
		}
	}
	public void pause(){
		m.pause();
	}
	public void play(){
		m.play();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		m.play();
	    m.setTime(0);
		
	}
	

}
