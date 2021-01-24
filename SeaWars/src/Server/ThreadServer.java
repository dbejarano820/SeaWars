/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import Game.*;

/**
 *
 * @author PERSONAL
 */
public class ThreadServer extends Thread {
    
    private Socket socketRef;
    private DataInputStream reader;
    public DataOutputStream writer;
    public String nombre;
    private boolean running = true;
    Server server;
    
    
    public ThreadServer(Socket socketRef, Server server) throws IOException {
      this.socketRef = socketRef;
      reader = new DataInputStream(socketRef.getInputStream());
      writer = new DataOutputStream(socketRef.getOutputStream());
      this.server = server;
  }   
    
    
    public void startGame() throws IOException {
 
        //start game on server
        //start game on all thread
        
        
    }
    
    
    public void run(){
        
        int instruccionID = 1;
        while(running){
            
            //revisar si perdio
            /*
            Player jugador = server.buscar(nombre);
            if(server.partidaIniciada && jugador.totalCash <= 0 && jugador.todasHipotecadas()){
                server.ordenTurnos.remove(this);
            }    
            */

            try {
               instruccionID = reader.readInt(); //espera hasta recibir un entero
               String usuario = "";  //variable de usuario para utilizar en todos los casos
               switch(instruccionID){
                   
                   case 1: //caso para agregar jugador a la lista
                       nombre = reader.readUTF();
                       server.players.add(new Player(nombre));
                       //add player to list of players del server           
                   break;
                   
                   case 2:
                       usuario = reader.readUTF();
                       String comando = reader.readUTF();
                       String[] comandos = comando.split("-");
                       
                       System.out.println(comandos[0]);
                       
                       if(comandos[0].equals("create")){
                           
                           System.out.println(comandos[1]);
                       }
                       else if(comandos[0].equals("start")){
                           
                           System.out.println("game started");
                       }
                       else if(comandos[0].equals("play")){
                           
                       }
                        else if(comandos[0].equals("skip")){
                           
                       }
                       else if(comandos[0].equals("chat")){
                           
                       }                       
                       else if(comandos[0].equals("whisper")){
                           
                       }                       
                       else if(comandos[0].equals("surrender")){
                           
                       }                       
                       else if(comandos[0].equals("cellstatus")){
                           
                       }  
                       else if(comandos[0].equals("log")){
                           
                       }
                       else if(comandos[0].equals("logsummary")){
                           
                       }                       
                       else if(comandos[0].equals("enemystatus")){
                           
                       }
                       else if(comandos[0].equals("showcells")){
                           
                           if(comandos[1].equals("occupied")){
                               
                           }
                           else if(comandos[1].equals("health")){
                               
                           }
                           else if(comandos[1].equals("alive")){
                               
                           } 
                       }
                       else{
                           
                           //no se ingreso ningun comando valido
                           
                       }
                       
                       
                       //parse string
                       
                       //parse string
                       
                   
                   
               }               
            } catch (IOException ex){
                
             
            }
        } 
    }
    


}
