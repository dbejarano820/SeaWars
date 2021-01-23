/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
public class Server {

     PantallaServer refPantalla;
     public ArrayList<ThreadServer> conexiones;
     //include game
     //game va a tener player, peleadores, y poderes   cada player tiene 3 peleadores los cuales tienen un arraylist de poderes.
     int contadorDeConexiones;
     private boolean running = true;
     private ServerSocket srv;
     private int turno = 0;
     private boolean partidaIniciada = false;


     
    public Server(PantallaServer refPantalla){
        
        this.refPantalla = refPantalla;
        
       
    }
     
     

    public void runServer(){
        contadorDeConexiones = 0;
        try{
            srv = new ServerSocket(35577);
            refPantalla.setTitle("SERVER");
            while (running){
                
                if(partidaIniciada)
                    refPantalla.addMessage("::Game has started!");
                else refPantalla.addMessage("::Awaiting connection....");
                    Socket nuevaConexion = srv.accept();
                if (!partidaIniciada){ 
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
                    
                    refPantalla.addMessage(":Connection denied: game has already started!");
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    
    }

    
}
