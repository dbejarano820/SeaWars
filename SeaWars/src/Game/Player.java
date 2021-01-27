/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.Random;

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
        generateTablero();
        
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
  
    public void generateTablero(){
        
        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){
                tablero[row][col] = new Casilla();         
            } 
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
        
        
        int cantidadCasillas = ((int)(((double) percentCivilization / (double)100)* (double)600));
        
        while(cantidadCasillas != 0){
            
            int row = (new Random()).nextInt(20);   //aca se cae si no es 20 .. no puede ser 19
            int col = (new Random()).nextInt(30);
            
            if(tablero[row][col].heroOwner.equals("")){
                tablero[row][col].heroOwner = nombre;
                cantidadCasillas--;
            }
        }    
    }
    
    public boolean estaVivo(){  //metodo para revisar si esta vivo
        
        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){
                if(tablero[row][col].vida > 0)
                    return true;
            }
        return false;
   
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
    
    
    public String updateStatusMessage(){
        int muertas = 0;
        int vidaTmp = 0;
        String res = "";
        
        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){
                
                if(tablero[row][col].vida <= 0)
                    muertas++;
                vidaTmp += tablero[row][col].vida;
            }
        
        int vida = (int) (((double)vidaTmp / 60000.0) * 100.0 );
        
        res += nombre + " has " + vida + " heatlh, with a total of " + muertas + " dead casillas!";
        return res;   
    }
    
    //retorna la vida actual del jugador
    public int updateVidaActual(){
        int vidaTmp = 0;
        
        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){
                vidaTmp += tablero[row][col].vida;
            }
        
        int vida = (int) (((double)vidaTmp / 60000.0) * 100.0 );

        return vida;   
    }
     //retorna la cantidad de casillas muertas del jugador   
     public int updateMuertosActual(){
        int muertas = 0;
        
        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){              
                if(tablero[row][col].vida <= 0)
                    muertas++;
            }

        return muertas;   
    }     
    
    //retorna un logsummary del jugador para saber la efectividad del mismo
    public String logSummary(){
        
        String res = "";  
        int efectividad = (int)(((double)cantidadAtinados / (double)cantidadAtaques) * 100.0); 
        res+= "Total de ataques: " + cantidadAtaques + ", Total de ataques atinados: " + cantidadAtinados + ", Efectividad: " + efectividad;
        return res;
        
    } 
    
    
    public String updateTableroHero1(){

        int vidaHero1 = 0;
        int vidaHero1Total = 0;
        int casillasVivasHero1 = 0;

        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){
                
                if(tablero[row][col].heroOwner.equals(heros.get(0).nombre)){
                    vidaHero1Total += 100;
                    if(tablero[row][col].vida > 0)
                        casillasVivasHero1++;
                    vidaHero1 += tablero[row][col].vida;            
                }
            }
        
        int vida = (int) (((double)vidaHero1 / (double)vidaHero1Total) * 100.0 );

        return vida + "%" + "\n" + casillasVivasHero1 +" out of " + ((int)(((double) heros.get(0).percentCivilization / (double)100)* (double)600)) + " casillas";
    }

    public String updateTableroHero2(){

        int vidaHero2 = 0;
        int vidaHero2Total = 0;
        int casillasVivasHero2 = 0;

        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){
                
                if(tablero[row][col].heroOwner.equals(heros.get(1).nombre)){
                    vidaHero2Total += 100;
                    if(tablero[row][col].vida > 0)
                        casillasVivasHero2++;
                    vidaHero2 += tablero[row][col].vida;            
                }
            }
        
        int vida = (int) (((double)vidaHero2 / (double)vidaHero2Total) * 100.0 );

        return vida + "%" + "\n" + casillasVivasHero2 +" out of " + ((int)(((double) heros.get(1).percentCivilization / (double)100)* (double)600)) + " casillas";
    }
    


    public String updateTableroHero3(){

        int vidaHero3 = 0;
        int vidaHero3Total = 0;
        int casillasVivasHero3 = 0;

        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){
                
                if(tablero[row][col].heroOwner.equals(heros.get(2).nombre)){
                    vidaHero3Total += 100;
                    if(tablero[row][col].vida > 0)
                        casillasVivasHero3++;
                    vidaHero3 += tablero[row][col].vida;            
                }
            }
        
        int vida = (int) (((double)vidaHero3 / (double)vidaHero3Total) * 100.0 );

        return vida + "%" + "\n" + casillasVivasHero3 +" out of " + ((int)(((double) heros.get(2).percentCivilization / (double)100)* (double)600)) + " casillas";
    }
        
    
    //HABILIDADES
    
    public String healing(Hero heroTmp){

        String res = "";
        
        
        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){
               
                if(tablero[row][col].vida > 0 && tablero[row][col].vida < heroTmp.healing && tablero[row][col].heroOwner.equals(heroTmp.nombre)){
                    res += heroTmp.nombre + " sanó a la casilla (" + col + "," + row +") " + " hasta " + heroTmp.healing + "\n";
                    tablero[row][col].vida = heroTmp.healing; 
                    System.out.println("VIDA DE CASILLA SANADA :" + tablero[row][col].vida);
                }
            }  
        if(res.equals(""))
            res += heroTmp.nombre + " intentó sanar sus casillas pero ninguna lo necesitaba!\n";
        return res;  
    }
    
    
    public String strength(Hero heroTmp){

        String res = "";
        heroTmp.strengthTmp = heroTmp.strength;
        res += heroTmp.nombre + " utilizó fuerza y tendrá " + heroTmp.strength + " de aumento en su próximo ataque\n";
       
        return res;  
    }
    
    
    public String resistance(Hero heroTmp){

        String res = "";
        
        
        for(int row = 0; row < tablero.length; row++)
            for(int col = 0; col < tablero[row].length; col++){     
                if(tablero[row][col].vida > 0 && tablero[row][col].heroOwner.equals(heroTmp.nombre)){
                    res += heroTmp.nombre + " protegió a la casilla (" + col + "," + row +") " + " con un escudo de " + heroTmp.resistance + "\n";
                    tablero[row][col].escudo = heroTmp.resistance; 
                }
            }        
        return res;  
    }
    
    
    
    
    
}
