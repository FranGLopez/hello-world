package com.rotsock.interview.exercices;
/**
 * Guidewire exercice, Phone Billing
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.HashMap;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class BillingPhone {
    public int solution(String S) {
    	
        String[] conceptsBill,phoneBill;
        HashMap<Integer,Call> mapCalls;
        int phoneT1,phoneToPromote;
        Call callT1;
        phoneBill = S.split("\\r\\n");
        mapCalls = new HashMap<Integer,Call>();
        for (String lineBill : phoneBill){
            conceptsBill = lineBill.split(",");
            //discard if there is something unexpected
            if (conceptsBill.length==2){
            	phoneT1 = calculatePhoneNumber(conceptsBill[1]);
                callT1 = mapCalls.get(phoneT1);
                if (callT1 == null){
                    callT1 = new Call();
                }
                callT1.addCall(conceptsBill[0]);
                mapCalls.put(phoneT1, callT1);
            }
        }
        phoneToPromote = promotingPhone(mapCalls);
        return invoicingCalls(mapCalls,phoneToPromote);
    }
    
    private int calculatePhoneNumber (String phone){
    	String phone1 = phone.replaceAll("-","");
    	return Integer.valueOf(phone1);
    }
    
    
    /**
     * return: phone with free promotion
     **/
    private int promotingPhone (HashMap <Integer,Call> mapCalls){
    	
    	int maxSeconds,secondsCandidate;
    	int bestPhone;
    	Call callT;
    	maxSeconds = 0;
    	bestPhone= 0;
    	for (Integer phoneCandidate : mapCalls.keySet()) {
    		callT = mapCalls.get(phoneCandidate);
    		secondsCandidate = callT.getTotalSeconds();
    		if (maxSeconds < secondsCandidate) {
    			maxSeconds = secondsCandidate;
    			bestPhone = phoneCandidate;
    		}
    		else if (maxSeconds == secondsCandidate && phoneCandidate < bestPhone) {
    			bestPhone = phoneCandidate;
    		}
    	}
        return bestPhone;
    }
    
    private int invoicingCalls (HashMap <Integer,Call> mapCalls, int phonePromoted){
    	Call callT;
    	int ammount;
    	ammount = 0;
    	for (Integer phone : mapCalls.keySet()) {
    		if (phonePromoted !=phone) {
    			callT = mapCalls.get(phone);
    			ammount = callT.getTotalAmmount();
    		}
    	}
    	return ammount;
    }
    
     class Call {
        // I use total values because I only need this level of the information to calculate the solution
        private int totalAmmount;
        private int totalSeconds;
        private static final int COST_PER_SECOND_LOWERTHAN_5MIN = 3;
        private static final int COST_PER_MINUTE_EQ_UPPERTHAN_5MIN = 150;
        
        Call (){
            totalAmmount = 0;
            totalSeconds = 0;
        }
         protected void addCall(String time){
         //@TODO
         int call = calculateSeconds(time);
         totalSeconds += call;
         totalAmmount += calculateCost(call);
         }
         
         protected int getTotalAmmount(){
            return totalAmmount;
         }
         
         protected int getTotalSeconds(){
            return totalSeconds;
         }
         
         private int calculateSeconds (String time){
        	 String []timeArr = time.split(":");
        	 int seconds;
        	 seconds= 0;
        	 seconds+= Integer.parseInt(timeArr[0])*3600;
        	 seconds+= Integer.parseInt(timeArr[1])*60;
        	 seconds+= Integer.parseInt(timeArr[2]);
             
             return seconds;
         }
         
         private int calculateCost (int seconds){
             if  (seconds < 5*60) {
            	 return seconds* COST_PER_SECOND_LOWERTHAN_5MIN;
             }
             else {
            	 return ((int)Math.ceil(seconds/60.0f))*COST_PER_MINUTE_EQ_UPPERTHAN_5MIN;
             }
         }     
    }
    
}