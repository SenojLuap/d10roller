package pj.d10roller.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import pj.d10roller.view.GUI;

/**
 * The controller for the d10roller app
 * @author Paul Jones
 */
public class Controller {
  
  public static String calcKeepRoll(int rolls, int keeps) {
    String resultStr = "";
    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss a]");
    resultStr += format.format(now);
    resultStr += " " + rolls + "k" + keeps + ":\t";
    int results = 0, explodes = 0;
    ArrayList<Integer> rollList = new ArrayList<Integer>();
    for(int i = 0; i < rolls; i++) {
      int roll = (int)(Math.random() * 10) + 1;
      int rollTotal = roll;
      while(roll == 10) {
        explodes++;
        roll = (int)(Math.random() * 10) + 1;
        rollTotal += roll;
      }
      rollList.add((Integer)rollTotal);
    }
    Collections.sort(rollList);
    Collections.reverse(rollList);
    for(int i = 0; i < (rolls > keeps ? keeps : rolls); i++)
      results += rollList.get(i);
    resultStr += results;
    if(explodes > 0)
      resultStr += "\tExplodes: " + explodes;
    return resultStr;
  }
  
  public static void main(String[] args) {
    GUI gui = new GUI();
    gui.setVisible(true);
  }
  
}
