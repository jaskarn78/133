package com.mycompany.a3;


import com.codename1.ui.Display;
import com.codename1.ui.Form;
/**
 * 
 * @author jaskarnjagpal
 * Starter classes is the main class for the program
 * This is where the program begins its run
 * Starter method initiates a new game
 *
 */
public class Starter {

    private Form current;
	//private Resources theme;

    public void init(Object context) {
        //theme = UIManager.initFirstTheme("/theme");

        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        new Game();
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }
    
    public void destroy() {
    }

}
