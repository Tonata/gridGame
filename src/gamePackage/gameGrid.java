/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamePackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author martian
 */
public class gameGrid  extends JPanel implements KeyListener, ActionListener {
    
    GridLayout grid = new GridLayout(5, 5, 5, 5);
    int instructionNum;
    String instr;
 
    static JTextField[][] textFields = new JTextField[5][5]; // Array of Object
    JTextField aTxtField = new JTextField();
   
    JPanel gridPanel = new JPanel();
    JPanel inputPanel = new JPanel();
    
   
    
    Map<Integer,Integer> blockedOff;
    
    int size; // size of board (i.e. number of rows and columns )
    
    public gameGrid(){
        initializeUI();
    }
    
    
    private void initializeUI() {
       
        
        blockedOff = new HashMap <>();
        aTxtField.addKeyListener(this);
 
        this.size = textFields.length;

        for (int row = 0; row < textFields.length; row++) {
            int randomNum = 0;
            Random rand = new Random();
            randomNum = rand.nextInt(size);
 
            for (int col = 0; col < textFields[row].length; col++) {
                textFields[row][col] = new JTextField(); // reflects the field coordinates
                if (row == 0 && col == 0) {
                    textFields[row][col].setBackground(Color.YELLOW);
                    textFields[row][col].setEnabled(false);
                }
 
                if (row == (textFields.length - 1) && col == (textFields.length - 1)) {
                    textFields[row][col].setBackground(Color.GREEN);
//                    textFields[row][col].setEnabled(false);
                    textFields[row][col].setText("\u2191");
                   
                }
 
                if (row == 0 && randomNum == 0) {
                    randomNum++;
                }
                if (row == (textFields.length - 1) && randomNum == (textFields.length - 1)) {
                    randomNum--;
                }
 
                if (col == randomNum) {
                    textFields[row][col].setBackground(Color.BLUE);
                    textFields[row][col].setEnabled(false);
                    blockedOff.put(row, col);
                }

                textFields[row][col].setHorizontalAlignment(SwingConstants.CENTER);
 
                gridPanel.add(textFields[row][col]);
              
            }
            
            
        }
        
        JLabel aLabel = new JLabel("Type a command:");
        aTxtField.setPreferredSize(new Dimension(150, 25));
        JButton aButton = new JButton("Go");
 
        inputPanel.setLayout(new GridLayout(1, 1, 1, 1));
        inputPanel.setPreferredSize(new Dimension(300, 35));
//        inputPanel.add(aLabel);
        inputPanel.add(aTxtField);
        inputPanel.add(aButton);
        aButton.addActionListener(this);
        inputPanel.setLayout(new FlowLayout());
        // inputPanel.setBackground(Color.RED);

        gridPanel.setLayout(grid);
        gridPanel.setPreferredSize(new Dimension(300, 300));
        add(gridPanel, BorderLayout.NORTH);
        add(new JSeparator(), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    
}
     
      /** Handle the key typed event from the text field. */
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    /** Handle the key-pressed event from the text field. */
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyCode());
        
//        if (e.getKeyCode() != 76 && e.getKeyCode() != 70 && e.getKeyCode() != 82 ){
//            
////              System.out.println(e.getKeyChar());
//              System.out.println("Invalid Instruction, The system only accepts L, R or F ");
//              aTxtField.getText().replace(e.getKeyChar(), ' ');
//        }
    }

    /** Handle the key-released event from the text field. */
    @Override
    public void keyReleased(KeyEvent e) {
        
//         if (e.getKeyCode() != 76 && e.getKeyCode() != 70 && e.getKeyCode() != 82 ){
//            
////              System.out.println(e.getKeyChar());
//              System.out.println("Invalid Instruction, The system only accepts L, R or F ");
//              aTxtField.getText().replace(e.getKeyChar(), ' ');
//        }
       
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
                    left(arrList, directionP, instructionNum);
                   }
                   break;
                case "R":
                case "F":
                    instructionNum = Integer.parseInt(instr.substring(1)); 
                    for (int p = 0; p < instructionNum; p++){
                       forward(arrList, directionP, instructionNum);
                    }
                    break;
            }
        }  
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        String userText = aTxtField.getText();
        Map<String, Integer> arrList = new HashMap<>();
        ArrayList<String> instructions = new ArrayList<>();
        gameGridManager gridManager = new gameGridManager ();
        
        if (userText.length() % 2 == 0 ){
            int i = 0;

            while (i < userText.length()){
                instructions.add(userText.substring(i, i+2));
                i = i + 2;
             }
            
            gridManager.moveArrow(instructions);
            
//             for (int j = 0; j < instructions.size(); j++){
//                  String instr = instructions.get(j);
//                
//                  arrList = findArrowPosition();
//                  String directionP = dealWithArrowAngle(getArrowAngle());
//                  
//                  switch (instr.substring(0,1).toUpperCase()){
//                        case "L":
//                            instructionNum = Integer.parseInt(instr.substring(1)); 
//                          
//                        
//                            left(arrList, directionP, instructionNum);
////                            actionPerformed(e);
//                            System.out.println("In actionPerformed for loop");
//                        case "R":
//                        case "F":
//                    }
//             }
        }
            
    }
    
    
    public void forward(Map<String, Integer> arrowPosMap, 
                        String direction,
                        int instructionNum){
        
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
    
    public void left(Map<String, Integer> arrowPosMap, 
                     String direction,
                     int instructionNum){
       
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
    
    public void right(){
        
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
