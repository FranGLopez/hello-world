package com.rotsock.JavaTeory.DependencyInjection.noFramework;

@Component("myView")
public class SpringConsoleViewer implements View {

	Model messageProvider;

	@Override
	public void displayMessage() {
		System.out.println(messageProvider.getMessage());
	}
	
	@Resource(name="myModel")
	public void setModel(Model messageProvider){
		this.messageProvider = messageProvider;
	}
	
}
