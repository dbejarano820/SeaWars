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
    public String pathImage;
    int percentCivilization;
    public ArrayList<Superpower> superpowers;
    int healing;
    int strength;
    int resistance;
    
    
    public Hero(String nombre, int percentCivilization, int Healing, int Strength, int Resistance){
        
        this.nombre = nombre;
        this.percentCivilization = percentCivilization;
        this.healing = Healing;
        this.strength = Strength;
        this.resistance = Resistance;
        this.superpowers = new ArrayList<Superpower>();
    }
    
    
    public boolean validSuperpower(String msj){
        
        if(msj.equals("thundersunderthesea"))
            return true;
        else if(msj.equals("fishtelepathy"))
            return true;
        else if(msj.equals("releasethekraken"))
            return true;
        else if(msj.equals("wavescontrol"))
            return true;
        else if(msj.equals("thetrident"))
            return true;
        else if(msj.equals("underseavolcanoes"))
            return true;
        else 
            return false;   
    }
    
    
    public void addSuperPower1(String msj){
        
        switch (msj) {
            case "thundersunderthesea":
                superpowers.add(new ThundersUnderTheSea());
                break;
            case "fishtelepathy":
                superpowers.add(new FishTelepathy());
                break;
            case "releasethekraken":
                superpowers.add(new ReleaseTheKraken());
                break;
            case "wavescontrol":
                superpowers.add(new WavesControl());
                break;
            case "thetrident":
                superpowers.add(new TheTrident());
                break;
            case "underseavolcanoes":
                superpowers.add(new FishTelepathy());
                break;
            default:
                break;
        }
                
    }
    
    public void addSuperPower2(Superpower power){
        superpowers.add(power);
    }
    
   
    
}
