/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamePackage;

import static gamePackage.gameGrid.textFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author martian
 */
public class gameGridManager implements GridManager {
    
    int instructionNum;

    public gameGridManager() {
    }
    public void moveArrow(){
        
    }
    
    public void moveArrow(ArrayList<String> txtInstr){
        Map<String, Integer> arrList = new HashMap<>();
//        ArrayList<String> instructions = new ArrayList<>();
        
        for (int j = 0; j < txtInstr.size(); j++){
            String instr = txtInstr.get(j);
                
            arrList = findArrowPosition();
            String directionP = dealWithArrowAngle(getArrowAngle());
                  
            switch (instr.substring(0,1).toUpperCase()){
                case "L":
                   instructionNum = Integer.parseInt(instr.substring(1)); 
                   for (int p = 0; p < instructionNum; p++){  
                    moveLeft();
                   }
                   break;
                case "R":
                    instructionNum = Integer.parseInt(instr.substring(1)); 
                    for (int p = 0; p < instructionNum; p++){  
                        moveRight();
                    }
                case "F":
                    instructionNum = Integer.parseInt(instr.substring(1)); 
                    for (int p = 0; p < instructionNum; p++){
                       moveForward();
                    }
                    break;
            }
        }  
    }
    
    
    
      public void moveForward(){
        
        Map<String, Integer> arrowPosMapNew = findArrowPosition();
        String directionP = dealWithArrowAngle(getArrowAngle());
        
//        // do case statement
//        try{
//            Thread.sleep(2000);
//            //do case statement
//        }catch (InterruptedException e){
//            
//        }
        
        switch (directionP){ 
                case "forward":
                    textFields[arrowPosMapNew.get("row") - 1][arrowPosMapNew.get("col")].setText("\u2191");
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("");
//                    System.out.println("forward");
                    break;
                case "diagonalLeft":
                    textFields[arrowPosMapNew.get("row")- 1][arrowPosMapNew.get("col")- 1].setText("\u2196");
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("");
//                    System.out.println("diagonalLeft");
                    break;
                case "diagonalRight":
                    textFields[arrowPosMapNew.get("row")-1][arrowPosMapNew.get("col")+1].setText("\u2197");
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("");
//                    System.out.println("diagonalRight");
                    break;
                case "left":              
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col") ].setText("\u2196");
//                    System.out.println("left");
                    break;
                case "right":
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("\u2197");
//                    System.out.println("right");
                    break;
                                    
            }
        
    }
    
    public void moveLeft(){
       
        Map<String, Integer> arrowPosMapNew = findArrowPosition();
        String directionP = dealWithArrowAngle(getArrowAngle());
        
           switch (directionP){ 
                case "forward":
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("\u2196");
//                    System.out.println("forward");
                    break;
                case "diagonalLeft":
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("\u2190");
//                    System.out.println("diagonalLeft");
                    break;
                case "diagonalRight":
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("\u2191");
//                    System.out.println("diagonalRight");
                    break;
                case "left":              
                  
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col") - 1 ].setText("\u2190");
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("");
//                    System.out.println("left");
//                    findArrowPosition();
                    break;
                
                case "right":
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("\u2197");
//                    System.out.println("right");
                    break;
                                    
            }
       
        
//        if (instructionNum < 2){
//                                
//            
//        }
        
    }
    
    public void moveRight(){
        
        Map<String, Integer> arrowPosMapNew = findArrowPosition();
        String directionP = dealWithArrowAngle(getArrowAngle());
        
           switch (directionP){ 
                case "forward":
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("\u2197");
//                    System.out.println("forward");
                    break;
                case "diagonalLeft":
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("\u2191");
//                    System.out.println("diagonalLeft");
                    break;
                case "diagonalRight":
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("\u2192");
//                    System.out.println("diagonalRight");
                    break;
                case "left":              
                  
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col") ].setText("\u2196");
//                    System.out.println("left");
//                    findArrowPosition();
                    break;
                
                case "right":
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col") + 1].setText("\u2192");
                    textFields[arrowPosMapNew.get("row")][arrowPosMapNew.get("col")].setText("");
//                    System.out.println("right");
                    break;
                                    
            }
        
    }
    
    public Map<String, Integer> findArrowPosition(){
        String arrowStr;
//        ArrayList<Integer> value_ = new ArrayList<>();
        Map<String, Integer> value_ = new HashMap<>();
        
        for (int x = 0 ; x < textFields.length; x++){
           
            for (int y = 0; y < textFields.length; y++){
                 arrowStr = textFields[x][y].getText();
                 
                 if (!"".equals(arrowStr)) {
                     value_.put ("row", x);
                     value_.put ("col", y);
//                     System.out.println(x + " - " + y);
                } 
            }
            
           
        }
        
        return value_;
    }
    
     public String getArrowAngle(){
        Map<String, Integer> value_ = new HashMap<>();
        String angle;
        
        value_ = findArrowPosition();
        
        angle = textFields[value_.get("row")][value_.get("col")].getText();
        
        return angle;
    }
     
     public String dealWithArrowAngle(String angle){
        String directionPointed = ""; 
        
        switch (angle){
            case "\u2190": directionPointed = "left";
                           break;
            case "\u2191": directionPointed = "forward";
                           break;
            case "\u2192": directionPointed = "right";
                           break;
            case "\u2196": directionPointed = "diagonalLeft";
                           break;
            case "\u2197": directionPointed = "diagonalRight";
                           break;
        }
        
        return directionPointed;
       
    }
    
}
