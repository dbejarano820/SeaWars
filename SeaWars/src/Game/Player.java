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
    
    
    
    public Player(String nombre){
        this.nombre  = nombre;
        tablero = new Casilla[20][30]; 
        heros = new ArrayList<Hero>();
        //que mas?
    }
    
    
    
    
    
    
}
