/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author PERSONAL
 */
public class Hero {
    
    public String nombre;
    public JLabel refLabel;
    public String pathImage;
    int percentCivilization;
    public ArrayList<Superpower> superpowers;
    int healing;
    int strength;
    int resistance;
    
    
    public Hero(String nombre,JLabel refLabel, String pathImage, int percentCivilization, int Healing, int Strength, int Resistance, String superpower){
        
        this.nombre = nombre;
        this.refLabel = refLabel;
        this.pathImage = pathImage;
        this.percentCivilization = percentCivilization;
        this.healing = Healing;
        this.strength = Strength;
        this.resistance = Resistance;
        //this.si
        
    }
    
    
}
