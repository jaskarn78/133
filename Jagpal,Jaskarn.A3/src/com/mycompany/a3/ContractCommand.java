package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ContractCommand extends Command{
	private static GameWorld gw;
	private static ContractCommand contractCommand;
	public ContractCommand() {
		super("Contract");
	}
	public static ContractCommand getInstance(){
		if(contractCommand == null)
			contractCommand = new ContractCommand();
		return contractCommand;
	}
	public static void setTarget(GameWorld gwl){
		if(gw==null)
			gw=gwl;
	}

	@Override
	public void actionPerformed(ActionEvent ev)
	{
		System.out.println("Net contracted");
		gw.decrease();
	}

}
