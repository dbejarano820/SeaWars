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
     public int contadorDeConexiones;
     public int setAmountPlayers;
     private boolean running = true;
     private ServerSocket srv;
     private int turno = 0;
     private boolean gameStarted = false;


     
    public Server(PantallaServer refPantalla){
        
        this.refPantalla = refPantalla;
        players = new ArrayList<Player>();
        conexiones = new ArrayList<ThreadServer>();
       
    }
     
    public void startGame(){
        this.gameStarted = true;
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

    
}
