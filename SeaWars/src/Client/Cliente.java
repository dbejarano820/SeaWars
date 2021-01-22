/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.net.Socket;
import javax.swing.JOptionPane;




public class Cliente {
    
    
    Socket socketRef;
    PantallaCliente refPantalla;
    public ThreadPlayer hiloPlayer;
    
    boolean prerolled;
    boolean gameready;
    int consecutiveRolls;
    
    String nombre;
    
    
    
        public void conectar(){

        try{
            
            socketRef = new Socket("localhost", 35577);
              
            hiloPlayer = new ThreadPlayer(socketRef, refPantalla, this, refPrePantalla);
            hiloPlayer.start();
            String nombreTmp = JOptionPane.showInputDialog("Introduzca un Nick:");
            this.nombre = nombreTmp;
 //int gay = JOptionPane.showConfirmDialog(refPantalla, "Pagar");
       //     JOptionPane.showMessageDialog(refPantalla, "CAREPICHA");
            refPantalla.setTitle(nombre);
            refPrePantalla.setTitle(nombre + " -- Pregame");
            hiloPlayer.writer.writeInt(1); //instruccion para el switch del thraed servidor
            hiloPlayer.writer.writeUTF(nombre); //instruccion para el switch del thraed servidor
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }   
    }
    
    
    
}
