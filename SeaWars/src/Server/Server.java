/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author PERSONAL
 */
public class Server {

     PantallaServer refPantalla;
     int contadorDeConexiones;
     private boolean running = true;
     private ServerSocket srv;
     private int turno = 0;
     private boolean partidaIniciada = false;








/*
    public void runServer(){
        contadorDeConexiones = 0;
        try{
            srv = new ServerSocket(35577);
            refPantalla.setTitle("SERVER");
            while (running){
                
                if(prepartidaIniciada)
                    refPantalla.addMessage("::Game has started!");
                else refPantalla.addMessage("::Awaiting connection....");
                    Socket nuevaConexion = srv.accept();
                if (!prepartidaIniciada){ 
                    contadorDeConexiones++;
                    refPantalla.increaseConnections();
                    refPantalla.addMessage(":Connection #" + contadorDeConexiones + " accepted!");

                    // nuevo thread
                    ThreadServer newThread = new ThreadServer(nuevaConexion, this);
                    conexiones.add(newThread);
                    newThread.start();
                    
                    if(contadorDeConexiones == setAmountPlayers){
                        conexiones.get(0).iniciarPreGame();
                       // refPantalla.addMessage("::Game has started!");
                        //for loop writing start
                    }
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
*/
    
}
