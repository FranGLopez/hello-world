package com.rotsock.JavaTeory.DependencyInjection.noFramework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class SpringConsoleViewer2 implements View {


	final private Model modelProvider;

	SpringConsoleViewer2(Model modelProvider){
		this.modelProvider = modelProvider;
	}
	
	@Override
	public void displayMessage() {
		System.out.println(modelProvider.getMessage()+"2 Spring View");
	}
}