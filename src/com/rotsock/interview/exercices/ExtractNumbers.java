package com.rotsock.interview.exercices;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 *  Prueba realizada para Fon
 *  
 *  text is a huge String, with numbers in the middle. You have to take all those numbers and  order them ascendantly without repetitions
 *  
 *  Example: getNumbers("A56B455VB23GTY23J") ==[23, 45, 56]
 * @author FRANCISCO
 *
 */
public class ExtractNumbers {
    
  public static List<Integer> getNumbers(String text) {

      Set<Integer> outputset = new TreeSet<Integer>();
      StringBuilder sb;
      char charCandidate;
      
 
      sb = null;
      //iterate the string
      for (int i=0; i< text.length(); i++){
          charCandidate = text.charAt(i);
          if (isNumeric(charCandidate)){
              if (sb == null){
                   sb = new StringBuilder();
              }
              sb.append(charCandidate);
          }
          else if (sb!=null){
        	  outputset.add(Integer.valueOf(sb.toString()));
              sb = null;
          }
      }
      return new ArrayList<Integer>(outputset);
  }
  
  /**
   * Check if candidate is a numeric
   **/
  private static boolean isNumeric (char candidate){
      try{
          Integer.parseInt(String.valueOf(candidate));
      }
      catch (Exception ex){
          return false;
      }
      return true;
      
  }
  
  
}