/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamePackage;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 *
 * @author martian
 */
public class runGrid {
    
    
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        gameGrid grid = new gameGrid();
        
        jFrame.setTitle("Hello, I'm a test container");
        jFrame.add(grid);
        jFrame.setSize(300, 370);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        
        
       
//        SwingUtilities.invokeLater(new Runnable() {
// 
//            @Override
//            public void run() {
//                new Grid();
//            }
//        });
 
    }
    
}
