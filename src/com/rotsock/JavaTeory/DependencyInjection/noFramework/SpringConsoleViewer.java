package com.rotsock.JavaTeory.DependencyInjection.noFramework;


public class SpringConsoleViewer implements View {

	final private Model modelProvider;

	
	
	SpringConsoleViewer(Model modelProvider){
		this.modelProvider = modelProvider;
	}
	
	@Override
	public void displayMessage() {
		System.out.println(modelProvider.getMessage()+"1 Spring View");
	}
}
