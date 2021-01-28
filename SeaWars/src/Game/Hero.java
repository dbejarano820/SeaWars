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
    public int healing;
    public int strength;
    public int strengthTmp;
    int resistance;
    
    
    public Hero(String nombre, int percentCivilization, int Healing, int Strength, int Resistance){
        
        this.nombre = nombre;
        this.percentCivilization = percentCivilization;
        this.healing = Healing;
        this.strength = Strength;
        this.resistance = Resistance;
        this.superpowers = new ArrayList<Superpower>();
        this.strengthTmp = 0;
    }
    
    
    public boolean validAbility(String msj){
        
        if(msj.equals("healing"))
            return true;
        else if(msj.equals("strength"))
            return true;
        else if(msj.equals("resistance"))
            return true;
 
        return false;       
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
    
    
    public String buscarSuperpowerName(String msj){

    if(msj.equals("thundersunderthesea"))
        return "Thunders Under The Sea";
    else if(msj.equals("fishtelepathy"))
        return "Fish Telepathy";
    else if(msj.equals("releasethekraken"))
        return "Release The Kraken";
    else if(msj.equals("wavescontrol"))
        return "Waves Control";
    else if(msj.equals("thetrident"))
        return "The Trident";
    else if(msj.equals("underseavolcanoes"))
        return "Undersea Volcanoes";
    else 
        return "";   
}
    
    
    public boolean estaSuperpower(String power){
        String n = "";
        
         if(power.equals("thundersunderthesea"))
            n = "Game.ThundersUnderTheSea";   
       else if(power.equals("fishtelepathy"))
            n = "Game.FishTelepathy"; 
        else if(power.equals("releasethekraken"))
             n = "Game.ReleaseTheKraken";            
        else if(power.equals("wavescontrol"))
             n = "Game.WavesControl"; 
        else if(power.equals("thetrident"))
             n = "Game.TheTrident"; 
        else if(power.equals("underseavolcanoes"))
             n = "Game.UnderseaVolcanoes";       
        
        for(int i = 0; i<superpowers.size();i++){
            if(superpowers.get(i).getClass().getName().equals(n))
                return true;
        }
        return false;
    }

    public ThundersUnderTheSea buscarThunder(String power){      
       if(power.equals("thundersunderthesea"))
            return new ThundersUnderTheSea();     
        else
            return null;
    }    
    
    public FishTelepathy buscarFish(String power){
        if(power.equals("fishtelepathy"))
            return new FishTelepathy();
        else
            return null;
    }
    
    public ReleaseTheKraken buscarKraken(String power){       
        if(power.equals("releasethekraken"))
            return new ReleaseTheKraken();
        else
            return null;
    }
    
    public WavesControl buscarWaves(String power){
        if(power.equals("wavescontrol"))
            return new WavesControl();
        else
            return null;
    }
    
    public TheTrident buscarTrident(String power){
        if(power.equals("thetrident"))
            return new TheTrident();
        else
            return null;
    }
    
    public UnderseaVolcanoes buscarVolcano(String power){
        if(power.equals("underseavolcanoes"))
            return new UnderseaVolcanoes();
        else 
            return null;
        
        
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
                superpowers.add(new UnderseaVolcanoes());
                break;
            default:
                break;
        }
                
    }
    
    public void addSuperPower2(Superpower power){
        superpowers.add(power);
    }
    
   
    public String updateInfo(){
        
        String heroInfo = "% de civilizacion: " + percentCivilization +"\n";
        
        for(int i = 0; i< superpowers.size(); i++){
            heroInfo += superpowers.get(i).getClass().getSimpleName() + "\n\n";
        }
        
        
        heroInfo += "Healing: " + healing + "\n" + "Strength: " + strength + "\n" + "Resistance: " + resistance + "\n";
        
        return heroInfo;
        
    }
    
    
}
