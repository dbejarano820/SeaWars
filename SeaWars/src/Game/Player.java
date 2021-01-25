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
    private int disponible100;
    private int disponible75;
    private int disponible50;
    private int totalCivilizacion; 
    
    public Player(String nombre){
        this.nombre  = nombre;
        tablero = new Casilla[20][30]; 
        heros = new ArrayList<Hero>();
        cantidadAtaques = 0;
        cantidadAtinados = 0;
        gameReady = false;
        disponible100 = 3;
        disponible75 = 3;
        disponible50 = 3;
        totalCivilizacion = 100;
    }
  
    
    public boolean validHero(int percentCivilizacion, int healing, int strength, int resistance){
        
        if((totalCivilizacion - percentCivilizacion) != 0 && heros.size() == 2)  //los tres heroes tienen que representar el 100% de los humanos
            return false;
        
        
        if(healing == 100){
            
            
            
        }
        
        
    }
    
    public void addHero(){
        
       
        
        
        
    }
    
  
    public boolean readyGame(){
        
        if(!(heros.size() == 3))
            return false;
        gameReady = true;
        return true;
    }  
    
}
