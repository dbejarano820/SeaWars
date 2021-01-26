/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author PERSONAL
 */
public class ThreadPlayer extends Thread {
    
   
    private Socket socketRef;
    public Cliente refCliente;
    public DataInputStream reader; 
    public DataOutputStream writer;
    private boolean running = true;
    private PantallaCliente refPantalla;

    public ThreadPlayer(Socket socketRef, PantallaCliente refPantalla, Cliente refCliente) throws IOException {
        this.socketRef = socketRef;
        this.refCliente = refCliente;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        this.refPantalla = refPantalla;
    }
        
    public void run (){
        
        int instruccionId = 1;
        while (running){
            try {
                String usuario = "";
                String msj = "";
                instruccionId = reader.readInt(); // esperar hasta que reciba un entero
                
                switch (instruccionId){
                    case 1: // recibe el turno del jugador que le toca
                        usuario = reader.readUTF(); 
                        refPantalla.setNombreTurno(usuario);
                        refPantalla.pintarTurno(usuario);
                        refPantalla.colorMatriz();
                        
                        
                    break;
                    
                    case 2: // recibe el usuario y el msj del comando invalido/respuesta de la consola
                        msj = reader.readUTF();
                        refPantalla.addConsolaMsj(msj);
                    break;
                    
                    case 3: //recibe info de los heroes correspondientes para pintarlos..
                        String nombreHero = reader.readUTF();
                        String heroUpdate = reader.readUTF();
                        String pathImage = reader.readUTF();
                        int cantidadHeros = reader.readInt();
                        String heroTableroInfo = reader.readUTF();
                        
                        
                        if(cantidadHeros == 1){
                            refPantalla.setInfoHero1Tablero(nombreHero, heroTableroInfo);
                            refPantalla.addHero1Image(pathImage);
                            refPantalla.addHeroInfo1(nombreHero,heroUpdate);
                        }
                        else if (cantidadHeros == 2){
                            refPantalla.setInfoHero2Tablero(nombreHero, heroTableroInfo);
                            refPantalla.addHero2Image(pathImage);
                            refPantalla.addHeroInfo2(nombreHero, heroUpdate);
                        }
                        else if (cantidadHeros == 3){
                            refPantalla.setInfoHero3Tablero(nombreHero, heroTableroInfo);
                            refPantalla.addHero3Image(pathImage);
                            refPantalla.addHeroInfo3(nombreHero, heroUpdate);
                        }
   
                    break;
                    
                    case 4: //recibe info para la consola

                        msj = reader.readUTF();
                        refPantalla.addConsolaMsj(msj);

                    break;
                    
                    case 5: //update infos de tablero for each player indicidualmente
                        
                        String hero1 = reader.readUTF();
                        String hero2 = reader.readUTF();
                        String hero3 = reader.readUTF();
                        int vidaaTmp = reader.readInt();
                        int muertasTmp = reader.readInt();
                        
                        refPantalla.addInfoHero1Tablero(hero1);
                        refPantalla.addInfoHero2Tablero(hero2);
                        refPantalla.addInfoHero3Tablero(hero3);
                        refPantalla.updateVida(vidaaTmp);
                        refPantalla.updateMuertas(muertasTmp);

                    break;
                    
                    case 6: //se actualiza la matriz del player server al cliente  // fue aca
                        
                        for(int row = 0; row < refCliente.tableroCliente.length; row++)
                            for(int col = 0; col < refCliente.tableroCliente[row].length; col++){
                            
                                String nombreTmp = reader.readUTF();
                                int vidaTmp = reader.readInt();
                                
                                refCliente.tableroCliente[row][col].heroOwner = nombreTmp;                          
                                refCliente.tableroCliente[row][col].vida = vidaTmp;
                                int volcano = reader.readInt();
                                int whirpool = reader.readInt();
                                
                                if(volcano == 1)
                                   refCliente.tableroCliente[row][col].activeVolcano = true;
                                else 
                                    refCliente.tableroCliente[row][col].activeVolcano = false;
                                
                                if(whirpool == 2)
                                    refCliente.tableroCliente[row][col].activeWhirlpool = true;
                                else 
                                    refCliente.tableroCliente[row][col].activeWhirlpool = false;
                            }
                        
                        
                   break;
                   
                   case 7: //caso para mostar casillas vivas
                       refPantalla.mostrarVivas();
                   break;
                   
                   case 8: //caso para pintar los volcanes y remolinos en las casillas
                       refPantalla.mostrarVolcanesRemolinos("C:\\Users\\PERSONAL\\OneDrive\\Documents\\GitHub\\SeaWars\\SeaWars\\src\\Images\\Volcano.png", "C:\\Users\\PERSONAL\\OneDrive\\Documents\\GitHub\\SeaWars\\SeaWars\\src\\Images\\Whirlpool.png");
                    
                   break;
                        
                } 
            } catch (IOException ex) {
                
            }
        }
    }    
    
    
    
    
    
    
    
    
    
}
