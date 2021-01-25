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
    
   /* 
   public void updateTablero{
    
    send to hero1tablero vida %, y casillas destruidas
    
    same for hero2 y 3
    
    
}
    
    */
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
               Player jugadorTmp = null; //variable de player para utilizar en cualquier caso
               String msj = "";
               
               
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
                       
                       
                       if(comandos[0].equals("create")){  //comando para crear 1 de 3 heroes
                           jugadorTmp = server.buscarPlayer(usuario);
                           
                           if(jugadorTmp.gameReady){
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. You have already completed your army!");
                               break;
                           }
                           String nameHero = comandos[1];
                           String pathImage = comandos[2];
                           int percentCivilization = Integer.parseInt(comandos[3]);
                           String superpower = comandos[4];
                           int healing = Integer.parseInt(comandos[5]);
                           int strength = Integer.parseInt(comandos[6]);
                           int resistance = Integer.parseInt(comandos[7]);
                           
                           if(jugadorTmp.validHero(percentCivilization, healing, strength, resistance) && jugadorTmp.validSuperpower(superpower)){    //si es valido, lo crea
                               
                               jugadorTmp.addHero(nameHero, percentCivilization, healing, strength, resistance);
                               jugadorTmp.buscarHero(nameHero).addSuperPower1(superpower);
                               String heroInfo = "% de civilizacion: " + percentCivilization +"\n" + jugadorTmp.buscarHero(nameHero).buscarSuperpowerName(superpower) + "\n" + 
                                       "\n" + "Healing: " + healing + "\n" + "Strength: " + strength + "\n" + "Resistance: " + resistance + "\n";
                               
                               String heroInfoTablero = "100%" + "\n" + ((double)(percentCivilization/100)* 600) +" out of " + ((double)(percentCivilization/100)* 600) + " casillas";
                               //send case to pintar players
                               writer.writeInt(3);
                               writer.writeUTF(nameHero);
                               writer.writeUTF(heroInfo);
                               writer.writeUTF(pathImage);
                               writer.writeInt(jugadorTmp.heros.size());
                               writer.writeUTF(heroInfoTablero);
  
                           }
                           else{
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. The hero creation command is invalid, please correct");
                               break;
                           }
   
                       }
   
                       
                       else if(comandos[0].equals("start")){  //comando para dar ready game
                           
                           jugadorTmp = server.buscarPlayer(usuario);
                             //does player have 3 heros                         
                             
                           if(!jugadorTmp.readyGame()){
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. You haven't created your 3 heros yet and aren't ready to start!");
                               break;
                           }
                           
                           else if(server.areAllReady()){

                                for(int i = 0; i < server.conexiones.size(); i++){
                                    ThreadServer current = server.conexiones.get(i);
                                    current.writer.writeInt(1);
                                    current.writer.writeUTF(server.ordenPlayers.get(0).nombre);                 
                                }
                           }

                       }
                       
                       else if(comandos[0].equals("play")){  //comando para realizar una jugada/ataque a un jugador, ya sea con el un ataque o habilidad de un heroe
                           
                           
                           if(server.getTurno().equals(usuario)){
                               
                               //otras validaciones
                                   //aca van jugadas
                                  //String nombreHeroActual = comando[1];
                                  //string superpower
                                  //string attack

                               
                                for(int i = 0; i < server.conexiones.size(); i++){
                                    ThreadServer current = server.conexiones.get(i);
                                    current.writer.writeInt(1);
                                    current.writer.writeUTF(server.getNextTurno());                 
                                   }                           
                             
                                
                                
                                
                                
                               
                           }
                           else{
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. It is not your turn!"); 
                           }

                           
                       }
                       
                       else if(comandos[0].equals("skip")){ //comando para saltarse su turno y no atacar
                         
                           if(server.getTurno().equals(usuario)){
                               
                                for(int i = 0; i < server.conexiones.size(); i++){
                                  ThreadServer current = server.conexiones.get(i);
                                  current.writer.writeInt(4);
                                  current.writer.writeUTF(usuario + "has skipped his turn!");                 
                                 }

                                 for(int i = 0; i < server.conexiones.size(); i++){
                                   ThreadServer current = server.conexiones.get(i);
                                   current.writer.writeInt(1);
                                   current.writer.writeUTF(server.getNextTurno());                 
                                  }                          
 
                           }
                           else{
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. It is not your turn!"); 
                           }                          
 
                           
                       }
                        
                       else if(comandos[0].equals("chat")){  //comadno para mandar un mensaje al chat global
                           
                           msj = "(Chat) " + usuario + " > "+ comandos[1]; 
                           
                           for(int i = 0; i < server.conexiones.size(); i++){
                               ThreadServer current = server.conexiones.get(i);
                               current.writer.writeInt(4);
                               current.writer.writeUTF(msj);                 
                           }
                           
                           
                       }
                       
                       else if(comandos[0].equals("whisper")){ //comando para mandar un mensaje privado
                           
                           msj = "(Whisper) " + usuario + " > " + comandos[2];
                           
                           for(int i = 0; i < server.conexiones.size(); i++){
                               ThreadServer current = server.conexiones.get(i);
                               if(current.nombre.equals(comandos[1])){
                                   current.writer.writeInt(4);
                                   current.writer.writeUTF(msj);
                               }
                           }
                       }    
                       
                       else if(comandos[0].equals("surrender")){ //comando para rendirse del juego
                           
                           jugadorTmp = server.buscarPlayer(usuario);
                           jugadorTmp.surrender();
                           
                           for(int i = 0; i < server.conexiones.size(); i++){
                               ThreadServer current = server.conexiones.get(i);
                               current.writer.writeInt(4);
                               current.writer.writeUTF(usuario + " has surrendered!");                 
                           }                           
                           
                       }                       
                       else if(comandos[0].equals("cellstatus")){ //comando para solicitar el estado de una casilla, incluye vida, estado (vivo o muerto) y lista cronologica de ataques                    
                           
                           jugadorTmp = server.buscarPlayer(usuario);
                           int row = Integer.parseInt(comandos[1]);
                           int col = Integer.parseInt(comandos[2]);
                           writer.writeInt(4);
                           writer.writeUTF(jugadorTmp.cellStatus(row, col));      
                       }  
                       
                       else if(comandos[0].equals("logsummary")){ //comando que da cuántos ataques se han realizado y cuál es el porcentaje de éxito, cuántos aitnaron, cuántos no.
                           
                       }                       
                       else if(comandos[0].equals("enemystatus")){ // comando que muestra el estado del enemigo: porcentaje de vida, casillas de muertas del total.
                           
                       }
                       else if(comandos[0].equals("showcells")){
                           
                           if(comandos[1].equals("occupied")){
                               
                           }
                           else if(comandos[1].equals("health")){
                               
                           }
                           else if(comandos[1].equals("alive")){
                               
                           } 
                       }
                       else{ //si no hay ninguna entrada valida
                           writer.writeInt(2);
                           writer.writeUTF("ERROR. Invalid command!");
                       }
                       
                   
                   
               }               
            } catch (IOException ex){
                
             
            }
        } 
    }
    


}
