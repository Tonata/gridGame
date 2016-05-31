/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamePackage;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author martian
 */
public interface GridManager {
    
    public void moveArrow();
    public void moveArrow(ArrayList<String> instructions);
    public void moveForward();
    public void moveRight();
    public void moveLeft();
    public Map<String,Integer> findArrowPosition();
    public String getArrowAngle();
    public String dealWithArrowAngle(String angle);
    
    
    
}
