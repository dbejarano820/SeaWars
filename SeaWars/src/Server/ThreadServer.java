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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public Server server;
    
    
    public ThreadServer(Socket socketRef, Server server) throws IOException {
      this.socketRef = socketRef;
      reader = new DataInputStream(socketRef.getInputStream());
      writer = new DataOutputStream(socketRef.getOutputStream());
      this.server = server;
  }   
    
   //actauliza los valores debajo del tablero
   public void updateTableroHeros() throws IOException {
    
        for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            
            if(current.nombre.equals(server.players.get(i).nombre)){
                current.writer.writeInt(5);
                current.writer.writeUTF(server.players.get(i).updateTableroHero1());
                current.writer.writeUTF(server.players.get(i).updateTableroHero2());
                current.writer.writeUTF(server.players.get(i).updateTableroHero3());
                current.writer.writeInt(server.players.get(i).updateVidaActual());
                current.writer.writeInt(server.players.get(i).updateMuertosActual());
            }                  
        }
     }
   
   
   public void updateInfoPowers() throws IOException {
       
         for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            
            if(current.nombre.equals(server.players.get(i).nombre)){
                current.writer.writeInt(11);
                current.writer.writeUTF(server.players.get(i).heros.get(0).updateInfo());
                current.writer.writeUTF(server.players.get(i).heros.get(1).updateInfo());
                current.writer.writeUTF(server.players.get(i).heros.get(2).updateInfo());
            }                  
        }      
       
       
   }
   
   
   //se copia la matriz
   public void updateMatrizCliente() throws IOException{

          for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            
            if(current.nombre.equals(server.players.get(i).nombre)){
                
                current.writer.writeInt(6);
                
                for(int row = 0; row < server.players.get(i).tablero.length; row++)
                    for(int col = 0; col < server.players.get(i).tablero[row].length; col++){
                       
                        current.writer.writeUTF(server.players.get(i).tablero[row][col].heroOwner);      //se manda 1.Nombre, 2.Vida, 3.VolcanoActiva, 4.WhirlpoolActive
                        current.writer.writeInt(server.players.get(i).tablero[row][col].vida);
                        if(server.players.get(i).tablero[row][col].activeVolcano)
                          current.writer.writeInt(1);
                        else
                            current.writer.writeInt(0);
                        if(server.players.get(i).tablero[row][col].activeWhirlpool)
                            current.writer.writeInt(1);
                        else 
                            current.writer.writeInt(0);
                    }
            }                  
        }    
   }
   
   
   public void mandarBitacora(String msj) throws IOException{
         for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            current.writer.writeInt(9);
            current.writer.writeUTF(msj);
            current.writer.writeUTF(msj);             
        }      
   }
   
    public void mandarBitacoraPoder(String msj) throws IOException{
         for(int i = 0; i < server.conexiones.size(); i++){
            ThreadServer current = server.conexiones.get(i);
            current.writer.writeInt(10);
            current.writer.writeUTF(msj);             
        }      
   }
   
   
   public void pasarTurno() throws IOException {
       
    String nextTurn = server.getNextTurno();
    for(int i = 0; i < server.conexiones.size(); i++){
      ThreadServer current = server.conexiones.get(i);
      current.writer.writeInt(1);
      current.writer.writeUTF(nextTurn);                 
     }           
   }
    
   
    public void run(){
        
        int instruccionID = 1;
        while(running){
            
            
            if(server.ordenPlayers.size() == 1){
                
               
               String msj = "\n\n"+server.ordenPlayers.get(0).nombre + " is the last player standing and has won the game!!!!!\n\n"; 
                for(int i = 0; i < server.conexiones.size(); i++){
                    ThreadServer current = server.conexiones.get(i);

                    try {
                        current.writer.writeInt(4);
                        current.writer.writeUTF(msj);  
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return;
            }
            
            try {
               instruccionID = reader.readInt(); //espera hasta recibir un entero
               String usuario = "";  //variable de usuario para utilizar en todos los casos
               Player jugadorTmp = null; //variable de player para utilizar en cualquier caso
               String msj = ""; //variable para utilizar a lo largo de los casos
               
               
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
                               
                               String heroInfoTablero = "100%" + "\n" + ( (int)(((double) percentCivilization/ (double)100)* (double)600)) +" out of " + ((int)(((double) percentCivilization/ (double)100)* (double)600)) + " casillas";
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
       
                       else if(comandos[0].equals("start")){  //comando para dar ready game y si es el caso, comenzar el juego
                           
                           jugadorTmp = server.buscarPlayer(usuario);
                             //does player have 3 heros                         
                             
                           if(!jugadorTmp.readyGame()){
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. You haven't created your 3 heros yet and aren't ready to start!");
                               break;
                           }
                           
                            for(int i = 0; i < server.conexiones.size(); i++){
                                ThreadServer current = server.conexiones.get(i);
                                current.writer.writeInt(4);
                                current.writer.writeUTF(usuario + " is ready to start the game!");                 
                            }                         
                           
                           
                           if(server.areAllReady()){
                               
                                for(int i = 0; i < server.conexiones.size(); i++){
                                  ThreadServer current = server.conexiones.get(i);
                                  current.writer.writeInt(4);
                                  current.writer.writeUTF("The game has officially started!!!");                 
                                 }
                                
                                updateMatrizCliente();
                                
                                for(int i = 0; i < server.conexiones.size(); i++){
                                    ThreadServer current = server.conexiones.get(i);
                                    current.writer.writeInt(1);
                                    current.writer.writeUTF(server.ordenPlayers.get(0).nombre);                 
                                }
                           }

                       }
                       
                       else if(comandos[0].equals("play")){  //comando para realizar una jugada/ataque a un jugador, ya sea con el un ataque o habilidad de un heroe
                           
                           
                           if(server.getTurno().equals(usuario)){
                               
                               jugadorTmp = server.buscarPlayer(usuario);
                               Hero heroTmp = jugadorTmp.buscarHero(comandos[1]);
                               if(heroTmp != null){
                                   
                                   String jugadaDeseada = comandos[2];
                                   
                                   if(heroTmp.validAbility(jugadaDeseada)){
                                       
                                       
                                       if(jugadaDeseada.equals("healing")){
                                           mandarBitacora(jugadorTmp.healing(heroTmp));
                                       }
                                       else if(jugadaDeseada.equals("strength")){
                                           mandarBitacora(jugadorTmp.strength(heroTmp));  
                                       }
                                       else if(jugadaDeseada.equals("resistance")){  
                                           mandarBitacora(jugadorTmp.resistance(heroTmp)); 
                                       }
                                       
                                        updateTableroHeros();    //se actualizan los valor que estan debajo del tablero
                                        updateMatrizCliente();  //se actualizan las matrices de los clientes
                                        pasarTurno();   //pasar de turno                                                    
                                   }
                                   
                                   
                                   else if(heroTmp.validSuperpower(jugadaDeseada)){
                                       
                                       String ataqueDeseado = comandos[3];
                                       Player jugadorTarget = server.buscarPlayer(comandos[4]);
                                       String resultado = "";
                                       
                                       if(jugadaDeseada.equals("thundersunderthesea")){
                                           if(heroTmp.estaSuperpower(jugadaDeseada)){                                    
                                               if(ataqueDeseado.equals("thunderrain")){
                                                  resultado = heroTmp.buscarThunder(jugadaDeseada).attack1(jugadorTarget, jugadorTmp, heroTmp.strengthTmp);
                                                  heroTmp.strengthTmp = 0;
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                                  //
                                               } 
                                               else if(ataqueDeseado.equals("poseidonthunders")){
                                                  resultado = heroTmp.buscarThunder(jugadaDeseada).attack2(jugadorTarget, jugadorTmp);
                                                  mandarBitacora(resultado); 
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               }
                                               else if(ataqueDeseado.equals("eelattack")){
                                                  resultado = heroTmp.buscarThunder(jugadaDeseada).attack3(jugadorTarget, jugadorTmp, heroTmp.strengthTmp);
                                                  heroTmp.strengthTmp = 0;
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               }
                                               else{
                                                  writer.writeInt(2);
                                                  writer.writeUTF("ERROR. Invalid command!");
                                                  break;   
                                               }                          
                                           }  
                                                                              else{
                                          writer.writeInt(2);
                                          writer.writeUTF("ERROR. Invalid command!");
                                          break;       
                                   }
                                       }
                                       
                                       else if(jugadaDeseada.equals("fishtelepathy")){
                                            if(heroTmp.estaSuperpower(jugadaDeseada)){
                                               if(ataqueDeseado.equals("cardumen")){
                                                  resultado = heroTmp.buscarFish(jugadaDeseada).attack1(jugadorTarget, jugadorTmp, heroTmp.strengthTmp);
                                                  heroTmp.strengthTmp = 0;
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               } 
                                               else if(ataqueDeseado.equals("sharkattack")){
                                                  resultado = heroTmp.buscarFish(jugadaDeseada).attack2(jugadorTarget, jugadorTmp);
                                                  mandarBitacora(resultado); 
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               }
                                               else if(ataqueDeseado.equals("pulp")){
                                                  resultado = heroTmp.buscarFish(jugadaDeseada).attack3(jugadorTarget, jugadorTmp, heroTmp.strengthTmp);
                                                  heroTmp.strengthTmp = 0;
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               }
                                               else{
                                                  writer.writeInt(2);
                                                  writer.writeUTF("ERROR. Invalid command!");
                                                  break;   
                                               }                                                                                   
                                           }   
                                                                               else{
                                          writer.writeInt(2);
                                          writer.writeUTF("ERROR. Invalid command!");
                                          break;       
                                   }
                                       }
                                       
                                       else if(jugadaDeseada.equals("wavescontrol")){
                                            if(heroTmp.estaSuperpower(jugadaDeseada)){
                                               if(ataqueDeseado.equals("swirlraising")){
                                                  resultado = heroTmp.buscarWaves(jugadaDeseada).attack1(jugadorTarget, jugadorTmp);
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               } 
                                               else if(ataqueDeseado.equals("sendhumangarbage")){
                                                  int x = Integer.parseInt(comandos[6]);
                                                  int y = Integer.parseInt(comandos[8]);
                                                  resultado = heroTmp.buscarWaves(jugadaDeseada).attack2(jugadorTarget, jugadorTmp,heroTmp.strengthTmp, x, y);
                                                  heroTmp.strengthTmp = 0;
                                                  mandarBitacora(resultado);       
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               }
                                               else if(ataqueDeseado.equals("radioactiverush")){
                                                  resultado = heroTmp.buscarWaves(jugadaDeseada).attack3(jugadorTarget, jugadorTmp, heroTmp.strengthTmp);
                                                  heroTmp.strengthTmp = 0;
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               }
                                               else{
                                                  writer.writeInt(2);
                                                  writer.writeUTF("ERROR. Invalid command!");
                                                  break;   
                                               }                                                   
                                           }
                                                                               else{
                                          writer.writeInt(2);
                                          writer.writeUTF("ERROR. Invalid command!");
                                          break;       
                                   }
                                       }
                                       
                                       else if(jugadaDeseada.equals("thetrident")){
                                            if(heroTmp.estaSuperpower(jugadaDeseada)){
                                               if(ataqueDeseado.equals("threelines")){
                                                  int x1 = Integer.parseInt(comandos[6]);
                                                  int y1 = Integer.parseInt(comandos[8]);
                                                  int x2 = Integer.parseInt(comandos[10]);
                                                  int y2 = Integer.parseInt(comandos[12]);                                                 
                                                  int x3 = Integer.parseInt(comandos[14]);
                                                  int y3 = Integer.parseInt(comandos[16]);         
                                                  resultado = heroTmp.buscarTrident(jugadaDeseada).attack1(jugadorTarget, jugadorTmp, x1, x2, x3, y1, y2, y3);
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               } 
                                               else if(ataqueDeseado.equals("threenumbers")){
                                                   
                                                   server.tridentNum1 = Integer.parseInt(comandos[5]);
                                                   server.tridentNum2 = Integer.parseInt(comandos[6]);
                                                   server.tridentNum3 = Integer.parseInt(comandos[7]);
                                                   server.tridentRetador = jugadorTmp;
                                                   server.tridentHeroRetador = heroTmp;
                                                   
                                                   msj = "ALERT! You have been attacked by The Trident - Three numbers from " + jugadorTmp.nombre + "! Enter the following command and choose 3 numbers to defend yourself!  "
                                                           + "threenumbers-num1-num2-num3";

                                                   for(int i = 0; i < server.conexiones.size(); i++){
                                                       ThreadServer current = server.conexiones.get(i);
                                                       if(current.nombre.equals(jugadorTarget.nombre)){
                                                           current.writer.writeInt(4);
                                                           current.writer.writeUTF(msj);
                                                       }
                                                   } 
                                                   break;
                                               }
                                               else if(ataqueDeseado.equals("controlthekraken")){
                                                  resultado = heroTmp.buscarTrident(jugadaDeseada).attack3(jugadorTarget, jugadorTmp);
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               }
                                               else{
                                                  writer.writeInt(2);
                                                  writer.writeUTF("ERROR. Invalid command!");
                                                  break;   
                                               }                                                   
                                           }
                                            
                                                                               else{
                                          writer.writeInt(2);
                                          writer.writeUTF("ERROR. Invalid command!");
                                          break;       
                                   }
                                       }                                      
                                       
                                       else if(jugadaDeseada.equals("underseavolcanoes")){
                                            if(heroTmp.estaSuperpower(jugadaDeseada)){
                                               if(ataqueDeseado.equals("volcanoraising")){
                                                  resultado = heroTmp.buscarVolcano(jugadaDeseada).attack1(jugadorTarget, jugadorTmp);
                                                  heroTmp.strengthTmp = 0;
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               } 
                                               else if(ataqueDeseado.equals("volcanoexplosion")){
                                                  int x = Integer.parseInt(comandos[6]);
                                                  int y = Integer.parseInt(comandos[8]);
                                                  resultado = heroTmp.buscarVolcano(jugadaDeseada).attack2(jugadorTarget, jugadorTmp, heroTmp.strengthTmp, x, y);
                                                  mandarBitacora(resultado);    
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               }
                                               else if(ataqueDeseado.equals("thermalrush")){
                                                  int x = Integer.parseInt(comandos[6]);
                                                  int y = Integer.parseInt(comandos[8]);                                                   
                                                  resultado = heroTmp.buscarVolcano(jugadaDeseada).attack3(jugadorTarget, jugadorTmp, x, y, heroTmp.strengthTmp);
                                                  heroTmp.strengthTmp = 0;
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               }
                                               else{
                                                  writer.writeInt(2);
                                                  writer.writeUTF("ERROR. Invalid command!");
                                                  break;   
                                               }                                                          
                                           }
                                            
                                                                               else{
                                          writer.writeInt(2);
                                          writer.writeUTF("ERROR. Invalid command!");
                                          break;       
                                   }
                                            
                                       }    
                                       
                                       else if(jugadaDeseada.equals("releasethekraken")){
                                            if(heroTmp.estaSuperpower(jugadaDeseada)){
                                               if(ataqueDeseado.equals("tentaculos")){
                                                  resultado = heroTmp.buscarKraken(jugadaDeseada).attack1(jugadorTarget, jugadorTmp);
                                                   System.out.println("resultado: " + resultado);
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               } 
                                               else if(ataqueDeseado.equals("krakenbreath")){
                                                  int x = Integer.parseInt(comandos[6]);
                                                  int y = Integer.parseInt(comandos[8]);
                                                  resultado = heroTmp.buscarKraken(jugadaDeseada).attack2(jugadorTarget, jugadorTmp,x, y);
                                                  mandarBitacora(resultado);  
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               }
                                               else if(ataqueDeseado.equals("releasethekraken")){
                                                  resultado = heroTmp.buscarKraken(jugadaDeseada).attack3(jugadorTarget, jugadorTmp);
                                                  mandarBitacora(resultado);
                                                  mandarBitacoraPoder(server.absorberPoder(jugadorTmp, heroTmp, jugadorTarget));
                                                  updateInfoPowers();
                                               }
                                               else{
                                                  writer.writeInt(2);
                                                  writer.writeUTF("ERROR. Invalid command!");
                                                  break;   
                                               }                                                    
                                           }
                                           else{
                                            writer.writeInt(2);
                                            writer.writeUTF("ERROR. Invalid command!");
                                            break;       
                                           }
                                       }                                       
                                       updateTableroHeros();    //se actualizan los valor que estan debajo del tablero
                                       updateMatrizCliente();  //se actualizan las matrices de los clientes
                                       pasarTurno();   //pasar de turno
                                   }
                                   else{
                                          writer.writeInt(2);
                                          writer.writeUTF("ERROR. Invalid command!");
                                          break;       
                                   }
                               }
                               else{
                                writer.writeInt(2);
                                writer.writeUTF("ERROR. Invalid command!");
                                break;   
                               }             
                           }
                           else{                  // no es el turno del jugador
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. It is not your turn!"); 
                           }
                       }
                       
                       
                       else if(comandos[0].equals("skip")){ //comando para saltarse su turno y no atacar
                         
                           if(server.getTurno().equals(usuario)){
                               
                                for(int i = 0; i < server.conexiones.size(); i++){
                                  ThreadServer current = server.conexiones.get(i);
                                  current.writer.writeInt(4);
                                  current.writer.writeUTF(usuario + " has skipped his turn!");                 
                                 }

                                pasarTurno();
 
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
                           
                            if(server.getTurno().equals(usuario)){
                               
                                jugadorTmp = server.buscarPlayer(usuario);
                                jugadorTmp.surrender();
                                server.ordenPlayers.remove(jugadorTmp);
                                
                                for(int i = 0; i < server.conexiones.size(); i++){
                                    ThreadServer current = server.conexiones.get(i);
                                    current.writer.writeInt(4);
                                    current.writer.writeUTF(usuario + " has surrendered!");                 
                                 }        
                           
                                updateTableroHeros();    //se actualizan los datos de los heroes de los tableros
                                updateMatrizCliente();   //se actualiza la matriz del cliente
                                pasarTurno();    //pasar de turno
                                
                           }
                           else{
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. It is not your turn!"); 
                           }  
                       }
                       
                       else if(comandos[0].equals("cellstatus")){ //comando para solicitar el estado de una casilla, incluye vida, estado (vivo o muerto) y lista cronologica de ataques                    
                           
                           jugadorTmp = server.buscarPlayer(usuario);
                           int col = Integer.parseInt(comandos[1]);
                           int row = Integer.parseInt(comandos[2]);
                           writer.writeInt(4);
                           writer.writeUTF(jugadorTmp.cellStatus(row, col));      
                       }  
                       
                       else if(comandos[0].equals("logsummary")){ //comando que da cuántos ataques se han realizado y cuál es el porcentaje de éxito, cuántos aitnaron, cuántos no.
                           
                           jugadorTmp = server.buscarPlayer(usuario);
                           writer.writeInt(4);
                           writer.writeUTF(jugadorTmp.logSummary());                    
       
                       }                       
                       
                       else if(comandos[0].equals("enemystatus")){ // comando que muestra el estado del enemigo: porcentaje de vida, casillas de muertas del total.
                           
                           Player jugadorTmp2 = server.buscarPlayer(comandos[1]);
                           if(jugadorTmp2 == null)
                               break;
                           
                           writer.writeInt(4);
                           writer.writeUTF(jugadorTmp2.updateStatusMessage());                           
                       }
                       
                       else if(comandos[0].equals("showcells")){
                           
                           if(comandos[1].equals("occupied")){
                               writer.writeInt(8);
                           }
                           else if(comandos[1].equals("alive")){
                               writer.writeInt(7); //se llama caso para mostrar con x
                           } 
                           else{
                               writer.writeInt(2);
                               writer.writeUTF("ERROR. Invalid command!");                              
                           }
                       }
                       
                       else if(comandos[0].equals("threenumbers")){
                           
                          int num1 = Integer.parseInt(comandos[1]);
                          int num2 = Integer.parseInt(comandos[2]);
                          int num3 = Integer.parseInt(comandos[3]);
                          boolean resultado = false;
                          
                          if(num1 == server.tridentNum1 || num1 == server.tridentNum2 || num1 == server.tridentNum3)
                              resultado = true;
                          if(num2 == server.tridentNum1 || num2 == server.tridentNum2 || num2 == server.tridentNum3)
                              resultado = true;
                          if(num3 == server.tridentNum1 || num3 == server.tridentNum2 || num3 == server.tridentNum3)
                              resultado = true;
                          
                          if(resultado){
                              
                              int cantDest = server.tridentNum1 * server.tridentNum2 * server.tridentNum3;
                              jugadorTmp = server.buscarPlayer(usuario);
                              String res = server.tridentHeroRetador.buscarTrident("thetrident").attack2(jugadorTmp, server.tridentRetador, cantDest);
                              mandarBitacora(res);
                              mandarBitacoraPoder(server.absorberPoder(server.tridentRetador, server.tridentHeroRetador, jugadorTmp));
                              updateInfoPowers();
                              updateTableroHeros();    //se actualizan los valor que estan debajo del tablero
                              updateMatrizCliente();  //se actualizan las matrices de los clientes
                              pasarTurno();   //pasar de turno                              
                          }     
                          else{
                             mandarBitacoraPoder("No coincidieron ninguno de los numeros!");
                             pasarTurno();
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
