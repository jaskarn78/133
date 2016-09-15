package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Label;



public class ScoreView extends Container implements Observer{
	
	  //Label totalPts, dogsCaught, catsCaught, InitDog, InitCat, sound;
	  private Label totalP;
	  private Label catsC;
	  private Label Dogsc;
	  private Label catsR;
	  private Label dogsR;
	  private Label sound;
	  ScoreView(){
		  totalP = new Label("Total Score: "+0);
		  add(totalP);
		  catsC = new Label("Cats Captured: "+0);
		  add(catsC);
		  Dogsc = new Label("Dogs Captured: "+0);
		  add(Dogsc);
		  catsR = new Label("Remaining Cats: ");
		  add(catsR);
		  dogsR = new Label("Remaining Dogs: ");
		  add(dogsR);
		  sound = new Label("Sound: OFF");
		  add(sound);
		  
	  }
	  int totalPts, dogsCaught, catsCaught, InitDog, InitCat;
	  boolean snd;

	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		GameWorld gw = (GameWorld)observable;

		
		totalPts = gw.getTotalScore();
		dogsCaught = gw.getDogsC();
		catsCaught = gw.getCatsC();
		InitDog = gw.getDogsR();
		InitCat = gw.getCatsR();
		snd = gw.getSound();
		
		totalP.setText("Total Score: "+totalPts);
		catsCaught = gw.getCatsC();
		catsC.setText("Cats Captured: "+catsCaught);
		Dogsc.setText("Dogs Captured: "+dogsCaught);
		dogsR.setText("Dogs Remaining: "+InitDog);
		catsR.setText("Cats Remaining: "+InitCat);
		if(snd){
			sound.setText("   Sound: ON");
		}else{
			sound.setText("   Sound: OFF");
		}

		
	}
	
}
