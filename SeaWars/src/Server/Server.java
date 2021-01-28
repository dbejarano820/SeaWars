/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import Game.*;
import java.util.Random;

/**
 *
 * @author PERSONAL
 */
public class Server {

     PantallaServer refPantalla;
     public ArrayList<ThreadServer> conexiones;
     //include game
     //game va a tener player, peleadores, y poderes   cada player tiene 3 peleadores los cuales tienen un arraylist de poderes.
     public ArrayList<Player> players;
     public ArrayList<Player> ordenPlayers;
     public int contadorDeConexiones;
     public int setAmountPlayers;
     private boolean running = true;
     private ServerSocket srv;
     private int turno = 0;
     private boolean gameStarted = false;
     public boolean allPlayersReady = false;
     public int tridentNum1;
     public int tridentNum2;
     public int tridentNum3;
     public Player tridentRetador;
     public Hero tridentHeroRetador;

     
    public Server(PantallaServer refPantalla){
        
        this.refPantalla = refPantalla;
        players = new ArrayList<Player>();
        conexiones = new ArrayList<ThreadServer>();
        ordenPlayers = new ArrayList<Player>();
       
    }
     
    public void startGame(){
        this.gameStarted = true;
    } 
    
    
    public Player buscarPlayer(String jugador){
        
        for(int i = 0; i<players.size(); i++){
            if(players.get(i).nombre.equals(jugador))
                return players.get(i);
        }
        return null;
    }
    
    public void generateOrder(){
        
        while(ordenPlayers.size()!= players.size()){
          int rando = (new Random()).nextInt(conexiones.size());
          Player playerTmp = players.get(rando);   
          if(!estaOrdenPlayer(playerTmp))
              ordenPlayers.add(playerTmp);
        }
    }
    
    public boolean estaOrdenPlayer(Player playerTmp){
        
        for(int i = 0; i < ordenPlayers.size(); i++){
            if(ordenPlayers.get(i).equals(playerTmp))
                return true;
        }
        return false;
    }
    
    
    public boolean areAllReady(){
        
        for(int i = 0; i<players.size(); i++){            
            if(!players.get(i).gameReady)
                return false;
        }
        
        generateOrder();
        allPlayersReady = true;
        return true;
    }
    
    public String getTurno(){
        
        return ordenPlayers.get(turno).nombre;
    }
    
    public String getNextTurno(){
        
        if(++turno >= ordenPlayers.size())
            turno = 0;
       
        return ordenPlayers.get(turno).nombre;
    }

    public void runServer(){
        contadorDeConexiones = 0;
        try{
            srv = new ServerSocket(35577);
            refPantalla.setTitle("SERVER");
            while (running){
                
                if(gameStarted)
                    refPantalla.addMessage("::Game has started!");
                else refPantalla.addMessage("::Awaiting connection....");
                Socket nuevaConexion = srv.accept();
                if (!gameStarted && contadorDeConexiones < setAmountPlayers){ 
                    contadorDeConexiones++;
                    refPantalla.increaseConnections();
                    refPantalla.addMessage(":Connection #" + contadorDeConexiones + " accepted!");

                    //nuevo trhead
                    ThreadServer newThread = new ThreadServer(nuevaConexion, this);
                    conexiones.add(newThread);
                    newThread.start();
                }
                else{
                    // OutputStream socket para poder hacer un writer
                    
                    refPantalla.addMessage(":Connection denied: game lobby is full!");
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    
    }
   
    
    public String absorberPoder(Player jugadorHeroe, Hero heroTmp, Player jugadorAtacado){
        
        String res = "";
        
        for(int i = 0; i < jugadorAtacado.heros.size();i++){
            boolean muertoTmp = true;
            for(int row = 0; row < jugadorAtacado.tablero.length; row++){
                
                for(int col = 0; col < jugadorAtacado.tablero[row].length; col++){
                    
                    if(jugadorAtacado.tablero[row][col].vida > 0 && jugadorAtacado.tablero[row][col].heroOwner.equals(jugadorAtacado.heros.get(i).nombre)){
                        muertoTmp = false;
                        break;
                     }
                }
                if(!muertoTmp)
                    break;
            }
  
            if(muertoTmp && jugadorAtacado.heros.get(i).superpowers.size() > 0){
                
                for(int j = 0; j < jugadorAtacado.heros.get(i).superpowers.size(); j++){
                    res += heroTmp.nombre + " de " + jugadorHeroe.nombre + " ha absorbido el poder " + jugadorAtacado.heros.get(i).superpowers.get(j).getClass().getSimpleName() 
                            + " del heroe " + jugadorAtacado.heros.get(i).nombre + " del jugador " + jugadorAtacado.nombre + "\n";
                    heroTmp.superpowers.add(jugadorAtacado.heros.get(i).superpowers.remove(j)); 
                }
            }
        } 
        return res;  
    }
}
