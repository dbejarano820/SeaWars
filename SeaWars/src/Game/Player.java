/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
public class Player {
    
    public String nombre;
    public Casilla [][] tablero;
    public ArrayList<Hero> heros;
    public String historialPersonal;
    public int cantidadAtaques;
    public int cantidadAtinados;
    public boolean gameReady;
    
    public ArrayList<Integer> disponibleValores;
    private int totalCivilizacion; 
    
    public Player(String nombre){
        this.nombre  = nombre;
        tablero = new Casilla[20][30]; 
        heros = new ArrayList<Hero>();
        cantidadAtaques = 0;
        cantidadAtinados = 0;
        gameReady = false;
        disponibleValores = new ArrayList<Integer>();
        totalCivilizacion = 100;
        
        disponibleValores.add(50);
        disponibleValores.add(50);
        disponibleValores.add(50);
        disponibleValores.add(75);
        disponibleValores.add(75);
        disponibleValores.add(75);
        disponibleValores.add(100);
        disponibleValores.add(100);
        disponibleValores.add(100);
    }
  
    
    public boolean validHero(int percentCivilizacion, int healing, int strength, int resistance){
        
        if((totalCivilizacion - percentCivilizacion) != 0 && heros.size() == 2)  //los tres heroes tienen que representar el 100% de los humanos
            return false;

        else if(!disponibleValores.remove(new Integer(healing)))
            return false;
        else if(!disponibleValores.remove(new Integer(strength)))
            return false;
        else if(!disponibleValores.remove(new Integer(resistance)))
            return false;
        else
            return true;
   
    }
    
    public void addHero(String nombre, int percentCivilization, int Healing, int Strength, int Resistance){
        heros.add(new Hero(nombre, percentCivilization, Healing, Strength, Resistance));
    }
    
  
    public boolean readyGame(){
        
        if(!(heros.size() == 3))
            return false;
        gameReady = true;
        return true;
    }  
    
}
