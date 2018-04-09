package com.rotsock.JavaTeory.designpatterns.callback;

public class callBackSimple {
	
	private CallBackMethod methodToCall;
	public void registerCallBack(CallBackMethod methodToCall){
		this.methodToCall = methodToCall;
	}
	
	public void doWork() {
		/**
		 * Realizar algura tarea, o doWork es un evento programado, etc.
		 */
		if (true){
			methodToCall.callback();
		}
	}

}

interface CallBackMethod{
    void callback();
}
