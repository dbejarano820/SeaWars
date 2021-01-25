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
    public boolean krakenDefense;
    public ArrayList<Integer> disponibleValores;
    private int totalCivilizacion; 
    
    public Player(String nombre){
        this.nombre  = nombre;
        tablero = new Casilla[20][30]; 
        heros = new ArrayList<Hero>();
        cantidadAtaques = 0;
        cantidadAtinados = 0;
        gameReady = false;
        krakenDefense = false;
        disponibleValores = new ArrayList<Integer>();
        totalCivilizacion = 100;
        
        disponibleValores.add(50);
        disponibleValores.add(50);  //new Integer(50)
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

        else if(!disponibleValores.contains(healing))
            return false;
        else if(!disponibleValores.contains(strength))
            return false;
        else return disponibleValores.contains(resistance);
    }
    
    public void addHero(String nombre, int percentCivilization, int Healing, int Strength, int Resistance){
        heros.add(new Hero(nombre, percentCivilization, Healing, Strength, Resistance));
        totalCivilizacion -= percentCivilization;
        disponibleValores.remove(new Integer(Healing));
        disponibleValores.remove(new Integer(Strength));
        disponibleValores.remove(new Integer(Resistance));
    }
    
    public boolean estaVivo(){  //metodo para revisar si esta vivo
        
        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){
                if(tablero[row][col].vida > 0)
                    return true;
            }
        return false;
   
    }
    
    
    public String logSummary(){
        
        String res = "";  
        res+= "Total de ataques: " + cantidadAtaques + ", Total de ataques atinados: " + cantidadAtinados + ", Efectividad: " + 0;
        return res;
        
    }
    
    
    public void surrender(){
        
        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++)
                tablero[row][col].vida = 0;
    }
    
    
    public Hero buscarHero(String name){
        
        for(int i = 0; i < heros.size(); i++){
            if(heros.get(i).nombre.equals(name))
                return heros.get(i);
        }
        return null;
    }
    
  
    public boolean readyGame(){
        
        if(!(heros.size() == 3))
            return false;
        gameReady = true;
        return true;
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
    
    
    public String cellStatus(int row, int col){
        
        Casilla casillaTmp = tablero[row][col];
        return casillaTmp.update();
    }

}
